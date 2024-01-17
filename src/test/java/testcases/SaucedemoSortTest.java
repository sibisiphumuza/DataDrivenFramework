package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ReadXlsData;

public class SaucedemoSortTest extends TestBase {
	
	@Test(dataProviderClass=ReadXlsData.class,dataProvider="sauceDemoTestData")
	public static void verifySorting(String selectOptions)
	{
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		drpCountry.selectByVisibleText(selectOptions);
	}

}
