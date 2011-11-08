package cpu.instpar;

import cpu.InstructionRunner;

public class MemoryParameter implements InstructionParameter {
	private String indirectAddress;
	
	/**
	 * @param memoryAddressExpression e.g: MEM[123], MEM[%eax], MEM[MEM[%ebx]]
	 */
	public MemoryParameter(String memoryAddressExpression) {
		int beginIndex = "MEM[".length();
		// -1 because of the ending ]
		int endIndex = memoryAddressExpression.length() - 1;
		indirectAddress = memoryAddressExpression.substring(beginIndex, endIndex);
	}
	
	private int resolveAddress(InstructionRunner runner) throws InvalidParameterException {
		InstructionParameter addressParameter = runner.identifyInstructionParameter(indirectAddress);
		return addressParameter.loadValue(runner);
	}

	@Override
	public int loadValue(InstructionRunner runner) throws InvalidParameterException {
		int address = resolveAddress(runner);
		
		// fetch value from address
		String word = runner.fetchWord(address);
		try {
			return Integer.parseInt(word);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException();
		}
	}

	@Override
	public void storeValue(InstructionRunner runner, int value) throws InvalidParameterException {
		int address = resolveAddress(runner);
		runner.putWord(address, Integer.toString(value));
	}
}
