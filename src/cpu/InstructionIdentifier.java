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
	private Map<String, Instruction> instructionNames;
	
	public InstructionIdentifier() {
		instructionNames = new HashMap<String, Instruction>();
	}
	
	public void addInstruction(String name, Instruction instruction) {
		instructionNames.put(name, instruction);
	}
	
	private Instruction getInstruction(String instructionName) 
		throws UnidentifiableInstructionException 
	{
		if (instructionNames.containsKey(instructionName)) {
			return instructionNames.get(instructionName);
		} else {
			throw new UnidentifiableInstructionException();
		}
	}
	
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
