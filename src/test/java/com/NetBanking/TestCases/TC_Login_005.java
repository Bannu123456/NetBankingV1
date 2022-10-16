package com.NetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NetBanking.PageObjects.LoginGuru;

public class TC_Login_005 extends BaseClass
{
	@Test
	public void ValidRegister() throws IOException {
		log.info("login object created");
	LoginGuru login = new LoginGuru(driver);
	log.info("clicking register link");
	login.ClickRegister();
	driver.switchTo().defaultContent();
	log.info("Getting current url");
	String s= driver.getCurrentUrl();
	if(s.equals("https://demo.guru99.com/"))
	{
		captureScreen(driver,"ValidRegister");
		log.info("Testcase05 Passed");
		Assert.fail();
	}
	else
	{
		captureScreen(driver,"validRegister");
		Assert.assertTrue(false);
		log.info("Testcase05 failed");
	}
}
}
