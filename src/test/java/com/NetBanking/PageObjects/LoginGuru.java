package com.NetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginGuru 
{
	public  static WebDriver driver;
	@FindBy(name="uid")WebElement Userid;
	@FindBy(name="password")WebElement Password;
	@FindBy(name="btnLogin")WebElement Login;
	@FindBy(name="btnReset")WebElement Reset;
	@FindBy(linkText="here")WebElement Register;
	@FindBy(linkText="Log out")WebElement Logout;

	public LoginGuru(WebDriver driver)
	{
		LoginGuru.driver =driver; 
		PageFactory.initElements(driver, this);
	}
    public void setUserid(String uid)
    {
    	Userid.sendKeys(uid);
    }
    public void setPassword(String pass)
    {
    	Password.sendKeys(pass);
    }
    public void clickLogin()
    {
    	Login.click();
    }
    public void clickReset()
    {
    	Reset.click();
    }
    public void ClickRegister()
    {
    	Register.click();
    }
    public void ClickLogout()
    {
    	Logout.click();
    }
	}

