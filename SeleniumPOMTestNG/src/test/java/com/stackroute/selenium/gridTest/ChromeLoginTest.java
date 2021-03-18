package com.stackroute.selenium.gridTest;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ChromeLoginTest 
{
	static WebDriver driver;
	
	@BeforeClass
	public static void initDriver() throws Exception
	{
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		ChromeOptions cap = new ChromeOptions();
		cap.merge(dc);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
	@Test
	public  void verifyLogin()
	{
		System.out.println("In verify test case method");
		
		WebElement username;
		WebElement password;
		WebElement btnlogin;
		
		username = driver.findElement(By.id("txtUsername"));
		
		username.sendKeys("Admin");
		
		password = driver.findElement(By.name("txtPassword"));
		
		password.sendKeys("admin123");
		
		
		btnlogin = driver.findElement(By.id("btnLogin"));
		btnlogin.submit();
		
		//assertTrue(driver.getTitle().equals("OrangeHRM"));
		
	}
	
	
	
	

}
