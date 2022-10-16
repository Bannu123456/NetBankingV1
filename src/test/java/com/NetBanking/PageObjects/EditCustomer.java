package com.NetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {
   WebDriver driver;
  @FindBy(name="cusid")WebElement CustomerID;
  @FindBy(name="AccSubmit")WebElement Submit;
  @FindBy(name="res")WebElement Reset;
  @FindBy(linkText="Home")WebElement HomePage;
  public EditCustomer(WebDriver d) {
		driver =d; 
		PageFactory.initElements(driver, this);
	}
  public void setCustomerID(String id)
  {
  	CustomerID.sendKeys(id);
  }public void clickSubmit()
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
