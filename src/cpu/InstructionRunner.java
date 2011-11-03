package cpu;

public interface InstructionRunner {
	@Deprecated
	public void exit();
	
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
}
