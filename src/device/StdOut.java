package device;

public class StdOut implements OutputDevice {

	@Override
	public void putWord(int address, String word) throws AddressingException {
		if (address != 0) {
			throw new AddressingException();
		}
		
		// convert integer stored in string to ascii char
		int charCode = 0;
		try {
			charCode = Integer.parseInt(word);
		} catch (NumberFormatException e) {
			// word is not an integer's string representation
			System.out.print(word);
		}
		
		char c[] = null;
		try {
			c = Character.toChars(charCode);
		} catch (IllegalArgumentException e) {
			// can't convert to char array
			System.out.print(word);
		}
		
		System.out.print(c);
	}

}
