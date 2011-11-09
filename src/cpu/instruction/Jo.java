package cpu.instruction;

import cpu.InstructionRunner;
import cpu.InvalidFlagException;
import cpu.InstructionRunner.FLAG_NAME;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Jo implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 1) {
			throw new InvalidInstructionException();
		}
		
		int address = parameters[0].loadValue(runner);
		
		try {
			if (runner.getFlag(FLAG_NAME.Overflow)) {
				runner.jump(address);
			}
		} catch (InvalidFlagException e) {
			// runner has no such flag
			e.printStackTrace();
			throw new InvalidInstructionException();
		}

	}

}
