package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.componentspage.AbstractComponent;

public class CheckoutPage  extends AbstractComponent
{
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first-name")
	WebElement Firstnameedt;
	
	@FindBy(id = "last-name")
	WebElement Lastnameedt;
	
	@FindBy(id = "postal-code")
	WebElement  postalcodeedt;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continuebtn;
	
	public void Enterdetails(String fname, String lname,String pcode)
	{
		Firstnameedt.sendKeys(fname);
		Lastnameedt.sendKeys(lname);
		postalcodeedt.sendKeys(pcode);
	}
	public Confirmationpage ClickOnContinueBtn()
	{
		continuebtn.click();
		return new  Confirmationpage(driver);
	}
	
	
	

}
