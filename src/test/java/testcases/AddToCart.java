package testcases;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class AddToCart extends TestBase {

	@Test
	public static void verifyAddSingleItem()
	{
		
		//login into saucedemo
		LoginStandard_user();
		
		//in the product page + one items
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).isDisplayed());
		//++: log Assert verification
		
	}
	@Test
	public static void verifyRemoveSingleItemProductPage()
	{
		LoginStandard_user();
		
		//in the product page + one items
		WebElement addButton = driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
		//++: System.out.println(addButton.getText()); -- log 
		addButton.click();
		//++: addButton.click(); -- log
		    
		WebElement removeButton = driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']"));
		//++: System.out.println(removeButton.getText()); -- log 
		removeButton.click();
		//++: removeButton.click(); -- log 
				
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).isDisplayed());
		//++: --log Assert verification
	}
	@Test
	public static void verifyAddingMultipleItems()
	{
		//login into saucedemo
		LoginStandard_user();
		
		//add multiple items
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).isDisplayed());
	}
	@Test
	public static void verifyRemovingMultipleItemsProductPage()
	{
		//login into saucedemo
		LoginStandard_user();
		
		//add multiple items into shopping cart
		WebElement AllAddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
		//++: System.out.println(addButton.getText()); -- log 
		AllAddButton.click();
		//++: AlladdButton.click(); -- log
		
		//add multiple items into shopping cart
		WebElement fleeceAddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
		//++: System.out.println(addButton.getText()); -- log 
		fleeceAddButton.click();
		//++: fleeceAddButton.click(); -- log
		
		//add multiple items into shopping cart
		WebElement LabsAddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		//++: System.out.println(addButton.getText()); -- log 
		LabsAddButton.click();
		//++: fleeceAddButton.click(); -- log
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).isDisplayed());
		//++: verification of //button[@id='remove-test.allthethings()-t-shirt-(red)'] assertion -- log
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']")).isDisplayed());
		//++: verification of //button[@id='remove-sauce-labs-fleece-jacket'] assertion -- log
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).isDisplayed());
		//++: verification of //button[@id='remove-sauce-labs-fleece-jacket'] assertion -- log
	}
	@Test
	public static void verifyRemovingSingleItemsFromCart()
	{
		//login into saucedemo
		LoginStandard_user();		
		
		AddSingleItemsToCart();		
		navigateToCart();		
		
		WebElement removeButton = driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']"));
		System.out.println(removeButton.getText());
		//++: System.out.println(removeButton.getText()); -- log 
		removeButton.click();
		//++: removeButton.click(); -- log 
		
		continueShopping();		
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).isDisplayed());
	}


	@Test
	public static void verifyRemovingMultipleItemsFromCart()
	{
		//login into saucedemo
		LoginStandard_user();		
		
		AddMultipleItemsToCart();		
		navigateToCart();
		
		//add multiple items into shopping cart
		WebElement AllAddButton = driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']"));
		//++: System.out.println(addButton.getText()); -- log 
		AllAddButton.click();
		//++: AlladdButton.click(); -- log
		
		//add multiple items into shopping cart
		WebElement fleeceAddButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']"));
		//++: System.out.println(addButton.getText()); -- log 
		fleeceAddButton.click();
		//++: fleeceAddButton.click(); -- log
		
		//add multiple items into shopping cart
		WebElement LabsAddButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
		//++: System.out.println(addButton.getText()); -- log 
		LabsAddButton.click();
		//++: fleeceAddButton.click(); -- log
		
		continueShopping();
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).isDisplayed());
	}
		
	public static void LoginStandard_user()
	{
		//login into saucedemo
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		System.out.println("Standard_user successfully logged in.");
		//++: System.out.println("Standard_user successfully logged in."); -- log 
	}
	
	public static void AddSingleItemsToCart()
	{
		//add multiple items into shopping cart
		WebElement AllAddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
		System.out.println(AllAddButton.getText());
		//++: System.out.println(AllAddButton.getText()); -- log 
		AllAddButton.click();
		//++: AllAddButton.click(); -- log		
	}
	
	public static void AddMultipleItemsToCart()
	{
		//add multiple items into shopping cart
		WebElement AllAddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
		//++: System.out.println(addButton.getText()); -- log 
		AllAddButton.click();
		//++: AlladdButton.click(); -- log
		
		//add multiple items into shopping cart
		WebElement fleeceAddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
		//++: System.out.println(addButton.getText()); -- log 
		fleeceAddButton.click();
		//++: fleeceAddButton.click(); -- log
		
		//add multiple items into shopping cart
		WebElement LabsAddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		//++: System.out.println(addButton.getText()); -- log 
		LabsAddButton.click();
		//++: fleeceAddButton.click(); -- log
	}
	
	public static void navigateToCart()
	{
		WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		//++: --log verification of cart WebElement
		cart.click();		
		
	}
	
	public static void continueShopping()
	{
		//add multiple items into shopping cart
		WebElement ContinueShoppingAddButton = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
		//++: System.out.println(addButton.getText()); -- log 
		ContinueShoppingAddButton.click();
		//++: AlladdButton.click(); -- log
		
	}
	
}
