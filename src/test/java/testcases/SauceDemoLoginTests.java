package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ReadXlsData;

public class SauceDemoLoginTests extends TestBase {

	@Test(dataProviderClass=ReadXlsData.class,dataProvider="sauceDemoTestData")
	
	public static void verifyEmailFieldFormat(String username, String password)
	{
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());
	}
	
	@Test
	public static void verifyTestUsernamePasswordVisibility()
	{
		//Are test usernames & passwords displayed.
		Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='Accepted usernames are:']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()='Password for all users:']")).isDisplayed());
	}
	
	@Test(dataProviderClass=ReadXlsData.class,dataProvider="sauceDemoTestData")
	public static void verifyLandingPages(String username, String password)
	{
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());		
	}
	
	@Test(dataProviderClass=ReadXlsData.class,dataProvider="sauceDemoTestData")
	public static void verifyLandingPagesInvalidUser(String username, String password)
	{
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());	
	}

}
