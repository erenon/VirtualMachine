package ui.controller;

import java.awt.event.ActionEvent;

import computer.Computer;
import cpu.NoBusSetException;

public class ComputerController {
	private Computer computer;
	
	public ComputerController(Computer computer) {
		this.computer = computer;
	}

	public void stepButtonClicked(ActionEvent event) {
		computer.step();
	}
	
	public void resetButtonClicked(ActionEvent event) {
		computer.reset();
	}
	
	public void runButtonClicked(ActionEvent event) {
		try {
			computer.run();
		} catch (NoBusSetException e) {
			// must set bus first
			e.printStackTrace();
		}
	}

}
