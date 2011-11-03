package cpu.instpar;

import cpu.InstructionRunner;

public interface InstructionParameter {
	public void loadValue(InstructionRunner runner) throws InvalidParameterException;
	public int getValue();
}
