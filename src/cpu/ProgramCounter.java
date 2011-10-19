package cpu;

public class ProgramCounter {
	private int state = 0;
	
	public int getState() {
		return state;
	}
	
	public void increment() {
		state++;
	}
	
	public void jump(int position) {
		state = position;
	}
}
