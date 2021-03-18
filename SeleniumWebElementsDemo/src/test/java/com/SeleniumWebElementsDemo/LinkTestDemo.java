package com.SeleniumWebElementsDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTestDemo {

	public static void main(String[] args) {

		
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        
        WebDriver wd = new ChromeDriver();// new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        
        String url = "http://the-internet.herokuapp.com/";
        wd.get(url);
        
        List<WebElement> linkElements = wd.findElements(By.tagName("a"));
        
        List<String> linkText = new ArrayList<String>();
        
        for(WebElement e : linkElements)
        {
        	if(e.getText().isEmpty())
        	{
        		continue;
        	}
        	linkText.add(e.getText());
        		
        }
        
        System.out.println(linkText);
        
        for(String link :linkText)
        {
        	wd.findElement(By.linkText(link)).click();
        	System.out.println(wd.getCurrentUrl());
        	wd.navigate().back();
        }

	}

}
