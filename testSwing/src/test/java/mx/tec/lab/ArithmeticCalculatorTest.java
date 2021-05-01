package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticCalculatorTest {

	@Test
	void given_5and7_When_Sum_Then_12() {
		// Given 5 and 7
		int operand1 = 5;
		int operand2 = 7;
		int expectedResult = 12;
				
		// When operation is sum
		int actualResult = ArithmeticCalculator.sum(operand1, operand2);
				
		// Then result is 12
		assertEquals(expectedResult, actualResult);
	}
}
