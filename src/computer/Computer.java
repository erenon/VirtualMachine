package computer;

import cpu.Cpu;

public class Computer {
	private Cpu cpu = null;

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	
	public void start() throws NoCpuSetException {
		if (cpu == null) {
			throw new NoCpuSetException();
		}
		
		cpu.start();
	}
}
