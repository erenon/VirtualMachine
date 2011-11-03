package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;

public class Out implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters) throws InvalidInstructionException
	{
		if (parameters.length != 2) {
			throw new InvalidInstructionException();
		}
		
		int address = parameters[0].getValue();
		String word = Integer.toString(parameters[1].getValue());
		
		runner.putWord(address, word);
	}

}
