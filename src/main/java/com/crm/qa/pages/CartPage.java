package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.componentspage.AbstractComponent;

public class CartPage  extends AbstractComponent
{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cart_item")
	List<WebElement>  cartproducts;
	
	@FindBy(id = "checkout")
	WebElement checkoutele;
	
	public boolean VerifyProductDisplay(String productName)
	{
		 boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(productName));
		 return match;
	}
	public void goToCheckout()
	{
		checkoutele.click();
	}

}
