package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.ReadXlsData;

public class LoginTests extends TestBase {
	
	@Test(priority=1,dataProviderClass=ReadXlsData.class,dataProvider="saucedemoTestData")
	
	public static void verifyLoginInvalidCredentials(String username, String password)
	{
		logger.info("Verify Login Invalid Credentials testcase start...");
		extentTest = extentReport.startTest(LoginTests.class.getName() + " Verify Login Invalid Credentials testcase start...");
		extentTest.log(LogStatus.INFO,"verify Login Invalid Credentials testcase start...");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
		logger.info("Verify login invalid credentials testcase verified.");
		extentTest.log(LogStatus.PASS,"Verify login invalid credentials testcase verified.");
		//++: login verification assertion
	}
	
	@Test(priority=2)
	public static void verfiyLoginValidCredentials() 
	{
		logger.info("Verfiy Valid login credentials testcase start...");	
		extentTest.log(LogStatus.INFO,"Verfiy Valid login credentials testcase start...");
	
		Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='Accepted usernames are:']")).isDisplayed());
		logger.info("usernames testcase verified.");
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='Password for all users:']")).isDisplayed());
		
		logger.info("password testcase verified.");
		extentTest.log(LogStatus.PASS,"password testcase verified.");
	}
	
	@Test(priority=3)
	public static void verifyLandingPagesInvalidUser()
	{
		logger.info("Verify landing pages invalid user testcase started.");
		extentTest.log(LogStatus.INFO,"Verify landing pages invalid user testcase started.");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
		logger.info("Verify landing pages invalid user testcase verified.");

		extentTest.log(LogStatus.PASS,"Verify landing pages invalid user testcase verified.");
		//++: --log verification assertion
	}		
}
