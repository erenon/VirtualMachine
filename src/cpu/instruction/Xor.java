package cpu.instruction;

import cpu.InstructionRunner;
import cpu.InvalidFlagException;
import cpu.InstructionRunner.FLAG_NAME;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Xor implements Instruction {

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
		
		// produce xor
		int xor = paramA ^ paramB;
		
		// store the result in dest
		parameters[1].storeValue(runner, xor);
		
		// set flags
		try {
			
			if (xor == 0) {
				runner.setFlag(FLAG_NAME.Zero, true);
			} else {
				runner.setFlag(FLAG_NAME.Zero, false);
			}
			
			if (xor < 0) {
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
