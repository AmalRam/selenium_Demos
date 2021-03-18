package com.SeleniumWebElementsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MenuTest {

	public static void main(String[] args) 
	{
		
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        
        WebDriver wd = new ChromeDriver();// new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        
        String url = "https://opensource-demo.orangehrmlive.com/";
        wd.get(url);
        
        WebElement username;
		WebElement password;
		WebElement btnlogin;
		
		username = wd.findElement(By.id("txtUsername"));
		
		username.sendKeys("Admin");
		
		password = wd.findElement(By.name("txtPassword"));
		
		password.sendKeys("admin123");
		
		
		btnlogin = wd.findElement(By.id("btnLogin"));
		btnlogin.submit();
		
		
		wd.findElement(By.id("mainMenuFirstLevelUnorderedList")).click();
		wd.findElement(By.id("menu_admin_viewAdminModule")).click();
		wd.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/a")).click();
		wd.findElement(By.xpath("//*[@id=\"menu_admin_viewJobTitleList\"]")).click();
	}

}
