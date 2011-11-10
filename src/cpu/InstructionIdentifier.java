package cpu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import util.Entry;

import cpu.instpar.ImmediateParameter;
import cpu.instpar.InstructionParameter;
import cpu.instpar.MemoryParameter;
import cpu.instpar.RegisterParameter;
import cpu.instruction.Instruction;

class InstructionIdentifier {
	/**
	 * Stores name-instruction mapping
	 */
	private Map<String, Instruction> instructionPool;
	
	public InstructionIdentifier() {
		instructionPool = new HashMap<String, Instruction>();
	}
	
	/**
	 * Adds an instruction to the instruction pool.
	 * 
	 * @param name Name of the instruction used in assembly code
	 * @param instruction Instruction instance
	 */
	public void addInstruction(String name, Instruction instruction) {
		instructionPool.put(name, instruction);
	}
	
	/**
	 * Gets the instruction from the instruction pool by name
	 * 
	 * @param instructionName
	 * @return The instruction found
	 * @throws UnidentifiableInstructionException if no instruction found with the given name
	 */
	private Instruction getInstruction(String instructionName) 
		throws UnidentifiableInstructionException 
	{
		if (instructionPool.containsKey(instructionName)) {
			return instructionPool.get(instructionName);
		} else {
			throw new UnidentifiableInstructionException();
		}
	}
	
	/**
	 * Identifies the given assembly code line.
	 * 
	 * Gets the type of the instruction and the parameters
	 * 
	 * @param word Assembly code line
	 * @return Entry of Instruction and parameters array
	 * @throws UnidentifiableInstructionException If word is null or undefined instruction
	 */
	public Entry<Instruction, InstructionParameter[]> identify(String word) 
		throws UnidentifiableInstructionException 
	{
		if (word == null || word.isEmpty()) {
			throw new UnidentifiableInstructionException();
		}
		
		// identify the instr. itself
		String[] parts = word.split(" ");
		Instruction instruction;
		
		// throws exc. if no such inst. found
		instruction = getInstruction(parts[0]);
		
		// identify parameter(s)
		String[] rawParameters = Arrays.copyOfRange(parts, 1, parts.length);
		InstructionParameter[] parameters = new InstructionParameter[rawParameters.length];
		
		int parameterIndex = 0;
		for (String parameter : rawParameters) {
			parameters[parameterIndex] = identifyParameter(parameter);
			parameterIndex++;
		}
		
		Entry<Instruction, InstructionParameter[]> instructionWithParameters =
			new Entry<Instruction, InstructionParameter[]>(instruction, parameters);
		
		return instructionWithParameters;
	}
	
	/**
	 * Parses an instruction parameter
	 * 
	 * Parameters can be 
	 *  - registers: %eax, %ebx, etc.
	 *  - memory fields: MEM[%eax], MEM[15], MEM[MEM[...]], etc.
	 *  - immediates: 0, 42, etc.
	 * 
	 * @param parameter String representation of the parameters
	 * @return The identified parameter
	 */
	public InstructionParameter identifyParameter(String parameter) {
		InstructionParameter identifiedParameter = null;
		
		if (parameter.charAt(0) == '%') {
			identifiedParameter = new RegisterParameter(parameter);
		} else if (parameter.startsWith("MEM[")) {
			identifiedParameter = new MemoryParameter(parameter);
		} else {
			identifiedParameter = new ImmediateParameter(parameter);
		}
		
		return identifiedParameter;
	}
}
