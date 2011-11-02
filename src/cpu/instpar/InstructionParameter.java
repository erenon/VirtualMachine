package cpu.instpar;

import cpu.InstructionRunner;

public interface InstructionParameter {
	/** TODO give a better name to that exception */  
	public void loadValue(InstructionRunner runner) throws Exception;
}
