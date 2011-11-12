package device;

import ui.model.DisplayModel;

public class VmDisplay implements OutputDevice {
	DisplayModel model;
	
	public VmDisplay(DisplayModel model) {
		this.model = model;
	}
	
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
			e.printStackTrace();
			model.putWord(word);
		}
		
		char c[] = null;
		try {
			c = Character.toChars(charCode);
		} catch (IllegalArgumentException e) {
			// can't convert to char array
			e.printStackTrace();
			model.putWord(word);
		}
		
		String out = new String(c);
		
		model.putWord(out);
	}

}
