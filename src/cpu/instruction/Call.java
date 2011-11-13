package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;

public class Call implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException, InvalidParameterException
	{
		if (parameters.length != 1) {
			throw new InvalidInstructionException();
		}
		
		int routineAddress = parameters[0].loadValue(runner);
		
		// store current pc state at the top of the current frame
		// this is the caller address to return
		runner.pushStack(runner.getPcState());
		
		// switch stack
		runner.increaseStackframe();
		
		// jump to the routine
		runner.jump(routineAddress);
	}

}
