package cpu;

import java.util.HashMap;
import java.util.Map;

import util.Entry;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;
import cpu.instruction.Instruction;
import device.AddressingException;
import device.Bus;

public class VmCpu implements Cpu, InstructionRunner {
	private Bus bus = null;
	private ProgramCounter pc = new ProgramCounter();
	private InstructionIdentifier id = new InstructionIdentifier();
	private boolean doesProgramEnded = false;
	private Map<REGISTER_NAME, Integer> registers;
	
	public VmCpu() {
		// TODO load available instructions
		
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
		// while !doesProgramEnded
		while (doesProgramEnded == false) {
			// store pc current state
			int currentPcState = pc.getState();
			
			// fetch instruction from memory pointed by pc
			// using bus
			String word = fetchWord(currentPcState);
			
			// id instruction
			Entry<Instruction, InstructionParameter[]> instruction = null;
			try {
				instruction = id.identify(word);
			} catch (UnidentifiableInstructionException e) {
				// TODO Auto-generated catch block
				// call sw exception routine
				e.printStackTrace();
			}
			
			// load instruction parameters
			for (InstructionParameter parameter : instruction.getValue()) {
				try {
					parameter.loadValue(this);
				} catch (InvalidParameterException e) {
					// TODO Auto-generated catch block
					// call sw exception routine
					e.printStackTrace();
				}
			}
			
			// execute instruction
			
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
			// TODO Auto-generated catch block
			// call sw exception routine
			e.printStackTrace();
		}
		
		return word;
	}

	@Override
	public void exit() {
		doesProgramEnded = true;
	}

	@Override
	public int getRegisterContent(REGISTER_NAME registerName) throws InvalidRegisterException {
		if (registers.containsKey(registerName)) {
			return registers.get(registerName);
		} else {
			throw new InvalidRegisterException();
		}
	}

}
