package com.crm.qa.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSauce
{
    @Test(enabled = false)
    public void demoSauce()
    {
    	String productName="Sauce Labs Backpack";
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options=new ChromeOptions();
        options.addArguments("remote--allow--add--origin");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
       List<WebElement> productslist = driver.findElements(By.xpath("//div[@class='inventory_list']"));
      WebElement prod= productslist.stream().filter(product->
       product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)).findFirst().orElse(null);
      
      prod.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory ")).click();
      driver.findElement(By.cssSelector(".shopping_cart_link")).click();
      List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cart_item"));
      cartproducts.stream().filter(cartproduct->cartproduct.getText().equals(productName)).findFirst().orElse(null);
      driver.findElement(By.id("checkout")).click();
      driver.findElement(By.id("first-name")).sendKeys("xyz");
      driver.findElement(By.id("last-name")).sendKeys("abc");
      driver.findElement(By.id("postal-code")).sendKeys("123456");
      driver.findElement(By.id("continue")).click();
      System.out.println(driver.findElement(By.cssSelector(".summary_info")).getText());
      driver.findElement(By.id("finish")).click();
      System.out.println(driver.findElement(By.tagName("h2")).getText());
       
        
    	
    }
}
