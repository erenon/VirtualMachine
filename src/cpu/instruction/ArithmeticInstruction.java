package cpu.instruction;

import cpu.InstructionRunner;
import cpu.InvalidFlagException;
import cpu.InstructionRunner.FLAG_NAME;

public class ArithmeticInstruction {
	protected static void setFlags(long value, InstructionRunner runner) 
	{
		try {
			if (value == 0) {
				runner.setFlag(FLAG_NAME.Zero, true);
			} else {
				runner.setFlag(FLAG_NAME.Zero, false);
			}
			
			if (value < 0) {
				runner.setFlag(FLAG_NAME.Negative, true);
			} else {
				runner.setFlag(FLAG_NAME.Negative, false);
			}
			
			if (value > Integer.MAX_VALUE) {
		        runner.setFlag(FLAG_NAME.Overflow, true);
		    } else if (value < Integer.MIN_VALUE) {
		    	// underflow
		    	runner.setFlag(FLAG_NAME.Overflow, true);
		    } else {
		    	runner.setFlag(FLAG_NAME.Overflow, false);
		    }
			
			// TODO handle carry, adjust	
		} catch (InvalidFlagException e) {
			// runner has no such flag
			e.printStackTrace();
		}
	}
}
