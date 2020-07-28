package com.inetBanking2.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking2.pageObjects.AddCustomerPage;
import com.inetBanking2.pageObjects.LoginPage2;



public class TC_AddCustomerTest_003 extends BaseClass2
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage2 Lp2=new LoginPage2(driver);
		Lp2.setUserName(username2);
		logger1.info("User name is provided");
		Lp2.setPassword(password2);
		logger1.info("Passsword is provided");
		Lp2.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger1.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger1.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger1.info("test case passed....");
			
		}
		else
		{
			logger1.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
