package cpu;

import device.Bus;

public class VmCpu implements Cpu {
	Bus bus;
	
	@Override
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

}
