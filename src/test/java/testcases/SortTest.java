package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.ReadXlsData;

public class SortTest extends TestBase {
	
	@Test(priority=12,dataProviderClass=ReadXlsData.class,dataProvider="saucedemoTestData")
	public static void verifySorting(String selectOptions)
	{
		extentTest.log(LogStatus.PASS,"Verify sorting testcase start...");
		logger.info("Verify sorting testcase start...");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		drpCountry.selectByVisibleText(selectOptions);
		
		extentTest.log(LogStatus.PASS, "Verify sorting testcase verified.");
		logger.info("Verify sorting testcase verified.");
	}

}
