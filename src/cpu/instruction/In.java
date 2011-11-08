package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class In implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 2) {
			throw new InvalidInstructionException();
		}
		
		int address = parameters[0].loadValue(runner);
		String word = runner.fetchWord(address);
		
		try {
			parameters[1].storeValue(runner, Integer.parseInt(word));
		} catch (NumberFormatException e) {
			throw new InvalidInstructionException();
		}
	}

}
