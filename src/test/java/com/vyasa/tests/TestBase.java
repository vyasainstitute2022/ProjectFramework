package com.vyasa.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vyasa.utils.ScreenShot;

public class TestBase {
	
	public static WebDriver driver;
	public 	static Properties prop;
	public  static ExtentHtmlReporter htmlreporter;
	public  static ExtentReports extent;
	public  static ExtentTest test;
	public 	static Logger logger;

	public TestBase(){
	
		//proprties file reading
		try{
		prop=new Properties();//1
		FileInputStream ip=new FileInputStream(".\\src\\test\\resources\\config.properties");//2
		prop.load(ip);//3
	}catch(FileNotFoundException e)
	{
	e.printStackTrace();	
	}catch(IOException e)
	{
	e.printStackTrace();	
	}
	//log file setup
	logger=Logger.getLogger(TestBase.class);  //1
	PropertyConfigurator.configure(".\\src\\test\\resources\\log4j.properties");//2
	//it is for configuring the log4j setup to our app
	}
	
	@BeforeSuite
	public void initDriver(){
		String browsername=prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{	
			System.setProperty("webdriver.firefox.marionette",prop.getProperty("firefoxexepath")); 
			driver=new FirefoxDriver();
			logger.info("firefox browser opened");
			}else if(browsername.equals("chrome")) 
		  {	
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeexepath")); 
			driver=new ChromeDriver();
			logger.debug("Chrome driver binary successfully set");
			logger.info("chrome browser opened");
	 	 }
	  	 driver.manage().window().maximize();
	  	 driver.manage().deleteAllCookies();
	  	 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	  	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	}

	@BeforeTest
	public void setupExtentEnv()
	{
		
		htmlreporter =new ExtentHtmlReporter(".\\extentreport\\extent-report.html");
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("functional report");
		htmlreporter.config().setTheme(Theme.STANDARD);
			extent=new ExtentReports();
			extent.attachReporter(htmlreporter);
			extent.setSystemInfo("HOST NAME", "LOCALHOST");
			extent.setSystemInfo("OS", "WINDOWS 10");
			extent.setSystemInfo("Tester NAME", "Mahadev");
			extent.setSystemInfo("Browser", "Chrome");
			logger.info("extent report set");
	}
	
	@BeforeMethod
	public void register(Method method) {
		String testname=method.getName();
			test=extent.createTest(testname);
			
		}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL, "TEST CASE FAILED is"+result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED is"+result.getThrowable());
		String screenshotpath=ScreenShot.getScreenshot(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
	}else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP, "TEST CASE SkIPPED:"+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, "TEST CASE PASSED:"+result.getName());
	}
	}

	@AfterTest
	public void cleanup()
	{
		extent.flush();
	}
	
	@AfterSuite
	public void browserTeardown()
	{
		driver.quit();
	}
}
