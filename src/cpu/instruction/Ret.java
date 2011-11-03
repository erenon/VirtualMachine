package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;

public class Ret implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException 
	{
		runner.decreaseStackframe();
	}

}
