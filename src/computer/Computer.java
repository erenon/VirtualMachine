package computer;

import cpu.Cpu;
import cpu.NoBusSetException;
import device.AddressingException;
import device.Bus;
import device.VmBus;
import device.VmMemory;

public class Computer {
	private Cpu cpu = null;

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	
	public void start() throws NoCpuSetException, NoBusSetException, AddressingException {
		if (cpu == null) {
			throw new NoCpuSetException();
		}

		VmMemory memory = new VmMemory(1024);
		memory.putWord(0, "PUT 1024 MEM[1]");
		memory.putWord(1, "Hello World!");
		
		Bus bus = new VmBus();
		bus.addDevice(0, memory);
		
		cpu.setBus(bus);
		cpu.start();
	}
}
