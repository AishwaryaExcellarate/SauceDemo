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

public class ErrorValidations   extends BaseTest
{
	@Test
	public void saucedemotest() throws IOException
	{
		String productName="Sauce Labs Backpack";
		
		
		ProductCataloguePage productcatalogue=landingpage.loginApplication("standard_user", "sauce");
		//landingpage.getErrormsg();
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", landingpage.getErrormsg());
		
		
		
		
		
	}
	

}
