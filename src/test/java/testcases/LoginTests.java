package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ReadXlsData;

public class LoginTests extends TestBase {
	
	@Test(priority=1,dataProviderClass=ReadXlsData.class,dataProvider="saucedemoTestData")
	
	public static void verifyLoginInvalidCredentials(String username, String password)
	{
		logger.info("verifyLoginInvalidCredentials testcase start...");		
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
		logger.info("verifyLoginInvalidCredentials testcase verified.");
		//++: login verification assertion
	}
	
	@Test(priority=2)
	public static void verfiyLoginValidCredentials() 
	{
		logger.info("verfiyLoginValidCredentials testcase start...");		
	
		Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='Accepted usernames are:']")).isDisplayed());
		logger.info("usernames testcase verified.");
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='Password for all users:']")).isDisplayed());
		logger.info("password testcase verified.");
		
		//++: --log verification assertion
	}
	
	@Test(priority=3)
	public static void verifyLandingPagesInvalidUser()
	{
		logger.info("verifyLandingPagesInvalidUser testcase verified.");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
		logger.info("verfiyLoginValidCredentials testcase verified.");

		logger.info("verifyLandingPagesInvalidUser testcase verified.");
		//++: --log verification assertion
	}		
}
