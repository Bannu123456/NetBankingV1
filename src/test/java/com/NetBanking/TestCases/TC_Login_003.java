package com.NetBanking.TestCases;

	import java.io.IOException;

	import org.openqa.selenium.NoAlertPresentException;
	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
import com.NetBanking.PageObjects.*;
	import com.NetBanking.Utilities.XLUtils;

	public class TC_Login_003 extends BaseClass
	{

		@Test(dataProvider="TestData")
		public void loginDDT(String user,String pwd) throws InterruptedException, IOException
		{
			LoginGuru lp=new LoginGuru(driver);
			lp.setUserid(user);
			log.info("user name provided");
			lp.setPassword(pwd);
			log.info("password provided");
			lp.clickLogin();
			
			//Thread.sleep(3000);
			
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				log.warn("Login failed");
				log.info("Getting current url");
				String s= driver.getCurrentUrl();
				if(s.equals("https://demo.guru99.com/V4/index.php"))
				{
					log.info("Testcase Passed");
				}
				else
				{
					captureScreen(driver,"loginTTD");
					Assert.assertTrue(false);
					log.info("Testcase failed");
				}
			}
			else
			{
				Assert.assertTrue(true);
				log.info("Login passed");
				lp.ClickLogout();
				//Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				log.info("Getting current url");
				String s= driver.getCurrentUrl();
				if(s.equals("https://demo.guru99.com/V4/index.php"))
				{
					log.info("Testcase Passed");
				}
				else
				{
					captureScreen(driver,"LoginTTD");
					Assert.assertTrue(false);
					log.info("Testcase failed");
				}
			}	
		}
		
		public boolean isAlertPresent() //user defined method created to check alert is presetn or not
		{
			try
			{
			driver.switchTo().alert();
			return true;
			}
			catch(NoAlertPresentException e)
			{
				return false;
			}
		}
				
		@DataProvider(name="TestData")
		String [][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/com/Netbanking/TestData/TestData.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		}
		
	}

