package com.vyasa.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot{
	
	public ScreenShot() throws IOException {
		super();
	}
	
	public static String getScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/screenshots/"+name+System.currentTimeMillis()+".png";
		File finaldestination=new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
	}
}	

