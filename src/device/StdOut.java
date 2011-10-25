package device;

public class StdOut implements OutputDevice {

	@Override
	public void putWord(int address, String word) throws AddressingException {
		if (address != 0) {
			throw new AddressingException();
		}
		
		System.out.print(word);
	}

}
