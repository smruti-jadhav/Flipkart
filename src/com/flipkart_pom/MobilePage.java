package com.flipkart_pom;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobilePage 
{
	@FindBy(className="_2yAnYN") private WebElement VerifyMobileText;
	@FindBy(xpath="(//div[contains(text(),'4 GB')])[1]") private WebElement GBRam;
	@FindBy(xpath="(//div[@class='_1UoZlX'])[1]") private WebElement FilteredList1;
	@FindBy(xpath="(//div[@class='_1UoZlX'])[2]") private WebElement FilteredList2;
	@FindBy(className="_3vKPvR") private WebElement SearchBrand;
	@FindBy(xpath="//div[@data-id='MOBF7FMRRGXFB8EU']") private WebElement FilteredListBrand1;
	@FindBy(xpath="//div[@data-id='MOBEZ9U3NHKDGQVH']") private WebElement FilteredListBrand2;
	@FindBy(xpath="(//div[text()='Motorola'])[1]") private WebElement BrandClearAll;
	@FindBy(xpath="//div[text()='Moto G5 Plus (Lunar Grey, 32 GB)']") private WebElement MotoSearchedMobile;
	@FindBy(className="_2AkmmA _2Npkh4 _2MWPVK") private WebElement AddCartButton;
	
	public MobilePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void VerifyMobilePage()
	{
		try
		{
			if(VerifyMobileText.isDisplayed())
			{
				System.out.println("----------Mobile Page Found Successfully ------------\n-----------------------");
			}
		}
		catch(Exception e)
		{
			System.out.println("----------Mobile page not found ------------\n-----------------------");
		}
	}
	public void ClickOnGB(WebDriver driver)
	{
		if(GBRam.isEnabled())
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(10,500)");
			GBRam.click();
		}
	}
	
	public void VerifyFilteredSpecifcation()
	{
		System.out.println("----------Verify Filtered Specification Test started------------\n-----------------------");
		if(FilteredList1.isDisplayed()&&FilteredList2.isDisplayed())
		{
			String getRAM= FilteredList1.getText();
			if(getRAM.contains("4 GB RAM"))
			{
				System.out.println("----------Verify First filtered Item details------------\n-----------------------");
			}
			getRAM= FilteredList2.getText();
			if(getRAM.contains("4 GB RAM"))
			{
				System.out.println("----------Verify Second filtered Item details------------\n-----------------------");
			}
			else
			{
				System.out.println("----------Verify Failed------------\n-----------------------");
			}
		}
		System.out.println("----------Verify Filtered Specification Test Ended------------\n-----------------------");
	}
	public void SearchMotoBrand(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(10,700)");
		SearchBrand.sendKeys("Moto");
		List<WebElement> SearchList = driver.findElements(By.xpath("//div[2][contains(text(),'Moto')]"));
		for (WebElement list : SearchList)
		{
			String text=list.getText();
			if(text.contains("Moto"))
			{
			System.out.println("----------Motorolla checkbox identified------------\n-----------------------");
			//list.click();
			}
			else
			{
			System.out.println("----------Motorolla checkbox is not identified------------\n-----------------------");
			}
		}
	}
	public void VerifyBrandSpecification(WebDriver driver)
	{
		System.out.println("----------Verify Brand Specification Test started------------\n-----------------------");
		List<WebElement> SearchList = driver.findElements(By.xpath("//div[2][contains(text(),'Moto')]"));
		for (WebElement list : SearchList)
		{
			String text=list.getText();
			if(text.contains("Moto"))
			{
				list.click();
				break;
			}
			else
			{
				System.out.println("cannot checked");
			}
		}
			

		if(FilteredListBrand1.isDisplayed()&&FilteredListBrand2.isDisplayed())
		{
			String getBrand= FilteredListBrand1.getText();
			if(getBrand.contains("Moto"))
			{
				System.out.println("----------Verify First filtered Item details conatins Brand Info------------\n-----------------------");
			}
			getBrand= FilteredListBrand2.getText();
			if(getBrand.contains("Moto"))
			{
				System.out.println("----------Verify Second filtered Item details conatins Brand Info------------\n-----------------------");
			}
			else
			{
				System.out.println("----------Verify for Brand is Failed------------\n-----------------------");
			}
		}
		System.out.println("----------Verify Brand Specification Test Ended------------\n-----------------------");
	}
	public void ApplyRamAndBrandFilter(WebDriver driver) throws InterruptedException
	{
		ClickOnGB(driver);
		WebDriverWait wait = new WebDriverWait(driver,240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='_1UoZlX'])[1]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(10,700)");
		SearchBrand.sendKeys("Moto");
		List<WebElement> SearchList = driver.findElements(By.xpath("//div[2][contains(text(),'Moto')]"));
		for (WebElement list : SearchList)
		{
			String text=list.getText();
			if(text.contains("Moto"))
			{
				list.click();
				break;
			}
			else
			{
				System.out.println("cannot clecked");
			}
		}
		BrandClearAll.click();
		Thread.sleep(10000);
		List<WebElement> List_Mobiles = driver.findElements(By.className("_3O0U0u"));
		int count=List_Mobiles.size();
		for(int i=0;i<count;i++)
		{
			String Description=List_Mobiles.get(i).getText();
			if(Description.contains("Redmi")||Description.contains("Samsung")||Description.contains("Nokia")||Description.contains("Vivo"))
			{}
		}
		System.out.println("----------Verify Multiple Brands------------\n-----------------------");
		
	}
	public void OpenDetailsOnAnotherTab(WebDriver driver) throws InterruptedException
	{
		String two=driver.getWindowHandle();
		System.out.println(two);
		List<WebElement> List_Mobiles = driver.findElements(By.className("_3O0U0u"));
		int count=List_Mobiles.size();
		for(int i=0;i<count;i++)
		{
			String Description=List_Mobiles.get(i).getText();
			if(Description.contains("Lunar Grey")&&Description.contains("32 GB"))
			{
				Actions act=new Actions(driver);
				act.contextClick(MotoSearchedMobile).perform();
				act.sendKeys(Keys.DOWN,Keys.ENTER).perform();
				MotoSearchedMobile.sendKeys(Keys.CONTROL,Keys.TAB);
			}
		}
		System.out.println("----------Filtered mobile open in new tab------------\n-----------------------");
	}
	public void ClickOnCart(WebDriver driver)
	{
		String two=driver.getWindowHandle();
		System.out.println(two);
		System.out.println(two);
		AddCartButton.click();
	}
}
