package computer;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cpu.VmCpu;

public class Runner {
	Computer computer;

	@Before
	public void setUp() throws Exception {
		computer = new Computer();
		computer.setCpu(new VmCpu());
	}

	@Test
	public void testRun() throws Exception {
		computer.start();
	}

}
