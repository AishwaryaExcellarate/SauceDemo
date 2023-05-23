package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.componentspage.AbstractComponent;

public class LandingPage extends AbstractComponent
{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement UsernameEdt;
	
	@FindBy(id = "password")
	WebElement PasswordEdt;
	
	@FindBy(id =  "login-button")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errormsg;
	
	
	public ProductCataloguePage loginApplication(String uname,String pwd)
	{
		UsernameEdt.sendKeys(uname);
		PasswordEdt.sendKeys(pwd);
		LoginBtn.click();
		ProductCataloguePage productcatalogue=new ProductCataloguePage(driver);
		return productcatalogue;
	}
	
	public String getErrormsg()
	{
		return errormsg.getText();
	}
	
	public void gotoUrl()
	{
		driver.get("https://www.saucedemo.com/");
	}

}
