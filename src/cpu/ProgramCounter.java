package cpu;

/**
 * Represents the actual state of the execution
 * of a program in memory.
 */
class ProgramCounter {
	private int state = 0;
	
	/**
	 * Gets the current state
	 * @return Current state
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * Increments the current state by one.
	 * 
	 * This intented to use to step to the next instruction.
	 */
	public void increment() {
		state++;
	}
	
	/**
	 * Jumps to the given address
	 * @param address Address to jump to.
	 */
	public void jump(int address) {
		state = address;
	}
	
	/**
	 * Resets the state counter
	 */
	public void reset() {
		state = 0;
	}
}
