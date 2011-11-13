package cpu.instruction;

import cpu.InstructionRunner;
import cpu.InvalidFlagException;
import cpu.InstructionRunner.FLAG_NAME;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class And implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 2) {
			throw new InvalidInstructionException();
		}
		
		int paramA = parameters[0].loadValue(runner);
		int paramB = parameters[1].loadValue(runner);
		
		// produce and
		int and = paramA & paramB;
		
		// store the result in dest
		parameters[1].storeValue(runner, and);
		
		// set flags
		try {
			
			if (and == 0) {
				runner.setFlag(FLAG_NAME.Zero, true);
			} else {
				runner.setFlag(FLAG_NAME.Zero, false);
			}
			
			if (and < 0) {
				runner.setFlag(FLAG_NAME.Negative, true);
			} else {
				runner.setFlag(FLAG_NAME.Negative, false);
			}
			
			// TODO handle adjust
			
		} catch (InvalidFlagException e) {
			// runner has no such flag
			e.printStackTrace();
			throw new InvalidInstructionException();
		}
	}

}
