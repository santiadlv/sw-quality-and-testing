package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestHtml2ApplicationTests {

	private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\santi\\Documents\\Carrera Profesional\\Sexto Semestre\\Calidad y pruebas de software\\Lab Practices\\Lab 9\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect() throws Exception {
        // When
        driver.get("http://automationpractice.com/index.php");
        String title = driver.getTitle();

        // Then
        assertEquals("My Store", title);
    }
    
    @Test
    public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed() throws Exception {
        // When
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("bibivep905@leonvero.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("Bibivep905.");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();       
        String title = driver.getTitle();
        
        // Then
        assertEquals("My account - My Store", title);
    }

    @Test
    public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed() {
    	// When
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("bibivep905@leonvero.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("WrongPwd1.");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        String title = driver.getTitle();
        
        // Then
        assertEquals("Login - My Store", title);
    }

    @Test
    public void givenAClient_whenEnteringWrongLoginCredentials_thenErrorMessageIsDisplayed() {
    	// When
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("bibivep905@leonvero.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("WrongPwd1.");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        
        // Then
        assertEquals("Authentication failed.", errorMessage);
    }
    
    @Test
    public void givenAClient_whenSearchingNotExistingProduct_thenNoResultsDisplayed()
      throws Exception {
    	// When
    	driver.get("http://automationpractice.com/index.php");
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("chivigon");
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default button-search']"));
        submitButton.click();       
        String errorMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();
        
        // Then
        assertEquals("No results were found for your search \"chivigon\"", errorMessage);
    }

    @Test
    public void givenAClient_whenSearchingEmptyString_thenPleaseEnterDisplayed()
      throws Exception {
    	// When
    	driver.get("http://automationpractice.com/index.php");
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("");
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default button-search']"));
        submitButton.click();       
        String errorMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();
        
        // Then
        assertEquals("Please enter a search keyword", errorMessage);
    }
    
    @Test
    public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed() {
    	// When
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("bibivep905@leonvero.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("Bibivep905.");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        WebElement signOutButton = driver.findElement(By.xpath("//a[@class='logout']"));
        signOutButton.click();
        String title = driver.getTitle();
        
        // Then
        assertEquals("Login - My Store", title);
    }
}
