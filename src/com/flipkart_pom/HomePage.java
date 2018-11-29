package com.flipkart_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class HomePage 
{
	@FindBy(xpath="//span[contains(text(),'Electronics')]") private WebElement ElectronicsTopMenu;
	@FindBy(xpath="//div[contains(text(),'My Account')]") private WebElement MyAccountLink;
	@FindBy(xpath="//a[@title='Mobiles']") private WebElement MobilesLink;
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']") private WebElement SearchField;
	@FindBy(className="vh79eN") private WebElement SearchSubmitButton;
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void VerificationForHomePage(WebDriver driver)
	{
		try
        {
			//String text=ElectronicsTopMenu.getText();
        //if(text.equals("Electronics"))
		WebDriverWait wait = new WebDriverWait(driver,240);
		wait.until(ExpectedConditions.elementToBeClickable(ElectronicsTopMenu));
		wait.until(ExpectedConditions.elementToBeClickable(SearchField));
        	if(ElectronicsTopMenu.isEnabled())
       {
	System.out.println("----------Home page is visible and Element is found -------\n-----------------------");
       }else if(SearchField.isEnabled())
       {
	System.out.println("----------Home page is visible and search field is found ----------\n-----------------------");
	}
       else
       {
    	   System.out.println("----------Home page and element is not found ----------\n-----------------------");
       }
       }
     catch(Throwable e)
        {
	 System.out.println("Home page not found :"+e.getMessage());
        }
		if(MyAccountLink.isEnabled())
		{
			System.out.println("----------Login Successfully ------------\n-----------------------");
		}
		else
		{
			System.out.println("----------Login Failed ------------\n-----------------------");
		}
	}
	public void ClickOnMobile(WebDriver driver) throws InterruptedException
	{
		if(ElectronicsTopMenu.isEnabled())
		{
			ElectronicsTopMenu.click();
			if(MobilesLink.isEnabled())
			{
				MobilesLink.click();
				System.out.println("----------Clicked on MobileLink Successfully ------------\n-----------------------");
			}
			else
			{
				System.out.println("----------Mobile Link is disabled ------------\n-----------------------");
			}
		}
		else
		{
			System.out.println("Electronics field link is disabled");
		}
	}
	public void SearchMobiles(String value)
	{
		SearchField.sendKeys(value);
		SearchSubmitButton.click();
	}
	
}
