package cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProgramCounterTest {
	ProgramCounter pc;
	
	@Before
	public void setUp() throws Exception {
		pc = new ProgramCounter();
	}

	@Test
	public void testInitialState() {
		assertEquals("Initial state is 0", 0, pc.getState());
	}
	
	@Test
	public void testIncrement() {
		int expectedState = pc.getState() + 1; 
		pc.increment();
		assertEquals("State is prev+1 after increment", expectedState, pc.getState());
	}
	
	@Test
	public void testJump() {
		int jumpAddress = 5;
		pc.jump(jumpAddress);
		assertEquals("Jump to the specified state", jumpAddress, pc.getState());
	}
	
	@Test
	public void testReset() {
		pc.jump(35);
		pc.reset();
		assertEquals("Resets to 0", 0, pc.getState());
	}

}
