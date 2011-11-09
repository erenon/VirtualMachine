package cpu;

import java.util.HashMap;
import java.util.Map;

import util.Entry;
import cpu.instpar.InstructionParameter;
import cpu.instpar.InvalidParameterException;
import cpu.instruction.Cmp;
import cpu.instruction.In;
import cpu.instruction.Instruction;
import cpu.instruction.InvalidInstructionException;
import cpu.instruction.Mov;
import cpu.instruction.Out;
import cpu.instruction.Pop;
import cpu.instruction.Push;
import cpu.instruction.Ret;
import cpu.instruction.Test;
import device.AddressingException;
import device.Bus;

public class VmCpu implements Cpu, InstructionRunner {
	private Bus bus = null;
	private ProgramCounter pc = new ProgramCounter();
	private InstructionIdentifier id = new InstructionIdentifier();
	private Map<REGISTER_NAME, Integer> registers;
	private Map<FLAG_NAME, Boolean> flags;
	private VmStack stack = new VmStack();
	
	public VmCpu() {
		// load available instructions
		id.addInstruction("CMP", new Cmp());
		id.addInstruction("IN", new In());
		id.addInstruction("MOV", new Mov());
		id.addInstruction("OUT", new Out());
		id.addInstruction("POP", new Pop());
		id.addInstruction("PUSH", new Push());
		id.addInstruction("RET", new Ret());
		id.addInstruction("TEST", new Test());
		
		// init registers
		registers = new HashMap<InstructionRunner.REGISTER_NAME, Integer>();
		for (REGISTER_NAME register : REGISTER_NAME.values()) {
			registers.put(register, 0);
		}
		
		// init flags
		flags = new HashMap<InstructionRunner.FLAG_NAME, Boolean>();
		for (FLAG_NAME flag : FLAG_NAME.values()) {
			flags.put(flag, false);
		}
	}
	
	@Override
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public void start() throws NoBusSetException {
		if (bus == null) {
			throw new NoBusSetException();
		}
		
		// while the are stack frames
		while (stack.getCurrentFrameIndex() >= 0) {
			// store pc current state
			int currentPcState = pc.getState();
			
			// fetch instruction from memory pointed by pc
			// using bus
			String word = fetchWord(currentPcState);
			
			// id instruction
			Entry<Instruction, InstructionParameter[]> instructionWithParameters = null;
			try {
				instructionWithParameters = id.identify(word);
			} catch (UnidentifiableInstructionException e) {
				// TODO call sw exception routine
				e.printStackTrace();
			}
			
			Instruction instruction = instructionWithParameters.getKey();
			InstructionParameter[] parameters = instructionWithParameters.getValue();
			
			// execute instruction
			try {
				instruction.execute(this, parameters);
			} catch (InvalidInstructionException e) {
				// TODO call sw exception routine
				e.printStackTrace();
			} catch (InvalidParameterException e) {
				// TODO call sw exception routine
				e.printStackTrace();
			}
			
			// increment pc if not jump
			if (currentPcState == pc.getState()) {
				pc.increment();
			}
		}
	}
	
	public String fetchWord(int address) {
		String word = null;
		try {
			word = bus.getWord(address);
		} catch (AddressingException e) {
			// TODO call sw exception routine
			e.printStackTrace();
		}
		
		return word;
	}
	
	public void putWord(int address, String word) {
		try {
			bus.putWord(address, word);
		} catch (AddressingException e) {
			// TODO call sw exception routine
			e.printStackTrace();
		}
	}

	@Override
	public int getRegisterContent(REGISTER_NAME registerName) throws InvalidRegisterException {
		if (registers.containsKey(registerName)) {
			return registers.get(registerName);
		} else {
			throw new InvalidRegisterException();
		}
	}

	@Override
	public void setRegisterContent(REGISTER_NAME registerName, int content) throws InvalidRegisterException {
		if (registers.containsKey(registerName)) {
			registers.put(registerName, content);
		} else {
			throw new InvalidRegisterException();
		}
	}
	
	@Override
	public InstructionParameter identifyInstructionParameter(String parameter) {
		return id.identifyParameter(parameter);
	}

	@Override
	public void increaseStackframe() {
		stack.increaseStackFrame();
	}

	@Override
	public void decreaseStackframe() {
		stack.decreaseStackFrame();
	}

	@Override
	public void pushStack(int value) {
		stack.push(value);
	}

	@Override
	public int popStack() {
		return stack.pop();
	}

	@Override
	public void setFlag(FLAG_NAME flag, boolean value) throws InvalidFlagException {
		if (flags.containsKey(flag)) {
			flags.put(flag, value);
		} else {
			throw new InvalidFlagException();
		}
	}

	@Override
	public boolean getFlag(FLAG_NAME flag) throws InvalidFlagException {
		if (flags.containsKey(flag)) {
			return flags.get(flag);
		} else {
			throw new InvalidFlagException();
		}
	}

}
