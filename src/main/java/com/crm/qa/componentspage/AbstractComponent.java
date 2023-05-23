package com.crm.qa.componentspage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.pages.CartPage;

public class AbstractComponent
{
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(css = ".shopping_cart_link")
	WebElement cartHeader;
	
	public CartPage goTocartPage()
	{
		cartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	


	public void waitforElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitforElementToDisappear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}


}
