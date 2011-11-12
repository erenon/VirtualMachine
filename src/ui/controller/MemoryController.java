package ui.controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.SerializableMemoryContent;

import device.AddressingException;
import device.VmMemory;

public class MemoryController {
	private VmMemory memory;
	private int memorySize;
	private File currentOpenedFile = null;
	
	public MemoryController(VmMemory memory, int memorySize) {
		this.memory = memory;
		this.memorySize = memorySize;
	}
	
	public void newMemoryContent(ActionEvent event) {
		// fill memory with empty strings
		for (int address = 0; address < memorySize; address++) {
			try {
				memory.putWord(address, "");
			} catch (AddressingException e) {
				e.printStackTrace();
				break;
			}
		}
		
		// new memory content is bound to no file
		currentOpenedFile = null;
	}
	
	public void loadMemoryContent(ActionEvent event) {
		JFileChooser chooserDialog = getDialog();
        int returnVal = chooserDialog.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File openedFile = chooserDialog.getSelectedFile();
            
            FileInputStream inputStream = null;
            ObjectInputStream objectStream = null;
            try {
            	inputStream = new FileInputStream(openedFile);
            	objectStream = new ObjectInputStream(inputStream);
            	
            	SerializableMemoryContent content = null;
            	content = (SerializableMemoryContent) objectStream.readObject();
            	
            	content.exportToMemory(memory, memorySize);
            	
            	currentOpenedFile = openedFile;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					objectStream.close();
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        }
	}
	
	public void storeMemoryContent(ActionEvent event) {
		if (currentOpenedFile == null) {
			storeMemoryContentAs(event);
		} else {
			writeMemoryIntoFile(currentOpenedFile);
		}
	}
	
	public void storeMemoryContentAs(ActionEvent event) {
		JFileChooser chooserDialog = getDialog();
        int returnVal = chooserDialog.showSaveDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File targetFile = chooserDialog.getSelectedFile();
            writeMemoryIntoFile(targetFile);
            currentOpenedFile = targetFile;
        }
	}
	
	private JFileChooser getDialog() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Memory files (*.mem)", "mem"); 
		JFileChooser chooserDialog = new JFileChooser();
		chooserDialog.setFileFilter(filter);
		
		return chooserDialog;
	}
	
	private void writeMemoryIntoFile(File file) {
        FileOutputStream outputStream = null;
        ObjectOutputStream objectStream = null;
		try {
			outputStream = new FileOutputStream(file);
			objectStream = new ObjectOutputStream(outputStream);
			
			// create content
			SerializableMemoryContent content = new SerializableMemoryContent();
			content.importFromMemory(memory, memorySize);
			
			// write out
			objectStream.writeObject(content);
			objectStream.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
}
