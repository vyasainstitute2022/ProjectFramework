package com.vyasa.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vyasa.pages.DataDrivenPage;
import com.vyasa.utils.DataFromXls;

public class DataDrivenTest extends TestBase{
	
	public static WebElement weUserName,weUserPass,weConfirmPass,wePreLang,weEngLang,weSecAns,weSecAnsSel,weSecAnsin;
	
	com.vyasa.pages.DataDrivenPage datadrivenpage;
	public DataDrivenTest(){
		super();
	}
	
	@BeforeClass
	public void openBrowser()
	{
		datadrivenpage=new DataDrivenPage(driver);
		driver.navigate().to("https://www.irctc.co.in/nget/profile/user-registration");
		WebElement okButton=driver.findElement(By.xpath("//button[text()='OK']"));
		if(okButton.isDisplayed()) {
			okButton.click();
		}
	}
	
	@Test(dataProvider="login-data" )
	public void loginform(String tcid,String tcdesc,String Uname,String pass,String conpass,String secansin)
	{
		System.out.println("Test Case id:"+tcid);
		System.out.println("Test Case desc:"+tcdesc);
		datadrivenpage.formValidation(Uname,pass,conpass,secansin);
		
	}
	
	@DataProvider(name="login-data")
	public Object[][] loginData() throws Exception, InvalidFormatException
	{   
		Object[][] testdata= DataFromXls.getDataFromXls("testdataprovider");
		return testdata;
	}
	
}
