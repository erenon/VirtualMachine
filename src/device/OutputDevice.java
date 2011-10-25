package device;

public interface OutputDevice extends Device{
	public void putWord(int address, String word) throws AddressingException;
}
