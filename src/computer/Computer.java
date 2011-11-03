package computer;

import cpu.Cpu;
import cpu.NoBusSetException;
import device.AddressingException;
import device.Bus;
import device.StdOut;
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
		memory.putWord(0, "OUT 1024 MEM[4]");
		memory.putWord(1, "OUT 1024 MEM[5]");
		memory.putWord(2, "OUT 1024 MEM[6]");
		memory.putWord(3, "RET");
		memory.putWord(4, "65");
		memory.putWord(5, "66");
		memory.putWord(6, "67");
		
		StdOut display = new StdOut();
		
		Bus bus = new VmBus();
		bus.addDevice(0, memory);
		bus.addDevice(1024, display);
		
		cpu.setBus(bus);
		cpu.start();
	}
}
