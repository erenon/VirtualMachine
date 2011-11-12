package computer;

import cpu.Cpu;
import cpu.NoBusSetException;
import device.Bus;
import device.Device;
import device.VmBus;

public class Computer {
	private Cpu cpu;
	private Bus bus = new VmBus();
	private int nextBusAddress = 0;

	public Computer(Cpu cpu) {
		this.cpu = cpu;
		this.cpu.setBus(bus);
	}
	
	public void addDevice(Device device, int addressWindowSize) {
		bus.addDevice(nextBusAddress, device);
		nextBusAddress += addressWindowSize;
	}
	
	public void step() {
		try {
			cpu.step();
		} catch (NoBusSetException e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		cpu.reset();
	}
	
	public void run() throws NoBusSetException {
		cpu.run();
	}
}
