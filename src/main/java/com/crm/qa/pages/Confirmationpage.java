package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.componentspage.AbstractComponent;

public class Confirmationpage  extends AbstractComponent
{
	WebDriver driver;
	public Confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".summary_info")
	WebElement confirmmsg;
	
	@FindBy(xpath = "//button[contains(.,'Finish')]")
	WebElement finishbtn;
	
	@FindBy(xpath = "//h2[contains(.,'Thank you for your order!')]")
	WebElement successfulmsg;
	
	public String getConfirmationmessage()
	{
		return confirmmsg.getText();
	}
	public void ClickOnFinishBtn()
	{
		finishbtn.click();
	}
	public String getSuccessfulmessage()
	{
		return successfulmsg.getText();
	}
	

}
