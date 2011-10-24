package device;

import java.util.ArrayList;
import java.util.List;

import util.Entry;

public class VmBus extends Bus {
	List<Entry<Integer, Device>> devices;
	
	public VmBus() {
		devices = new ArrayList<Entry<Integer, Device>>();
	}
	
	@Override
	public void addDevice(Integer address, Device device) {
		Entry<Integer, Device> entry = new Entry<Integer, Device>(address, device);
		devices.add(entry);
	}
	
	private Entry<Integer, Device> getDeviceEntry(Integer address) {
		int minDelta = address + 1;
		Entry<Integer, Device> selectedEntry = null;
		
		for (Entry<Integer, Device> entry : devices) {
			if (address >= entry.getKey() 
			&& address - entry.getKey() < minDelta) {
				// current entry's start address is
				// the closest to the selected address so far
				// store it
				selectedEntry = entry;
				minDelta = address - entry.getKey();
			}
		}
		
		return selectedEntry;
	}
	
	@Override
	public void putWord(int address, String word) throws AddressingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getWord(int address) throws AddressingException {
		Entry<Integer, Device> deviceEntry = getDeviceEntry(address);
		
		// check for inputDevice
		if (deviceEntry.getValue() instanceof InputDevice) {
			InputDevice device = (InputDevice)deviceEntry.getValue();
			int relativeAddress = address - deviceEntry.getKey();
			
			return device.getWord(relativeAddress);
		} else {
			// selected device is not input device.
			throw new AddressingException();
		}
	}

}
