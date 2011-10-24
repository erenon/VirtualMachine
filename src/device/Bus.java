package device;

public abstract class Bus implements InputDevice, OutputDevice {

	public abstract void addDevice(Integer address, Device device);
	public abstract void putWord(int address, String word) throws AddressingException;
	public abstract String getWord(int address) throws AddressingException;

}
