package com.SeleniumTestIntro;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest
{
	static WebDriver wd;
	
	@BeforeClass
	public static void init()
	{
		
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		wd = new ChromeDriver();
		
		wd.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public static String verifyLogin()
	{
		System.out.println("In verify test case method");
		
		WebElement username;
		WebElement password;
		WebElement btnlogin;
		
		username = wd.findElement(By.id("txtUsername"));
		
		username.sendKeys("Admin");
		
		password = wd.findElement(By.name("txtPassword"));
		
		password.sendKeys("admin123");
		
		
		btnlogin = wd.findElement(By.id("btnLogin"));
		btnlogin.submit();
		
		return "admin";
		
	}
	
	@Test
	public void verifyLoginTest()
	{
		String userTest = "admin";
		
		assertEquals(userTest,AppTest.verifyLogin());
		wd.quit();
	}
	
	
}




