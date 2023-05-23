package com.crm.qa.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.pages.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializedriver() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\aishwaryaa\\eclipse-workspace\\SauceDemo\\src\\main\\java\\com\\crm\\qa\\Resources\\GlobalData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Browsername = prop.getProperty("browser");
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		String Productname = prop.getProperty("productName");
		if(Browsername.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
    	//ChromeOptions options=new ChromeOptions();
        //options.addArguments("remote--allow--add--origin");
         driver=new ChromeDriver();
       
		}
		/*
		 * else if(Browsername.equalsIgnoreCase("firefox")) { driver=new
		 * FirefoxDriver(); } else if(Browsername.equalsIgnoreCase("edge")) { driver=new
		 * EdgeDriver(); }
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     return driver;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
	driver=initializedriver();
	landingpage= new LandingPage(driver);
	landingpage.gotoUrl();
	return landingpage;
	}
	
	
	@AfterMethod
	public  void closeBrowser()
	{
		driver.quit();
	}
	
	

}
