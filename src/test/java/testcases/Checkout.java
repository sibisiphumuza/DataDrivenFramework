package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class Checkout extends TestBase {
	@Test(priority=11)
	public static void verifyCheckout()
	{		
		extentTest.log(LogStatus.PASS, "Verify checkout testcase start...");	
		logger.info("Verify checkout testcase start...");	
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		extentTest.log(LogStatus.PASS, "Standard_user successfully logged in.");
		logger.info("Standard_user successfully logged in.");
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();	
		
		extentTest.log(LogStatus.PASS, "Add 3 items successfully.");
		logger.info("Add 3 items successfully.");
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		extentTest.log(LogStatus.PASS, "Add Checkout info.");
		logger.info("Add Checkout info.");
		
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Checkout");		
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Testing");		
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("4458");
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[normalize-space()='Payment Information']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[normalize-space()='Shipping Information']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='cancel']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='finish']")).isDisplayed());

		extentTest.log(LogStatus.PASS, "Checkout summary verified");
		logger.info("Checkout summary verified");
		
		driver.findElement(By.xpath("//button[@id='finish']")).click();		
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='title']")).isDisplayed());	
		
		extentTest.log(LogStatus.PASS, "verifyCheckout testcase verified.");
		logger.info("verifyCheckout testcase verified.");
	}
}

