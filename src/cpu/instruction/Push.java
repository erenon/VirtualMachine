package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Push implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 1) {
			throw new InvalidInstructionException();
		}
		
		int valueToPush = parameters[0].loadValue(runner);
		runner.pushStack(valueToPush);
	}

}
