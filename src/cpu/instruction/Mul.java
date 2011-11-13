package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Mul extends ArithmeticInstruction implements Instruction {

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
		
		// multiply the two parameters
		Long mul = ((long)paramA) * paramB;
		
		// store the result in dest
		parameters[1].storeValue(runner, mul.intValue());
		
		// set flags
		super.setFlags(mul, runner);
	}

}
