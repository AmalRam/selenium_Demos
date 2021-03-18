package com.stackroute.seleniumPOM.TestPages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stackroute.seleniumPOM.pages.DashboardPage;
import com.stackroute.seleniumPOM.pages.LoginPage;

public class LoginPageTest 
{
static WebDriver wd;
 
LoginPage loginPage= null;
	
	@BeforeClass
	public static void init()
	{
		
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		wd = new ChromeDriver();
		
		wd.manage().window().maximize();
		wd.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
	@Test
	public void validLoginTest() throws Exception
	{
		loginPage = new LoginPage(wd);
		
		PageFactory.initElements(wd, loginPage);
		
		DashboardPage dbPage = loginPage.validLogin("Admin", "admin123");
		
		PageFactory.initElements(wd, dbPage);
		
		boolean loginstatus = dbPage.getWelcomeMessage().contains("Welcome");
		assertTrue(loginstatus);
		
		
	}
	
	@Test
	public void InvalidLoginTest() throws Exception
	{
		loginPage = new LoginPage(wd);
		
		PageFactory.initElements(wd, loginPage);
		
		String errmsg = loginPage.invalidLogin("Dwight", "admin123");
		
		
		
		
		assertTrue(errmsg.contentEquals("Invalid credentials"));
		
		
	}


}










