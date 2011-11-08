package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Mov implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 2) {
			throw new InvalidInstructionException();
		}
		
		int srcValue = parameters[0].loadValue(runner);
		parameters[1].storeValue(runner, srcValue);
	}

}
