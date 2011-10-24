package cpu;

import device.AddressingException;
import device.Bus;

public class VmCpu implements Cpu, InstructionRunner {
	private Bus bus = null;
	private ProgramCounter pc = new ProgramCounter();
	private boolean doesProgramEnded = false;
	
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
			// TODO here we are
			String word = fetchWord(currentPcState);
			// id instruction
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
			// call hw exception routine
			e.printStackTrace();
		}
		
		return word;
	}

	@Override
	public void exit() {
		doesProgramEnded = true;
	}

}
