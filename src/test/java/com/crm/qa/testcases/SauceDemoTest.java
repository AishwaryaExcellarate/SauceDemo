package com.crm.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.TestComponents.BaseTest;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.CheckoutPage;
import com.crm.qa.pages.Confirmationpage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.ProductCataloguePage;

public class SauceDemoTest   extends BaseTest
{
	@Test
	public void saucedemotest() throws IOException
	{
		String productName="Sauce Labs Backpack";
		String Username="standard_user";
		String Password="secret_sauce";
		String Firstname="abc";
		String Lastname="xyz";
		String Postalcode="123456";
		
		ProductCataloguePage productcatalogue=landingpage.loginApplication(Username,Password );
		
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartpage=productcatalogue.goTocartPage();
		boolean match = cartpage.VerifyProductDisplay(productName);
        cartpage.goToCheckout();
		
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.Enterdetails(Firstname,Lastname,Postalcode);
		JavascriptExecutor jsc=(JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,+250)");
		checkoutpage.ClickOnContinueBtn();
		
		Confirmationpage confirmationpage=new Confirmationpage(driver);
		System.out.println(confirmationpage.getConfirmationmessage());
		confirmationpage.ClickOnFinishBtn();
		System.out.println(confirmationpage.getSuccessfulmessage());
		
		
	}
	

}
