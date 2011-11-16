package device;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VmMemoryTest {
	VmMemory memory;
	
	@Before
	public void setUp() throws Exception {
		memory = new VmMemory(1024);
	}

	@Test
	public void testGetWord() throws AddressingException {
		memory.putWord(5, "foo");
		assertEquals("Gets back the previously stored word", "foo", memory.getWord(5));
	}

	@Test(expected=AddressingException.class)
	public void testAddressingExceptionGetEqual() throws AddressingException {
		memory.getWord(1024);
	}
	
	@Test(expected=AddressingException.class)
	public void testAddressingExceptionGetOverflow() throws AddressingException {
		memory.getWord(2000);
	}
	
	@Test(expected=AddressingException.class)
	public void testAddressingExceptionGetUnderflow() throws AddressingException {
		memory.getWord(-1);
	}
	
	@Test(expected=AddressingException.class)
	public void testAddressingExceptionPutEqual() throws AddressingException {
		memory.putWord(1024, "bar");
	}
	
	@Test(expected=AddressingException.class)
	public void testAddressingExceptionPutOverflow() throws AddressingException {
		memory.putWord(2000, "baz");
	}
	
	@Test(expected=AddressingException.class)
	public void testAddressingExceptionPutUnderflow() throws AddressingException {
		memory.putWord(-1, "foobar");
	}
}
