package com.stackroute.seleniumPOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	WebDriver driver;
	
	WebElement txtUsername;
	WebElement txtPassword;
	WebElement btnLogin;
	WebElement spanMessage;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public DashboardPage validLogin(String username, String password) throws Exception
	{
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		
		return new DashboardPage(driver);
		
	}
	
	public String invalidLogin(String username, String password) throws Exception
	{

		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		
		return spanMessage.getText();
	}
	
	
	
	
}








