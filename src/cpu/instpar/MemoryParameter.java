package cpu.instpar;

import cpu.InstructionRunner;

public class MemoryParameter implements InstructionParameter {
	private String indirectAddress;
	private int loadedValue;
	
	/**
	 * @param memoryAddressExpression e.g: MEM[123], MEM[%eax], MEM[MEM[%ebx]]
	 */
	public MemoryParameter(String memoryAddressExpression) {
		int beginIndex = "MEM[".length();
		// -1 because of the ending ]
		int endIndex = memoryAddressExpression.length() - 1;
		indirectAddress = memoryAddressExpression.substring(beginIndex, endIndex);
	}

	@Override
	public void loadValue(InstructionRunner runner) throws InvalidParameterException {
		InstructionParameter addressParameter = runner.identifyInstructionParameter(indirectAddress);
		addressParameter.loadValue(runner);
		int address = addressParameter.getValue();
		
		// fetch value from address
		String word = runner.fetchWord(address);
		try {
			loadedValue = Integer.parseInt(word);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException();
		}
	}

	@Override
	public int getValue() {
		return loadedValue;
	}
}
