package com.stackroute.selenium.cucumber;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef 
{
	
static WebDriver wd;
	
	@Before
	public static void init()
	{
		
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		
	}
	
	
	
	
  @Given("the user is on eBay home page")
  public void the_user_is_on_eBay_home_page() 
  {
	  wd.get("https://www.ebay.com/");
  }

  @When("the user enters a bookname")
  public void the_user_enters_a_booknamen() 
  {
	  wd.findElement(By.name("_nkw")).sendKeys("Da vinci code");
  }

  @Then("selects the book category")
  public void selects_the_book_category() 
  {
	  WebElement catdd = wd.findElement(By.name("_sacat"));
	  Select cat = new Select(catdd);
	  cat.selectByValue("267");
	  
  }

  @And("clicks the search button")
  public void clicks_the_search_button()  
  {
	  wd.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
	  
  }
  @Then("the basic search result should be displayed")
  public void the_basic_search_result_should_be_displayed() 
  {
	  WebElement resultLink = wd.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]"));
	  assertTrue(resultLink.isDisplayed());
	  
	  								//https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=Da+vinci+code&_sacat=267
	 // assertTrue(wd.getCurrentUrl().matches("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=da+vinci+code&_sacat=267"));
  }

  
  @When("the user moves to the advance search page")
  public void the_user_moves_to_the_advance_search_page()
  {
	  wd.findElement(By.xpath("//*[@id=\"gh-as-a\"]")).click();
  }
  
  @When("the user enters a search keyword")
  public void the_user_enters_a_search_keyword()
  {
	  wd.findElement(By.name("_nkw")).sendKeys("Dan Brown");
	  
  }
  
  @And("click the search icon")
  public void click_the_search_icon()
  {
	  wd.findElement(By.xpath("//*[@id=\"adv_search_from\"]/fieldset[1]/div[3]/button")).click();
	  
	  
  }
  @Then("the advance search result should be displayed")
  public void the_advance_search_result_should_be_displayed()
  {
	WebElement partialLink=  wd.findElement(By.partialLinkText("Origin by"));
	  assertTrue(partialLink.isDisplayed());
  }
}
















