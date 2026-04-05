package com.StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flipkart {
	 
	
	@Given("launch an chrome browser")
	public void launch_an_chrome_browser() {
	   Driver.w =  new ChromeDriver();
	   Driver.w.manage().window().maximize();
	}
	@Given("Navigate to flipkart site")
	public void navigate_to_flipkart_site() {
	  Driver.w.get("https://www.flipkart.com");
	}
	@When("Enter {string} in search module in homepage")
	public void enter_in_search_module_in_homepage(String Search) throws Exception {
		Thread.sleep(2000);
	 Driver.w.findElement(By.name("q")).sendKeys(Search , Keys.ENTER);
	}
	@When("validate mobile page has been open by pagetitle and the title is {string}.")
	public void validate_mobile_page_has_been_open_by_page_title(String expectTitle) throws Exception {
		Thread.sleep(2000);
	  Assert.assertEquals(Driver.w.getTitle(), expectTitle );
	}
	@Then("close an chrome browser")
	public void close_an_chrome_browser() throws Exception {
		Thread.sleep(2000);
	  Driver.w.quit();
	}
	
	


}
