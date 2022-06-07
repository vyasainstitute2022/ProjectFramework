package com.vyasa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountsPage extends BasePage{

public WebDriver driver;
	
	public MyAccountsPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//Page object repository  
	@FindBy(xpath="//*[@id='username']")
	private WebElement loginUsername;
	
	@FindBy(xpath="//*[@id='password']")
	private WebElement loginPassword;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement logonButton;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	

	@FindBy(xpath="//*[@id='customer_login']/div[1]/h2")
	private WebElement loginHeader;
	
	
	public void loginToMyAccount(String uname, String pass)
	{
		loginUsername.sendKeys(uname);
		loginPassword.sendKeys(pass);
		logonButton.click();
	}
	
	public void logoutFromMyAccount()
	{
		logoutLink.click();
	}
	
	public String getLoginText()
	{
		return loginHeader.getText();
	}
}
