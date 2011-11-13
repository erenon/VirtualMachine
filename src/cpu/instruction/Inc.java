package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Inc extends ArithmeticInstruction implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 1) {
			throw new InvalidInstructionException();
		}
		
		int paramA = parameters[0].loadValue(runner);
		
		Long incremented = ((long)paramA) + 1;
		
		// store the result
		parameters[0].storeValue(runner, incremented.intValue());
		
		// set flags
		super.setFlags(incremented, runner);
	}

}
