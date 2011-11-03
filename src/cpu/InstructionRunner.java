package cpu;

import cpu.instpar.InstructionParameter;

public interface InstructionRunner {
	public static enum REGISTER_NAME {
		eax,
		ebx,
		ecx,
		edx,
		esp,
		ebp,
		esi,
		edi
	}
	
	public int getRegisterContent(REGISTER_NAME registerName) throws InvalidRegisterException;
	public InstructionParameter identifyInstructionParameter(String parameter);
	public String fetchWord(int address);
	public void putWord(int address, String word);
	public void increaseStackframe();
	public void decreaseStackframe();
}
