package device;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VmBusTest {
	VmBus bus;

	@Before
	public void setUp() throws Exception {
		bus = new VmBus();
	}

	@Test
	public void testPutWord() {
		fail("Not yet implemented"); // TODO implement testPutWord
	}

	@Test
	public void testGetWord() throws AddressingException {
		// TODO use stub/mock instead
		// try: jmock, easymock, powermock, jmockit
		
		VmMemory a, b, c;
		
		a = new VmMemory(1024);
		b = new VmMemory(512);
		c = new VmMemory(512);
		
		b.putWord(0, "memorycontent");
		
		bus.addDevice(0, a);
		bus.addDevice(1024, b);
		bus.addDevice(1024+512, c);
		
		assertEquals("Get word", "memorycontent", bus.getWord(1024));
	}

}
