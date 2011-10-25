package cpu;

import util.Entry;
import cpu.instpar.InstructionParameter;
import cpu.instruction.Instruction;
import device.AddressingException;
import device.Bus;

public class VmCpu implements Cpu, InstructionRunner {
	private Bus bus = null;
	private ProgramCounter pc = new ProgramCounter();
	private InstructionIdentifier id = new InstructionIdentifier();
	private boolean doesProgramEnded = false;
	
	public VmCpu() {
		// TODO load available instructions
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
				// parameter.loadValue(...resources...);
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

}
