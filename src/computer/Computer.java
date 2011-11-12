package computer;

import cpu.Cpu;
import cpu.NoBusSetException;
import device.AddressingException;
import device.Bus;
import device.Device;
import device.StdOut;
import device.VmBus;
import device.VmMemory;

public class Computer {
	private Cpu cpu = null;
	private Bus bus = new VmBus();
	private int nextBusAddress = 0;

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	
	public void addDevice(Device device, int addressWindowSize) {
		bus.addDevice(nextBusAddress, device);
		nextBusAddress += addressWindowSize;
	}
	
	public void step() throws NoCpuSetException, NoBusSetException {
		if (cpu == null) {
			throw new NoCpuSetException();
		}
		
		// TODO don't repeat this
		cpu.setBus(bus);
		cpu.step();
	}
	
	public void reset() {
		cpu.reset();
	}
	
	/**
	 * Starts the virtual machine
	 * 
	 * @todo AddressingException is thrown by demo memory content write
	 * 
	 * @throws NoCpuSetException
	 * @throws NoBusSetException
	 * @throws AddressingException
	 */
	@Deprecated
	public void start() throws NoCpuSetException, NoBusSetException, AddressingException {
		if (cpu == null) {
			throw new NoCpuSetException();
		}

		VmMemory memory = new VmMemory(1024);
		memory.putWord(0, "OUT 1024 MEM[20]");
		memory.putWord(1, "MOV MEM[21] %ebx");
		memory.putWord(2, "OUT 1024 %ebx");
		memory.putWord(3, "MOV 67 %eax");
		memory.putWord(4, "OUT 1024 %eax");
		memory.putWord(5, "PUSH 68");
		memory.putWord(6, "POP %ecx");
		memory.putWord(7, "OUT 1024 %ecx");
		memory.putWord(8, "JMP 10");
		memory.putWord(9, "OUT 1024 %ecx");
		memory.putWord(10, "RET");
		
		memory.putWord(20, "65");
		memory.putWord(21, "66");
		
		StdOut display = new StdOut();
		
		Bus bus = new VmBus();
		bus.addDevice(0, memory);
		bus.addDevice(1024, display);
		
		cpu.setBus(bus);
		cpu.start();
	}
}
