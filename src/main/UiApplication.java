package main;

import computer.Computer;
import cpu.InstructionRunner;
import cpu.VmCpu;

import device.AddressingException;
import device.StdOut;
import device.VmDisplay;
import device.VmMemory;
import ui.controller.ComputerController;
import ui.model.DisplayModel;
import ui.model.MemoryContentModel;
import ui.view.FrontView;
import ui.view.MemoryContentView;

public class UiApplication {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final FrontView view = new FrontView();
		
		// create computer
		Computer computer = new Computer();
		ComputerController computerController = new ComputerController(computer);
		view.setComputerController(computerController);
		
		// cpu
		VmCpu cpu = new VmCpu();
		InstructionRunner runner = (InstructionRunner) cpu;
		computer.setCpu(cpu);
		
		// create memory
		int memorySize = 1024;
		VmMemory memory = new VmMemory(memorySize);
		setMemoryContent(memory);
		computer.addDevice(memory, memorySize);
		
		MemoryContentModel memoryContentModel = new MemoryContentModel(memory, memorySize, runner);
		view.setMemoryContentModel(memoryContentModel);
		// model as observer
		cpu.addPcObserver(memoryContentModel);
		memory.addContentObserver(memoryContentModel);
		
		MemoryContentView memoryContentView = new MemoryContentView();
		view.setMemoryContentView(memoryContentView);
		
		
		// display
		DisplayModel displayModel = new DisplayModel();
		VmDisplay display = new VmDisplay(displayModel);
		
		computer.addDevice(display, 1);
		view.setDisplayModel(displayModel);
		
		// debug std out
		computer.addDevice(new StdOut(), 1);
		
		// init and show view
		view.init();
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				view.setVisible(true);
			}
		});
	}
	
	public static void setMemoryContent(VmMemory memory) {
		// TODO remove this demo method
		try {
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
			memory.putWord(10, "MOV %eax MEM[15]");
			memory.putWord(11, "RET");
			
			memory.putWord(20, "65");
			memory.putWord(21, "66");
		} catch (AddressingException e) {
			e.printStackTrace();
		}
	}

}
