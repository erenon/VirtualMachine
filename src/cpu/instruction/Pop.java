package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Pop implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException 
	{
		if (parameters.length != 1) {
			throw new InvalidInstructionException();
		}
		
		int poppedValue = runner.popStack();
		parameters[0].storeValue(runner, poppedValue);
	}

}
