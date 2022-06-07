package com.vyasa.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.vyasa.pages.MyAccountsPage;

public class MyAccountsPageTests extends TestBase {
 
	MyAccountsPage myaccountpage;
	public MyAccountsPageTests(){
		super();
	}
	
	@BeforeClass
	public void Setup()
	{
		//initDriver();
		myaccountpage=new MyAccountsPage(driver);
		driver.get("http://practice.automationtesting.in/my-account/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void verifyloginToMyAccount()
	{
		myaccountpage.loginToMyAccount("vyasainstitute2022@gmail.com","vyasainstitute2022");
		String actualtitle="My Account – Automation Practice Site";
		String expectedtitle=myaccountpage.getPageTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		logger.info("verifyloginToMyAccount............Pass");
	}
	
	@Test(priority=2)
	public void verfiyLogoutToMyAccount()
	{
		myaccountpage.logoutFromMyAccount();
		String actualText="Login";
		String expectedText=myaccountpage.getLoginText();
		Assert.assertEquals(actualText, expectedText);
		logger.info("verfiyLogoutToMyAccount............Pass");
	}
}
