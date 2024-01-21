package base;

import java.io.File;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import testcases.LoginTests;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(LoginTests.class.getName()); 
	public static Wait<WebDriver> wait;
	public static Capabilities cap;
	
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
 
	
	@BeforeMethod	
	@Parameters({"browser", "testobj"})
	public void setUp(@Optional("firefox") String browser, @Optional("https://www.saucedemo.com/") String testobj)
	{
		//\src\test\resources\reports
		extentReport = new ExtentReports(System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\saucedemoComponentsTestReport", true);		
        extentReport.loadConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Configfiles\\extent-config.xml"));
		
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
						
			cap = ((RemoteWebDriver) driver).getCapabilities();			
			
			extentTest = extentReport.startTest(cap.getBrowserName() + " Browser Test Begins...");
			extentTest.log(LogStatus.PASS, "Browser & Test-object successfully launched.");
			
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
			extentTest = extentReport.startTest(cap.getBrowserName() + " Browser Test Begins...");
			logger.info(cap.getBrowserName() + " Browser Test Begins...");
		}
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            extentTest.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }
 
        // ends the current test and prepares to create HTML report
        extentReport.endTest(extentTest);
		
		driver.close();
		logger.info("Teardown successful");
		System.out.println();
	}
	
    @AfterTest
    public void endTestReport() {
 
        // Appends the HTML file with all the ended tests. There
        extentReport.flush();
 
        // Closes the underlying stream and clears all resources
        extentReport.close();
    }

}
