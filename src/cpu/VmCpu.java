package cpu;

import device.Bus;

public class VmCpu implements Cpu, InstructionRunner {
	private Bus bus;
	private ProgramCounter pc = new ProgramCounter();
	private boolean doesProgramEnded = false;
	
	@Override
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public void start() {
		// while !doesProgramEnded
		while (doesProgramEnded == false) {
			// store pc current state
			int currentPcState = pc.getState();
			
			// fetch instruction from memory pointed by pc
			// TODO here we are
			// execute instruction
			
			// increment pc if not jump
			if (currentPcState == pc.getState()) {
				pc.increment();
			}
		}
	}
	
	/*public String fetchWordByPosition(int memoryPosition) {

		return null;
	}*/

	@Override
	public void exit() {
		doesProgramEnded = true;
	}

}
