package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class TCAutomationLoginTests extends TestBase {

	@Test
	
	public static void IsEmailFieldValidTest()
	{}
	
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
