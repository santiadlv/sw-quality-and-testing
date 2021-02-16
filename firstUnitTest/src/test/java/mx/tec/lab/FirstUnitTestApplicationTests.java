package mx.tec.lab;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstUnitTestApplicationTests {
	private static final Log LOG = LogFactory.getLog(FirstUnitTestApplicationTests.class);

	@BeforeAll
	public static void setup() {
		LOG.info("@BeforeAll - executes once before all test methods in this class.");
	}
	
	@BeforeEach
	public void init() {
		LOG.info("@BeforeEach - executes before each test method in this class.");
	}
	
	@Test
	public void simpleTest() {
		LOG.info("Simple test.");
	}
	
	@Test
	public void otherSimpleTest() {
		LOG.info("Other simple test.");
	}
	
	@Test
	@Disabled("Test is ignored as a demonstration.")
	public void notImplementedTest() {
		LOG.info("Not implemented yet.");
	}
	
	
	@AfterEach
	public void tearDown() {
		LOG.info("@AfterEach - executed after each test method.");
	}
	
	@AfterAll
	public static void done() {
		LOG.info("AfterAll - executed after all test methods.");
	}

}
