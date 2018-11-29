package com.flipkart_pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage 
{
	@FindBy(className="_2zrpKA") private WebElement Username;
	@FindBy(xpath="//input[@type='password']") private WebElement Password;
	@FindBy(xpath="(//button[@type='submit'])[2]") private WebElement LoginButton;
	@FindBy(xpath="//span[contains(text(),'Please enter valid')]") private WebElement ErrorMsg;
	@FindBy(xpath="//div[contains(text(),'registered')]") private WebElement NotRegisteredError;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void Login(String un,String pwd)
	{
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		LoginButton.click();
	}
	public void ErrorMsg(String un,String pwd) throws InterruptedException
	{
		/*CASE- 1. Both User name and Password are entered correctly. */
		try
		{
			
			System.out.println("---------Emaild exists --------------\n-----------------------");
	          Username.sendKeys(un);
		}
		catch(Throwable e)
		{
			System.out.println("Userame field not found: " + e.getMessage());
		}
		//CASE- 2. Check whether Password field exists or not
	     try
	        {
	         System.out.println("----------Password exits ------------\n-----------------------");
	         Password.sendKeys(pwd);
	        }
	    catch(Throwable e)
	        {
		 System.out.println("Password field not found :" + e.getMessage());
	        }
	   //CASE- 3. Check whether both field are blank or not
	     try
	        {
	    	 if(Username.getAttribute("value").equals(""))
	    	 {
	    		 System.out.println("----------Username field is blank------------\n-----------------------");
	    	 }
	    	 if(Password.getAttribute("value").equals(""))
	    	 {
	    		 System.out.println("----------password field is blank------------\n-----------------------");
	    	 }
	        }
	    catch(Throwable e)
	        {
		 System.out.println("Both fields are blank :" + e.getMessage());
	        }
	     //CASE- 4. Check Login field is exists or not
	     try
	        {
	         System.out.println("----------Login button exits ------------\n-----------------------");
	         LoginButton.click();
	        }
	    catch(Throwable e)
	        {
		 System.out.println("Login field not found :" + e.getMessage());
	        }
	}
}
