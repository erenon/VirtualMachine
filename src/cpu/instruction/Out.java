package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Out implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters) 
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 2) {
			throw new InvalidInstructionException();
		}
		
		int address = parameters[0].loadValue(runner);
		String word = Integer.toString(parameters[1].loadValue(runner));
		
		runner.putWord(address, word);
	}

}
