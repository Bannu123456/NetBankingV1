package com.NetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.NetBanking.Utilities.*;

public class BaseClass
{
	ReadConfig rc =new ReadConfig();
	public String BaseURL=rc.getApplicationURL();
	public String Userid=rc.getUsername();
	public String Password=rc.getPassword();
	public static WebDriver driver;
	public static Logger log;
		
	@Parameters("browser")
	@BeforeClass
		public void Setup(String br)
	{
		log =Logger.getLogger("LoggerExample");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rc.getChromePath());
			 driver = new ChromeDriver();	
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rc.getFirefoxPath());
			 driver = new FirefoxDriver();		
		}
     	  driver.get(BaseURL);
	    driver.manage().window().maximize();
	}
	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname)throws IOException
	{
	TakesScreenshot ts =(TakesScreenshot)driver;
	File source= ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(source,target);
	System.out.println("Screenshot taken");
	}
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
}
