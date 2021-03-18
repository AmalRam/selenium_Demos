package com.stackroute.seleniumPOM.TestPages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stackroute.seleniumPOM.pages.DashboardPage;
import com.stackroute.seleniumPOM.pages.LoginPage;

public class DashboardPageTest
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
		public void logoutTest() throws Exception
		{
			loginPage = new LoginPage(wd);
			
			PageFactory.initElements(wd, loginPage);
			DashboardPage dbPage = loginPage.validLogin("Admin", "admin123");
			
			PageFactory.initElements(wd, dbPage);
			loginPage = dbPage.logoutSuccess();
			
			assertTrue(wd.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/auth/login"));
			
			
			
		}
}












