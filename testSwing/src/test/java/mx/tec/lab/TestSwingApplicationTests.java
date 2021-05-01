package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSwingApplicationTests {
	TestSwingApplication application = new TestSwingApplication();
	
	@Test
	void givenTwoIntegers_WhenSum_ThenCorrectResult() {
		// Given 5 and 7
		application.numberOneTextField.setText("5");
		application.numberTwoTextField.setText("7");
		String expectedResult = "12";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then result is 12
		String actualResult = application.resultTextField.getText();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void givenBothInvalidInput_WhenSum_ThenClear_And_NaNResult() {
		// Given invalid numbers
		application.numberOneTextField.setText("abc");
		application.numberTwoTextField.setText("def");
		String expectedOneTextField = "";
		String expectedTwoTextField = "";
		String expectedResult = "NaN";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then field one is empty
		String actualOneTextField = application.numberOneTextField.getText();
		assertEquals(expectedOneTextField, actualOneTextField);
		
		// Then field two is empty
		String actualTwoTextField = application.numberTwoTextField.getText();
		assertEquals(expectedTwoTextField, actualTwoTextField);
		
		// Then result is NaN
		String actualResult = application.resultTextField.getText();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void givenOneInvalidAndOneNumber_WhenSum_ThenClearInvalidTextField_And_NaNResult() {
		// Given an invalid number and a valid number
		application.numberOneTextField.setText("abc");
		application.numberTwoTextField.setText("123");
		String expectedOneTextField = "";
		String expectedTwoTextField = "123";
		String expectedResult = "NaN";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then field one is empty
		String actualOneTextField = application.numberOneTextField.getText();
		assertEquals(expectedOneTextField, actualOneTextField);
		
		// Then field two is number
		String actualTwoTextField = application.numberTwoTextField.getText();
		assertEquals(expectedTwoTextField, actualTwoTextField);
		
		// Then result is NaN
		String actualResult = application.resultTextField.getText();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void givenOneNumberAndOneInvalid_WhenSum_ThenClearInvalidTextField_And_NaNResult() {
		// Given an valid number and an invalid number
		application.numberOneTextField.setText("123");
		application.numberTwoTextField.setText("abc");
		String expectedOneTextField = "123";
		String expectedTwoTextField = "";
		String expectedResult = "NaN";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then field one is number
		String actualOneTextField = application.numberOneTextField.getText();
		assertEquals(expectedOneTextField, actualOneTextField);
		
		// Then field two is empty
		String actualTwoTextField = application.numberTwoTextField.getText();
		assertEquals(expectedTwoTextField, actualTwoTextField);
		
		// Then result is NaN
		String actualResult = application.resultTextField.getText();
		assertEquals(expectedResult, actualResult);
	}
}
