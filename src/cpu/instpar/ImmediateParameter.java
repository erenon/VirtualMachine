package cpu.instpar;

import cpu.InstructionRunner;

public class ImmediateParameter implements InstructionParameter {
	private String value;
	private int transformedValue;
	
	public ImmediateParameter(String immediateExpression) {
		value = immediateExpression;
	}

	@Override
	public void loadValue(InstructionRunner runner) throws InvalidParameterException {
		try {
			transformedValue = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException();
		}
	}

	@Override
	public int getValue() {
		return transformedValue;
	}
}
