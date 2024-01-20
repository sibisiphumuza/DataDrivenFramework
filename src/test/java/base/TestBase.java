package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import testcases.LoginTests;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(LoginTests.class.getName()); 
	public static Wait<WebDriver> wait;
	public static Capabilities cap;
	
	@BeforeMethod	
	@Parameters({"browser", "testobj"})
	public void setUp(@Optional("firefox") String browser, @Optional("https://www.saucedemo.com/") String testobj)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(testobj);
			driver.manage().window().maximize();	
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			
			cap = ((RemoteWebDriver) driver).getCapabilities();
			logger.info(cap.getBrowserName() + " Browser Test Begins...");
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(testobj);
			driver.manage().window().maximize();
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			
			cap = ((RemoteWebDriver) driver).getCapabilities();
			logger.info(cap.getBrowserName() + " Browser Test Begins...");
			//++: --log successful launch of browser
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(testobj);
			driver.manage().window().maximize();
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(2));

			cap = ((RemoteWebDriver) driver).getCapabilities();
			logger.debug(cap.getBrowserName() + " Browser Test Begins...");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		logger.info("Teardown successful");
		System.out.println();
	}

}
