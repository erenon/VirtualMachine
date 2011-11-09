package cpu;

class ProgramCounter {
	private int state = 0;
	
	public int getState() {
		return state;
	}
	
	public void increment() {
		state++;
	}
	
	public void jump(int address) {
		state = address;
	}
}
