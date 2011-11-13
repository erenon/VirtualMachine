package cpu.instruction;

import cpu.InstructionRunner;
import cpu.InvalidFlagException;
import cpu.InstructionRunner.FLAG_NAME;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Not implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 1) {
			throw new InvalidInstructionException();
		}
		
		int paramA = parameters[0].loadValue(runner);
		
		// produce not
		int not = paramA ^ 0x11111111;
		
		// store the result in dest
		parameters[0].storeValue(runner, not);
		
		// set flags
		try {
			
			if (not == 0) {
				runner.setFlag(FLAG_NAME.Zero, true);
			} else {
				runner.setFlag(FLAG_NAME.Zero, false);
			}
			
			if (not < 0) {
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
