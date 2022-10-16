package com.NetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	WebDriver driver;
	@FindBy(name="name")WebElement CustomerName;
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")WebElement GenderMale;
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[2]")WebElement GenderFemale;
	@FindBy(id="dob")WebElement DateofBirth;
	@FindBy(name="addr")WebElement Address;
	@FindBy(name="city")WebElement City;
	@FindBy(name="state")WebElement State;
	@FindBy(name="pinno")WebElement Pin;
	@FindBy(name="telephoneno")WebElement MobileNo;
	@FindBy(name="emailid")WebElement Email;
	@FindBy(name="password")WebElement Password;

	@FindBy(name="sub")WebElement Submit;
	@FindBy(name="res")WebElement Reset;
	@FindBy(linkText="Home")WebElement HomePage;

	public AddCustomer(WebDriver d) {
		driver =d; 
		PageFactory.initElements(driver, this);
	}
    public void setCustomerName(String name)
    {
    	CustomerName.sendKeys(name);
    }
    public void setGenderMale()
    {
    	GenderMale.click();
    }
    public void setGenderFemale()
    {
    	GenderFemale.click();
    }
    public void setDateofBirth()
    {
    	DateofBirth.click();
    }
    public void setAddress(String add)
    {
    	Address.sendKeys(add);
    }
    public void setCity(String city)
    {
    	City.sendKeys(city);
    }
    public void setState(String state)
    {
    	State.sendKeys(state);
    }
    public void setPin(String pin)
    {
    	Pin.sendKeys(pin);
    }
    public void setMobileNo(String mno)
    {
    	MobileNo.sendKeys(mno);
    	
    }
    public void setEmail(String email)
    {
    	Email.sendKeys(email);
    }
    public void setPassword(String pass)
    {
    	Password.sendKeys(pass);
    }
    public void clickSubmit()
    {
    	Submit.click();
    }
    public void clickReset()
    {
    	Reset.click();
    }
    public void ClickHomePage()
    {
    	HomePage.click();
    }
	}
