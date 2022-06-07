package com.vyasa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page object repository  
	@FindBy(xpath="//*[@id='text-22-sub_row_1-0-1-1-0']/h2")   
	private WebElement arrivalElement; 

	
	@FindBy(xpath="//h3[text()='Selenium Ruby']")
	private WebElement firstbookTitleEle;                      
	
	@FindBy(xpath="//h3[text()='Thinking in HTML']")
	private WebElement secondbookTitleEle;
	
	@FindBy(xpath="//h3[text()='Mastering JavaScript']")
	private WebElement thridbookTitleEle;
	
	
	//Page action methods
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean arrivalsisDisplayed()
	{
		return arrivalElement.isDisplayed();
	}
	
	public String getFirstBookTitle()
	{
		return firstbookTitleEle.getText();
	}
	
	public String getSecondBookTitle()
	{
		return secondbookTitleEle.getText();
	}
	
	public String getThirdBookTitle()
	{
		return thridbookTitleEle.getText();
	}
	
}
