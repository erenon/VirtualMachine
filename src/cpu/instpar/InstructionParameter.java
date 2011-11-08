package cpu.instpar;

import cpu.InstructionRunner;

public interface InstructionParameter {
	public int loadValue(InstructionRunner runner) throws InvalidParameterException;
	public void storeValue(InstructionRunner runner, int value) throws InvalidParameterException;
	//public int getValue();
}
