package com.SeleniumApachePOI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
    
    
    @DataProvider(name="testData")
    public Object[][] TestDataFeed()
    {
    	ReadExcelFile config = new ReadExcelFile("E:\\ust wave 27\\Module 2\\SeleniumAllDemos\\OrangeHRMLoginCredentials.xlsx");
    	int rows = config.getRowCount(0);
    	
    	Object[][] credentials = new Object[rows][2];
    	for(int i=0; i<rows;i++)
    	{
    		credentials[i][0]= config.getData(0, i, 0);
    		credentials[i][1]= config.getData(0, i, 1);
    		
    	}
    	return credentials;
    }
    
    
    
    @Test(dataProvider="testData")
    public void verifyLoginTest01(String userid, String pass)
    {
    	System.out.println("In verify test case method");
    	WebElement username;
		WebElement password;
		WebElement btnlogin;
		
		username = wd.findElement(By.id("txtUsername"));
		
		username.sendKeys(userid);
		
		password = wd.findElement(By.name("txtPassword"));
		
		password.sendKeys(pass);
		
		
		btnlogin = wd.findElement(By.id("btnLogin"));
		btnlogin.submit();
		
		Assert.assertTrue(wd.getTitle().matches("OrangeHRM"));
		Assert.assertTrue(wd.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
