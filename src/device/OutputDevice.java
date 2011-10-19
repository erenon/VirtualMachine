package device;

public interface OutputDevice {
	public void putWord(int address, String word) throws AddressingException;
}
