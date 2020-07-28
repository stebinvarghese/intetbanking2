package com.inetBanking2.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking2.pageObjects.LoginPage2;


public class TC_LoginTest_002 extends BaseClass2 {

	@Test
	public void loginTest() throws InterruptedException
	
	{
		Thread.sleep(5000);
		
		logger1.info("URL opened");
		Thread.sleep(5000);
	
		LoginPage2 Lp2= new LoginPage2(driver);
		
		Lp2.setUserName(username2);
		logger1.info("UserName enered");
		Lp2.setPassword(password2);
		logger1.info("Password enered");
		Lp2.clickSubmit();
		logger1.info("click submit");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger1.info("Test case passed");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger1.info("Test case failed");
		}
       
	}

}



