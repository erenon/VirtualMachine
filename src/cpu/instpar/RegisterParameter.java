package cpu.instpar;

import cpu.InstructionRunner;
import cpu.InstructionRunner.REGISTER_NAME;
import cpu.InvalidRegisterException;

public class RegisterParameter implements InstructionParameter {
	private REGISTER_NAME register;
	private int loadedValue;
	
	/**
	 * @param registerName e.g: %eax
	 */
	public RegisterParameter(String registerName) {
		register = REGISTER_NAME.valueOf(registerName.substring(1));
	}

	@Override
	public void loadValue(InstructionRunner runner) throws InvalidParameterException {
		try {
			loadedValue = runner.getRegisterContent(register);
		} catch (InvalidRegisterException e) {
			throw new InvalidParameterException();
		}
	}

	@Override
	public int getValue() {
		return loadedValue;
	}
}
