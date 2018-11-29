package com.flipkart_test;

import org.testng.annotations.Test;
import com.flipkart_pom.HomePage;
import com.flipkart_pom.LoginPage;
import com.flipkart_super.SuperTestNG;

public class FlipkartLogin extends SuperTestNG
{
	@Test(priority=1)
	public void LoginTest() throws InterruptedException
	{
		System.out.println("----------LoginTest Started ------------\n-----------------------");
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.ErrorMsg("username", "password");
		HomePage HomePage=new HomePage(driver);
		HomePage.VerificationForHomePage(driver);
		System.out.println("----------LoginTest Ended ------------\n-----------------------");
	}
}
