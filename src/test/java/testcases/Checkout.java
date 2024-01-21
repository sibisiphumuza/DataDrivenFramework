package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class Checkout extends TestBase {
	@Test(priority=11)
	public static void verifyCheckout()
	{		
		logger.info("Verify checkout testcase start...");		
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		logger.info("Standard_user successfully logged in.");
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();	
		
		logger.info("Add 3 items successfully.");
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
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

		logger.info("Checkout summary verified");
		
		driver.findElement(By.xpath("//button[@id='finish']")).click();		
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='title']")).isDisplayed());	
		
		logger.info("verifyCheckout testcase verified.");
	}
}

