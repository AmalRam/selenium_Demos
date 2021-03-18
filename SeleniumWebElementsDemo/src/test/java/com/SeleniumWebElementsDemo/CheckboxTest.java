package com.SeleniumWebElementsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest {

	//The locators used to access web paage HTML elements
	//1. By.id, 2. By.name, 3. By.XPath
	public static void main(String[] args) 
	{
		
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        
        WebDriver wd = new ChromeDriver();// new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        
        String url = "http://the-internet.herokuapp.com/";
        wd.get(url);
        
        WebElement chkboxLink = wd.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a"));
        chkboxLink.click();
        
        WebElement chkbox = wd.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
        chkbox.click();
        
      
        
        if(chkbox!=null)
        {
        	
        	System.out.println(chkbox.getTagName());
        }
        wd.quit();
        
        
	}

}
