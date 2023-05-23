package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.componentspage.AbstractComponent;

public class ProductCataloguePage extends AbstractComponent
{
	 WebDriver driver;
	public ProductCataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='inventory_list']")
	List<WebElement> Productslist;
	

     By ProductName = By.cssSelector(".inventory_item_name");
     
     By addtoCart = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory ");
	

    public List<WebElement> getProductList()
	{
		return Productslist;
		}
    public WebElement getProductByName(String productName)
    {
    	WebElement prod= getProductList().stream().filter(product->
        product.findElement(ProductName).getText().equals(productName)).findFirst().orElse(null);
    	return prod;

    }
    
    public void addProductToCart(String productName)
    {
    	WebElement prod = getProductByName(productName);
    	 prod.findElement(addtoCart).click();
    }
	

}
