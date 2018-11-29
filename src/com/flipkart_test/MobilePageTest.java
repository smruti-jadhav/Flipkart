package com.flipkart_test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.testng.annotations.Test;

import com.flipkart_pom.HomePage;
import com.flipkart_pom.LoginPage;
import com.flipkart_pom.MobilePage;
import com.flipkart_super.SuperTestNG;

public class MobilePageTest extends SuperTestNG
{
	
	@Test(priority=1)
	public void ClickOnMobilePage() throws InterruptedException
	{
		System.out.println("----------MobilePageTest Started ------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		
		HomePage  HomePage=new HomePage(driver);
		HomePage.VerificationForHomePage(driver);
		HomePage.ClickOnMobile(driver);
		Thread.sleep(5000);
		MobilePage MobilePage=new MobilePage(driver);
		MobilePage.VerifyMobilePage();
		//System.out.println(driver.getCurrentUrl());
		//HomePage.SearchMobiles();
		//MobilePage MobilePage=new MobilePage(driver);
		//MobilePage.VerifyMobilePage();
		//System.out.println(driver.getCurrentUrl());
		System.out.println("----------MobilePageTest Ended ------------\n-----------------------");
	}
	@Test(priority=2)
	public void VerifyMobilePageBySearch() throws InterruptedException
	{
		System.out.println("----------MobilePageTest with the help of saerch field Started ------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		
		HomePage  HomePage=new HomePage(driver);
		HomePage.VerificationForHomePage(driver);
		HomePage.SearchMobiles("Mobiles");
		Thread.sleep(5000);
		MobilePage MobilePage=new MobilePage(driver);
		MobilePage.VerifyMobilePage();
		System.out.println("----------MobilePageTest with the help of saerch field Ended ------------\n-----------------------");
	}
	@Test(priority=3)
	public void getFilteredItems() throws InterruptedException
	{
		System.out.println("----------FilterMobileSpecification Started ------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		HomePage  HomePage=new HomePage(driver);
		HomePage.ClickOnMobile(driver);
		MobilePage MobilePage=new MobilePage(driver);
		//Thread.sleep(5000);
		MobilePage.ClickOnGB(driver);
		Thread.sleep(2000);
		MobilePage.VerifyFilteredSpecifcation();
		System.out.println("----------FilterMobileSpecification Ended ------------\n-----------------------");
	}
	@Test(priority=4)
	public void VerifyBrandCheckbox() throws InterruptedException
	{
		System.out.println("----------Veriy Brand Checkbox test Started ------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		HomePage  HomePage=new HomePage(driver);
		HomePage.ClickOnMobile(driver);
		MobilePage MobilePage=new MobilePage(driver);
		//Thread.sleep(5000);
		Thread.sleep(2000);
		MobilePage.SearchMotoBrand(driver);
		System.out.println("----------Veriy Brand Checkbox test Ended ------------\n-----------------------");
	}
	@Test(priority=5)
	public void VerifyFilteredMotoList() throws InterruptedException
	{
		System.out.println("----------Veriy Filtered list by searching brand moto started ------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		HomePage  HomePage=new HomePage(driver);
		Thread.sleep(10000);
		HomePage.ClickOnMobile(driver);
		MobilePage MobilePage=new MobilePage(driver);
		MobilePage.SearchMotoBrand(driver);
		MobilePage.VerifyBrandSpecification(driver);
		System.out.println("----------Veriy Filtered list by searching brand moto Ended ------------\n-----------------------");
	}
	@Test
	public void VerifyOtherBrandWith4GB() throws InterruptedException
	{
		System.out.println("----------Veriy Multiple Brand in Mobile page with 4GB RAM started ------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		HomePage  HomePage=new HomePage(driver);
		Thread.sleep(10000);
		HomePage.ClickOnMobile(driver);
		MobilePage MobilePage=new MobilePage(driver);
		MobilePage.ApplyRamAndBrandFilter(driver);
		System.out.println("----------Veriy Multiple Brand in Mobile page with 4GB RAM ended------------\n-----------------------");
	}
	@Test
	public void VerifyDetailsAreOnOpenOnNewTab() throws InterruptedException
	{
		System.out.println("----------Filtered Mobile open in new tab test started------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		HomePage  HomePage=new HomePage(driver);
		Thread.sleep(10000);
		HomePage.SearchMobiles("Moto G5");
		MobilePage MobilePage=new MobilePage(driver);
		MobilePage.OpenDetailsOnAnotherTab(driver);
		System.out.println("----------Filtered Mobile open in new tab test Ended------------\n-----------------------");
	}
	@Test
	public void VerifyCartPage() throws InterruptedException
	{
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		HomePage  HomePage=new HomePage(driver);
		Thread.sleep(10000);
		HomePage.SearchMobiles("Moto G5");
		MobilePage MobilePage=new MobilePage(driver);
		MobilePage.OpenDetailsOnAnotherTab(driver);
		MobilePage.ClickOnCart(driver);
	}
	
}
