package cpu;

import java.util.HashMap;
import java.util.Map;

import util.Entry;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;
import cpu.instruction.Instruction;
import cpu.instruction.InvalidInstructionException;
import cpu.instruction.Mov;
import cpu.instruction.Out;
import cpu.instruction.Ret;
import device.AddressingException;
import device.Bus;

public class VmCpu implements Cpu, InstructionRunner {
	private Bus bus = null;
	private ProgramCounter pc = new ProgramCounter();
	private InstructionIdentifier id = new InstructionIdentifier();
	private Map<REGISTER_NAME, Integer> registers;
	private int currentStackframeIndex;
	
	public VmCpu() {
		// load available instructions
		id.addInstruction("MOV", new Mov());
		id.addInstruction("OUT", new Out());
		id.addInstruction("RET", new Ret());
		
		// init registers
		registers = new HashMap<InstructionRunner.REGISTER_NAME, Integer>();
		for (REGISTER_NAME name : REGISTER_NAME.values()) {
			registers.put(name, 0);
		}
	}
	
	@Override
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public void start() throws NoBusSetException {
		if (bus == null) {
			throw new NoBusSetException();
		}
		
		currentStackframeIndex = 1;
		// while !doesProgramEnded
		while (currentStackframeIndex > 0) {
			// store pc current state
			int currentPcState = pc.getState();
			
			// fetch instruction from memory pointed by pc
			// using bus
			String word = fetchWord(currentPcState);
			
			// id instruction
			Entry<Instruction, InstructionParameter[]> instructionWithParameters = null;
			try {
				instructionWithParameters = id.identify(word);
			} catch (UnidentifiableInstructionException e) {
				// TODO call sw exception routine
				e.printStackTrace();
			}
			
			Instruction instruction = instructionWithParameters.getKey();
			InstructionParameter[] parameters = instructionWithParameters.getValue();
			
			// execute instruction
			try {
				instruction.execute(this, parameters);
			} catch (InvalidInstructionException e) {
				// TODO call sw exception routine
				e.printStackTrace();
			} catch (InvalidParameterException e) {
				// TODO call sw exception routine
				e.printStackTrace();
			}
			
			// increment pc if not jump
			if (currentPcState == pc.getState()) {
				pc.increment();
			}
		}
	}
	
	public String fetchWord(int address) {
		String word = null;
		try {
			word = bus.getWord(address);
		} catch (AddressingException e) {
			// TODO call sw exception routine
			e.printStackTrace();
		}
		
		return word;
	}
	
	public void putWord(int address, String word) {
		try {
			bus.putWord(address, word);
		} catch (AddressingException e) {
			// TODO call sw exception routine
			e.printStackTrace();
		}
	}

	@Override
	public int getRegisterContent(REGISTER_NAME registerName) throws InvalidRegisterException {
		if (registers.containsKey(registerName)) {
			return registers.get(registerName);
		} else {
			throw new InvalidRegisterException();
		}
	}

	@Override
	public void setRegisterContent(REGISTER_NAME registerName, int content) throws InvalidRegisterException {
		if (registers.containsKey(registerName)) {
			registers.put(registerName, content);
		} else {
			throw new InvalidRegisterException();
		}
	}
	
	@Override
	public InstructionParameter identifyInstructionParameter(String parameter) {
		return id.identifyParameter(parameter);
	}

	@Override
	public void increaseStackframe() {
		currentStackframeIndex++;
		// TODO manage the actual stackframe
	}

	@Override
	public void decreaseStackframe() {
		currentStackframeIndex--;
		// TODO manage the actual stackframe
	}

}
