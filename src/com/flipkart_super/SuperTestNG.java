package com.flipkart_super;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNG 
{
	protected WebDriver driver;
	@BeforeMethod
	public void Precondition()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		System.out.println("TestCase Stated \n");
	}
	@AfterMethod
	public void PostCondition()
	{
		driver.close();
		System.out.println("TestCase Ended \n");
	}
}
