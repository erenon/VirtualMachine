package util;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import device.AddressingException;
import device.VmMemory;

public class SerializableMemoryContent implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> content = new LinkedList<String>();
	
	public void importFromMemory(VmMemory memory, int memorySize) {
		content.clear();
		
		for (int address = 0; address < memorySize; address++) {
			try {
				content.add(memory.getWord(address));
			} catch (AddressingException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public void exportToMemory(VmMemory memory, int memorySize) {
		int upperBound = Math.min(memorySize, content.size());
		
		for (int address = 0; address < upperBound; address++) {
			try {
				memory.putWord(address, content.get(address));
			} catch (AddressingException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
