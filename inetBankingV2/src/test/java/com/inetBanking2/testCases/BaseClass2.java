package com.inetBanking2.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking2.utilities.ReadConfig2;

public class BaseClass2 {

	ReadConfig2 readconfig = new ReadConfig2();
	public String baseURL2 = readconfig.getApplicationURL();
	public String username2 = readconfig.getUsername();
	public String password2 = readconfig.getPassword();
	public WebDriver driver;

	public static Logger logger1;

	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br)

	{
		logger1 = Logger.getLogger("inetBanking2");
		PropertyConfigurator.configure("log4j.properties");
		
		if (br.equals("firefox")) 
		
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			
		} 
		else if (br.equals("chrome")) 
		
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			

		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL2);	
	
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	

}