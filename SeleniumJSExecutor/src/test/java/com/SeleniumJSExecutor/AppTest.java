package com.SeleniumJSExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class AppTest 
    
{
	static WebDriver wd;
	
	 @Test
	 public static void initDriver()
	 {
		 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 wd = new ChromeDriver();
		 wd.manage().window().maximize();
		 wd.get("http://google.com");
		 
		 JavascriptExecutor jse = (JavascriptExecutor)wd;
		 jse.executeScript("alert('JS Executor running successfully')");
	 }
	 
}
