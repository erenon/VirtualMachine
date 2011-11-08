package cpu.instpar;

import cpu.InstructionRunner;
import cpu.InstructionRunner.REGISTER_NAME;
import cpu.InvalidRegisterException;

public class RegisterParameter implements InstructionParameter {
	private REGISTER_NAME register;
	
	/**
	 * @param registerName e.g: %eax
	 */
	public RegisterParameter(String registerName) {
		register = REGISTER_NAME.valueOf(registerName.substring(1));
	}

	@Override
	public int loadValue(InstructionRunner runner) throws InvalidParameterException {
		try {
			return runner.getRegisterContent(register);
		} catch (InvalidRegisterException e) {
			throw new InvalidParameterException();
		}
	}

	@Override
	public void storeValue(InstructionRunner runner, int value) throws InvalidParameterException {
		try {
			runner.setRegisterContent(register, value);
		} catch (InvalidRegisterException e) {
			throw new InvalidParameterException();
		}
	}
}
