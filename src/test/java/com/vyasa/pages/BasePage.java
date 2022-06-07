package com.vyasa.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

	WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver=driver;
	}
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	public void swichToAlert()
	{
		 driver.switchTo().alert();
	}
	
}
