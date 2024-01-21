package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class AddToCart extends TestBase {

	@Test(priority = 5)
	public static void verifyAddSingleItem() {
		
		logger.info("Verify add single item testcase start...");
		extentTest.log(LogStatus.INFO, "Verify add single item testcase start...");

		// login into sauce-demo
		LoginStandard_user();

		// in the product page + one items
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).isDisplayed());

		logger.info("Verify add single item testcase verified.");
		extentTest.log(LogStatus.PASS, "Verify add single item testcase verified.");
		// ++: log Assert verification

	}

	// FIXME: Would be better with test data.
	@Test(priority = 6)
	public static void verifyRemoveSingleItemProductPage() {
		
		logger.info("Verify removing single item testcase start...");
		extentTest.log(LogStatus.INFO, "Verify removing single item testcase start...");

		LoginStandard_user();

		String adIitmDscrpt = driver
				.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText();

		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

		WebElement rmvBtn = driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']"));
		wait.until(d -> rmvBtn.isDisplayed());

		logger.info(adIitmDscrpt + " added to cart.");
		extentTest.log(LogStatus.PASS, adIitmDscrpt + " added to cart.");

		Assert.assertTrue(rmvBtn.isDisplayed());
		logger.info(adIitmDscrpt + " added to cart.");
		extentTest.log(LogStatus.PASS, adIitmDscrpt + " removed from cart.");

		logger.info("Removing single item verified.");
		extentTest.log(LogStatus.PASS, "Removing single item verified.");
		// ++: --log Assert verification
	}

	// FIXME: Would be better with test data.
	@Test(priority = 7)
	public static void verifyAddingMultipleItems() {
		
		logger.info("Verify adding multiple items testcase started...");
		extentTest.log(LogStatus.PASS, "Verify adding multiple items testcase started...");

		LoginStandard_user();
		AddMultipleItemsToCart();

		logger.info("Adding multiple items testcase verified...");
		extentTest.log(LogStatus.PASS, "Adding multiple items testcase verified...");
	}

	// FIXME: Would be better with test data.
	@Test(priority = 8)
	public static void verifyRemovingMultipleItemsProductPage() {
		
		logger.info("Verify Removing Multiple Items in the Product Page testcase start...");
		extentTest.log(LogStatus.PASS, "Verify Removing Multiple Items in the Product Page testcase start...");

		// login into sauce-demo
		LoginStandard_user();

		// + item 1
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).isDisplayed());
		
		logger.info(driver.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText() + " added & then removed from cart.");
		extentTest.log(LogStatus.PASS, driver.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText() + " added & then removed from cart.");

		// ==============================================================================================================================================================

		// + item 2
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).isDisplayed());
		extentTest.log(LogStatus.PASS, driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']")).getText() + " added & then removed from cart.");
		logger.info(driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']")).getText() + " added & then removed from cart.");

		// ===============================================================================================================================================================

		// + item 3
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).isDisplayed());
		extentTest.log(LogStatus.PASS, driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText() + " added & then removed from cart.");
		logger.info(driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText() + " added & then removed from cart.");

		// ===============================================================================================================================================================
	}

	@Test(priority = 9)
	public static void verifyRemovingSingleItemsFromCart() {
		extentTest.log(LogStatus.PASS, "Verify removing a singleiItem from cart testcase start...");
		logger.info("Verify removing a singleiItem from cart testcase start...");

		// ??: find out more about Work/page-flows.
		LoginStandard_user();
		AddSingleItemsToCart();
		navigateToCart();

		WebElement cartItemDscrpt = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		Assert.assertTrue(cartItemDscrpt.isDisplayed());
		extentTest.log(LogStatus.PASS, cartItemDscrpt + " item found in the shopping cart.");
		logger.info(cartItemDscrpt + " item found in the shopping cart.");

		driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).click();

		// ??: find out more about Work/page-flows.
		continueShopping();

		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"))
				.isDisplayed());

		extentTest.log(LogStatus.PASS, "Verify removing a singleiItem from cart testcase verified.");
		logger.info("Verify removing a singleiItem from cart testcase verified.");
	}

	@Test(priority = 10)
	public static void verifyRemovingMultipleItemsFromCart() {
		extentTest.log(LogStatus.PASS, "Verify removing multiple items from cart testcase start...");
		logger.info("Verify removing multiple items from cart testcase start...");

		// login into saucedemo
		LoginStandard_user();

		AddMultipleItemsToCart();
		navigateToCart();

		// ===============================================================================================================================================================

		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']")).click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).click();

		// ===============================================================================================================================================================

		continueShopping();

		// ===============================================================================================================================================================

		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"))
				.isDisplayed());
		extentTest.log(LogStatus.PASS, "Item removed successfully.");
		logger.info("Item removed successfully.");
		// ++: --log verification
		Assert.assertTrue(
				driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).isDisplayed());
		extentTest.log(LogStatus.PASS, "Item removed successfully.");
		logger.info("Item removed successfully.");
		// ++: --log verification
		Assert.assertTrue(
				driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).isDisplayed());
		extentTest.log(LogStatus.PASS, "Item removed successfully.");
		logger.info("Item removed successfully.");
		// ++: --log verification

		// ===============================================================================================================================================================

		extentTest.log(LogStatus.PASS, "Verify removing multiple items from cart testcase verified.");
	}

	public static void LoginStandard_user() {
		// login into saucedemo
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		extentTest.log(LogStatus.PASS, "Standard_user successfully logged in.");
		logger.info("Standard_user successfully logged in.");
	}

	public static void AddSingleItemsToCart() {
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

		WebElement rmvBtn = driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']"));
		wait.until(d -> rmvBtn.isDisplayed());

		Assert.assertTrue(
				driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']")).isDisplayed());
		extentTest.log(LogStatus.PASS, "1 item added to cart.");
		logger.info("1 item added to cart.");
	}

	public static void AddMultipleItemsToCart() {
		// Get add button & items description then click Add button.

		// FIXME: data-driven: externalize items & qty to be added/
		// NOTE: should be verification mechanism to add items to cart & inform.

		// ++ AddMultipleItemsToCartc sheet on excel: No items + which items
		// ++ DataProvider Decoration.

		// ===============================================================================================================================================================

		// ++ item 1

		String item1Dscrpt = driver
				.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText();
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

		WebElement allRmvBtn = driver.findElement(By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']"));
		wait.until(d -> allRmvBtn.isDisplayed());

		Assert.assertTrue(allRmvBtn.isDisplayed());
		extentTest.log(LogStatus.PASS, item1Dscrpt + " added to cart.");
		logger.info(item1Dscrpt + " added to cart.");

		// ===============================================================================================================================================================

		// ++ item 2

		String item2Dscrpt = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']"))
				.getText();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();

		WebElement fleeceRmvBtn = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']"));
		wait.until(d -> fleeceRmvBtn.isDisplayed());

		Assert.assertTrue(fleeceRmvBtn.isDisplayed());
		extentTest.log(LogStatus.PASS, item2Dscrpt + " added to cart.");
		logger.info(item2Dscrpt + " added to cart.");

		// ===============================================================================================================================================================

		// ++ item 3

		String item3Dscrpt = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

		WebElement labsRmvBtn = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
		wait.until(d -> labsRmvBtn.isDisplayed());

		Assert.assertTrue(labsRmvBtn.isDisplayed());
		extentTest.log(LogStatus.PASS, item3Dscrpt + " added to cart.");
		logger.info(item3Dscrpt + " added to cart.");

	}

	public static void navigateToCart() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		extentTest.log(LogStatus.PASS, "To cart navigation, successful.");
		logger.info("To cart navigation, successful.");
	}

	public static void continueShopping() {
		driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		extentTest.log(LogStatus.PASS, "Continue shopping, successful.");
		logger.info("Continue shopping, successful.");
	}

}
