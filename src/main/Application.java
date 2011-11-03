package main;


import computer.Computer;
import computer.NoCpuSetException;

import cpu.NoBusSetException;
import cpu.VmCpu;
import device.AddressingException;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.setCpu(new VmCpu());
		try {
			computer.start();
		} catch (NoCpuSetException e) {
			e.printStackTrace();
		} catch (NoBusSetException e) {
			e.printStackTrace();
		} catch (AddressingException e) {
			e.printStackTrace();
		}
	}

}
