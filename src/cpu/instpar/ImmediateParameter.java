package cpu.instpar;

import cpu.InstructionRunner;

public class ImmediateParameter implements InstructionParameter {
	private String value;
	
	public ImmediateParameter(String immediateExpression) {
		value = immediateExpression;
	}

	@Override
	public int loadValue(InstructionRunner runner) throws InvalidParameterException {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException();
		}
	}

	@Override
	public void storeValue(InstructionRunner runner, int value) throws InvalidParameterException {
		// can't write immediate
		throw new InvalidParameterException();
	}
}
