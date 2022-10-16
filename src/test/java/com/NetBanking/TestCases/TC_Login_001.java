package com.NetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NetBanking.PageObjects.*;
public class TC_Login_001 extends BaseClass
{
	@Test
	public void Valid() throws IOException
	{
	log.info("Creating object to LoginPage objects");
	LoginGuru login = new LoginGuru(driver);
	login.setUserid(Userid);
	login.setPassword(Password);
	login.clickLogin();
boolean b=true;
	
	if(b==(driver.getTitle().equals("Guru99 Bank Manager HomePage")))
	{
		Assert.assertTrue(true);
		log.info("Testcase01 Passed");
	}
	else
	{
		captureScreen(driver,"Valid");
		Assert.assertTrue(false);
		log.info("Testcase01 failed");
	}
	}
}
