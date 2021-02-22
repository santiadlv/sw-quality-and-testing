package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class OtherClassTest {

	@Test
	public void testMultiply() {
		OtherClass foo = new OtherClass();
		assertEquals(42, foo.multiply(7, 6));
	}
	
	@Test
	public void testMultiply_ExceptionIsThrown() {
		OtherClass foo = new OtherClass();
		
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {foo.multiply(1000, 5);});
	}

}
