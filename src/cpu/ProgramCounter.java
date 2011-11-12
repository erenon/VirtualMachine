package cpu;

import java.util.HashSet;
import java.util.Set;

import device.DeviceObserver;

/**
 * Represents the actual state of the execution
 * of a program in memory.
 */
class ProgramCounter {
	private int state = 0;
	private Set<DeviceObserver> observers = new HashSet<DeviceObserver>();
	
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
		notifyObservers(state);
		state++;
		notifyObservers(state);
	}
	
	/**
	 * Jumps to the given address
	 * @param address Address to jump to.
	 */
	public void jump(int address) {
		notifyObservers(state);
		state = address;
		notifyObservers(state);
	}
	
	/**
	 * Resets the state counter
	 */
	public void reset() {
		notifyObservers(state);
		state = 0;
		notifyObservers(state);
	}
	
	public void addObserver(DeviceObserver observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(int address) {
		for (DeviceObserver observer : observers) {
			observer.fireDataChange(address);
		}
	}
}
