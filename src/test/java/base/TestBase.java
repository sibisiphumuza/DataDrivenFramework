package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties configProp = new Properties();
	public static Properties locators = new Properties();
	public static FileReader configReader;
	public static FileReader locatorsReader;
	
	@BeforeMethod	
	public void setUp()
	{
		if(driver==null)
		{
			try 
			{
				FileReader configFr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");	
				FileReader locatorFr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
				
				configProp.load(configFr);	
				locators.load(locatorFr);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(configProp.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(configProp.getProperty("testurl")+configProp.getProperty("profile"));
		}
		else if (configProp.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(configProp.getProperty("testurl")+configProp.getProperty("profile"));
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		System.out.println("Teardown successful");
	}

}
