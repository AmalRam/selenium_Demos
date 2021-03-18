package com.SeleniumWebElementsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HoverMouseDemo {

	public static void main(String[] args) 
	{
		
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        
        WebDriver wd = new ChromeDriver();// new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        
        String url = "http://the-internet.herokuapp.com/";
        wd.get(url);
        
        
        WebElement hoverObj = wd.findElement(By.xpath("/html/body/div[2]/div/ul/li[25]/a"));
        hoverObj.click();
        
        Actions builder = new Actions(wd);
        WebElement img1 = wd.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"));
        
        Action mouseOver = builder.moveToElement(img1).build();
        mouseOver.perform();
        
	}

}










