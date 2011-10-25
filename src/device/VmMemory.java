package device;

public class VmMemory implements InputDevice, OutputDevice {
	private String[] memory;
	private int blockSize;
	
	public VmMemory(int blockSize) {
		this.blockSize = blockSize;
		memory = new String[blockSize];
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
	}

}
