package cpu.instruction;

import cpu.InstructionRunner;
import cpu.instpar.InstructionParameter;

public class Ret implements Instruction {

	@Override
	public void execute(InstructionRunner runner,
		InstructionParameter[] parameters)
		throws InvalidInstructionException 
	{
		if (runner.getStackframeIndex() > 0) {
			// there are lower stackframes
			
			// switch frame
			runner.decreaseStackframe();
			
			// the caller address is at the top of the lower frame
			int callerAddress = runner.popStack();
			
			// we have to jump after the caller
			callerAddress++;
			
			// jump to the caller
			runner.jump(callerAddress);
		} else {
			// decrease the frame index below 0,
			// the execution of the program will halt 
			runner.decreaseStackframe();
		}
	}

}
