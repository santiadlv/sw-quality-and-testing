package mx.tec.lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

@SpringBootTest
class UnderstandingAssertsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void whenAssertingEquality_thenEqual() {
		String expected = "Winter is coming";
		String actual = "Not today";
		
		//assertEquals(expected, actual);
		assertEquals(expected, actual, "failure - strings are not equal");
	}
	
	@Test
	public void whenAssertingArraysEquality_thenEqual() {
		char[] expected = {'J', 'u', 'n', 'i', 't'};
		char[] actual = "Junit".toCharArray();
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void givenNullArrays_whenAssertingArraysEquality_thenEqual() {
		int[] expected = null;
		int[] actual = null;
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void whenAssertingNull_thenTrue() {
		Object longclaw = null;
		
		assertNull(longclaw, "The longclaw should be null");
		//If we want to assert that an object should not be null we can use the assertNotNull assertion
	}
	
	@Test
	public void whenAssertingNull_thenFalse() {
		Object heartsbane = new Object();
		
		assertNotNull(heartsbane, "The heartsbane should not be null");
	}
	
	@Test
	public void whenAssertingSameObject_thenSame() {
		Object wildfire = new Object();
		Object dragonglass = wildfire;
		
		assertSame(wildfire, dragonglass);
	}
	
	@Test
	public void whenAssertingNotSameObject_thenDifferent() {
		Object oathkeeper = new Object();
		Object widowswall = new Object();
		
		assertNotSame(oathkeeper, widowswall);
		//When we want to verify that two variables refer to the same object, we can use the assertSame assertion
	}
	
	@Test
	public void whenAssertingConditions_thenVerified() {
		assertTrue(5 > 4, "5 is greater than 4");
		assertFalse(5 > 6, "5 is not greater than 6");
	}
	
	@Test
	public void whenCheckingExceptionMessage_thenEqual() {
		AnyClass ac = new AnyClass();
		
		try {
			ac.methodThatShouldThrownException();
			 fail("Exception not thrown");
		} catch (UnsupportedOperationException e) {
			assertEquals("Operation not supported", e.getMessage());
		}
	}
	
	@Test 
	public void testAssertThatHasItems() {
		assertThat(Arrays.asList("Harrenhal", "Dragonstone", "Winterfell")).contains("Winterfell", "Harrenhal");
	}

}
