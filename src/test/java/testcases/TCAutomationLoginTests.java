package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ReadXlsData;

public class TCAutomationLoginTests extends TestBase {

	@Test(dataProviderClass=ReadXlsData.class,dataProvider="sauceDemoTestData")
	
	public static void verifyEmailFieldFormat(String username, String password)
	{
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
	}
	
	@Test
	public static void TermsConditionsTest()
	{
		// are they visible
		// scrollable
		// printable
		// is acknowledging mechanism available? (check-box,button etc) 
	}
	
	@Test
	public static void UsernamePasswordTest()
	{
		// Password
		// 5 weak passwords against correct email address.
		// 5 strong passwords against incorrect email address.
		
		//Email address tests
		// 5 invalid email address against strong password.
		// 5 valid email address against weak passwords.
	}
	
	@Test
	public static void ValidRegistrationTest()
	{
		//check if is an existing subscriber.
		//check for correct landing page.
		//check if confirmation message is received.
	}

}
