package apptimizeSample;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class signUpTest {
	
	private static WebDriver driver;
	
	//@Parameters("browser")
	@BeforeTest
	public static void BeforeTest(){
		 //Setting the path for the Chrome Driver
               System.setProperty("webdriver.chrome.driver","/Users/mohanmukherjee/Downloads/chromedriver");
               driver = new ChromeDriver();
	           driver.get("https://apptimize.com");
		       driver.manage().window().maximize();
		       
		  /*   if(browser.equalsIgnoreCase("firefox")){
		     // Setting the path for the Firefox Driver
		     System.setProperty("webdriver.gecko.driver", "/Users/mohanmukherjee/Downloads/geckodriver");
			 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			 capabilities.setCapability("marionette",true);
			 driver = new FirefoxDriver(capabilities);
		     }
		     
		     else if(browser.equalsIgnoreCase("chrome")){
		    // Setting the path for the Chrome Driver
		    System.setProperty("webdriver.chrome.driver","/Users/mohanmukherjee/Downloads/chromedriver");
	        driver = new ChromeDriver();
	       
	} */
			
	}
	
	@Test 
	@Parameters({"sUsername", "sLastname", "sPassword", "sEmail", "sCompany", "sPhone", "sTitle"})
	public void testLogin(String sUsername, String sLastname, String sPassword, String sEmail, String sCompany, String sPhone, String sTitle){
		   driver.findElement(By.xpath("//*[@id='nav-main']/ul[2]/li[1]/a")).click();
	       driver.findElement(By.xpath("//*[@id='fname']")).sendKeys(sUsername);
	       driver.findElement(By.id("lname")).sendKeys(sLastname);
	       driver.findElement(By.id("email")).sendKeys(sEmail);
	       driver.findElement(By.id("company")).sendKeys(sCompany);
	       driver.findElement(By.id("phone")).sendKeys(sPhone);
	       driver.findElement(By.id("jobtitle")).sendKeys(sTitle);
	       driver.findElement(By.id("password")).sendKeys(sPassword);
	       driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[2]/div[6]/div[2]/input[2]")).click();
	       driver.findElement(By.id("eula")).click();
	       driver.findElement(By.id("submit")).click();
	       
}
	@After
	public static void AfterTest(){
	    driver.close();
} 
}
