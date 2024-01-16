package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class Login extends TestBase {

	@Test
	
	public static void LoginTest()
	{
		// TODO Auto-generated method stub		
		
		WebElement intro = driver.findElement(By.xpath(locators.getProperty("intro")));
		WebElement remember = driver.findElement(By.xpath(locators.getProperty("remember")));
		WebElement tools = driver.findElement(By.xpath(locators.getProperty("tools")));
		WebElement connect = driver.findElement(By.xpath(locators.getProperty("connect")));
		WebElement repos = driver.findElement(By.xpath(locators.getProperty("repos")));
		
		System.out.println(intro.getText());
		System.out.println(remember.getText());
		System.out.println(tools.getText());
		System.out.println(connect.getText());
		System.out.println(repos.getText());

	}

}
