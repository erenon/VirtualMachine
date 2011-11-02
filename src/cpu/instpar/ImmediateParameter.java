package cpu.instpar;

import cpu.InstructionRunner;

public class ImmediateParameter implements InstructionParameter {
	private String value;
	
	public ImmediateParameter(String immediateExpression) {
		value = immediateExpression;
	}

	@Override
	public void loadValue(InstructionRunner runner) {
		// TODO Auto-generated method stub
		
	}
}
