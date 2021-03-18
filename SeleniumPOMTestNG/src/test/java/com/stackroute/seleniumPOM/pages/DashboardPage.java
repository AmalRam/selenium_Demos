package com.stackroute.seleniumPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage
{
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) 
	{
		
		this.driver = driver;
		
	//	welcomeUser = driver.findElement(By.partialLinkText("Welcome"));
		
	}
	
	@FindBy(partialLinkText="Welcome")
	WebElement welcomeUser;
	
	@FindBy(partialLinkText="Logout")
	WebElement logoutUser;

	

	public String getWelcomeMessage()
	{
		return welcomeUser.getText();
	}

	
	public LoginPage logoutSuccess() throws Exception
	{
		welcomeUser.click();
		Thread.sleep(3000);
		logoutUser.click();
		Thread.sleep(3000);
		return new LoginPage(driver);
		
	}
	

}











