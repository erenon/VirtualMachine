package device;

import java.util.HashSet;
import java.util.Set;

public class VmMemory implements InputDevice, OutputDevice {
	private String[] memory;
	private int blockSize;
	private Set<DeviceObserver> contentObservers;
	
	public VmMemory(int blockSize) {
		this.blockSize = blockSize;
		memory = new String[blockSize];
		
		contentObservers = new HashSet<DeviceObserver>();
	}
	
	public void addContentObserver(DeviceObserver observer) {
		contentObservers.add(observer);
	}
	
	@Override
	public String getWord(int address) throws AddressingException {
		if (address < 0 || address >= blockSize) {
			throw new AddressingException();
		}
		
		return memory[address];
	}

	@Override
	public void putWord(int address, String word) throws AddressingException {
		if (address < 0 || address >= blockSize) {
			throw new AddressingException();
		}
		
		memory[address] = word;
		
		// notify content observers about the content change
		for (DeviceObserver observer : contentObservers) {
			observer.fireDataChange(address);
		}
	}

}
