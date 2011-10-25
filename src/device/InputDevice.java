package device;

public interface InputDevice extends Device {
	public String getWord(int address) throws AddressingException ;
}
