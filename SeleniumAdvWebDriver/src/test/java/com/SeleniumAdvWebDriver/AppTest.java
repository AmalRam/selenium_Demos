package com.SeleniumAdvWebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest
{
	static WebDriver wd;
	
	 @BeforeClass
	 public static void initDriver()
	 {
		 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 wd = new ChromeDriver();
		 wd.manage().window().maximize();
	 }
	 
	 @Test
	 public void googleTest01()
	 {
		 wd.navigate().to("https://www.google.com/");
		 wd.findElement(By.linkText("Images")).click();
		 wd.findElement(By.className("gLFyf")).sendKeys("Selenium");
		 wd.findElement(By.xpath("//*[@id=\"sbtc\"]/button")).click();
	 }
	
	 @Test
	 public void googleTest02() throws IOException
	 {
		 
		 String imagePath = System.getProperty("user.dir")+"/screenshots/image1.png";
		 
		 File searchscreen = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		 
		 FileUtils.copyFile(searchscreen, new File(imagePath));
		 
		 WebElement img = wd.findElement(By.xpath("//*[@id=\"i6\"]/div[1]/span/span/div[3]"));
		 
		 String imagePath2 = System.getProperty("user.dir")+"/screenshots/image2.png";
		 
		 File searchscreen2 = img.getScreenshotAs(OutputType.FILE);
		 
		 FileUtils.copyFile(searchscreen2, new File(imagePath2));
		 
		 
		 
		 
	 }
	 
	
}












