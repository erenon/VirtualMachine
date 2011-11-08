package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public interface Instruction {
	public void execute(
		InstructionRunner runner, 
		InstructionParameter[] parameters
	) throws InvalidInstructionException,
			 InvalidParameterException;
}
