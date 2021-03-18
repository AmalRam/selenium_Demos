package com.SeleniumWebElementsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTestDemo {

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        
        WebDriver wd = new ChromeDriver();// new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        
        String url = "http://the-internet.herokuapp.com/";
        wd.get(url);
        
        WebElement drop = wd.findElement(By.xpath("/html/body/div[2]/div/ul/li[11]/a"));
        drop.click();
        
        
        Select options = new Select (wd.findElement(By.id("dropdown")));
        options.selectByValue("2");
        Thread.sleep(3000);
        
        

	}

}
