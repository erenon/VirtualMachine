package ui.controller;

import java.awt.event.ActionEvent;

import computer.Computer;
import computer.NoCpuSetException;
import cpu.NoBusSetException;

public class ComputerController {
	private Computer computer;
	
	public ComputerController(Computer computer) {
		this.computer = computer;
	}

	public void stepButtonClicked(ActionEvent event) {
		try {
			computer.step();
		} catch (NoCpuSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoBusSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resetButtonClicked(ActionEvent event) {
		computer.reset();
	}

}
