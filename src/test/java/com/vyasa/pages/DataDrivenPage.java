package com.vyasa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDrivenPage extends BasePage {
	
	public WebDriver driver;
	
	public DataDrivenPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page object repository  
	@FindBy(xpath="//*[@id='userName']")   
	private WebElement weUserName; 

	@FindBy(xpath="//*[@id='usrPwd']")   
	private WebElement weUserPass; 
	
	@FindBy(xpath="//*[@id='cnfUsrPwd']")   
	private WebElement weConfirmPass; 
	
	@FindBy(xpath="//*[@id='ui-tabpanel-0']/div/div[5]/p-dropdown/div")
	private WebElement wePreLang;
	
	@FindBy(xpath="//*[@id='ui-tabpanel-0']/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li/span")
	private WebElement weEngLang; 
	
	@FindBy(xpath="//*[@id='ui-tabpanel-0']/div/div[6]/p-dropdown/div")
	private WebElement weSecAns; 
	
	@FindBy(xpath="//*[@id='ui-tabpanel-0']/div/div[6]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li/span")
	private WebElement weSecAnsSel; 
	
	@FindBy(xpath="//*[@id='ui-tabpanel-0']/div/div[7]/input")
	private WebElement weSecAnsin; 
	
	public void formValidation(String uname,String pass,String conpass, String secansin){
	
		weUserName.clear();
		weUserName.sendKeys(uname);
		
		weUserPass.clear();
		weUserPass.sendKeys(pass);
		
		weConfirmPass.clear();
		weConfirmPass.sendKeys(conpass);
		
		wePreLang.click();
		weEngLang.click();
		weSecAns.click();
		weSecAnsSel.click();
		
		weSecAnsin.clear();
		weSecAnsin.sendKeys(secansin);
	}
}
