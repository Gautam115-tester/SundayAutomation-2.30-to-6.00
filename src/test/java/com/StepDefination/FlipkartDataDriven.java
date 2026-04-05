package com.StepDefination;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.cucumber.java.en.When;

public class FlipkartDataDriven {

	String main;
	String child;
	
	
	@When("Search {string} in search text box")
	public void search_in_search_text_box(String search) throws Exception {
		Thread.sleep(2000);
	   Driver.w.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
	}
	@When("Click on add to card")
	public void click_on_add_to_card() throws Exception {
		
		main = Driver.w.getWindowHandle();
		Set<String> mainAndChild = Driver.w.getWindowHandles();
		for (String cm : mainAndChild) {
			if (!cm.equals(main)) {
				Driver.w.switchTo().window(cm);
				child = cm;
				Thread.sleep(2000);
			}
		}
		Driver.w.navigate().refresh();
		Thread.sleep(2000);
	  Driver.w.findElement(By.xpath("//*[@class=\"_1psv1zeb9 _1psv1ze0 _7dzyg20 _1psv1ze9l _1psv1ze7o _1psv1ze2u _1psv1ze53\"]/div[1]")).click();
	}
	@When("Click on cart logo")
	public void click_on_cart_logo() throws Exception {
		Thread.sleep(2000);
	  Driver.w.findElement(By.cssSelector("a[title=\"Cart\"]")).click();
	}
	@When("Check {string} product name has been added")
	public void check_product_name_has_been_added(String expectedProduct) throws Exception {
		Thread.sleep(2000);
	String product =   Driver.w.findElement(By.xpath("//*[@class=\"css-146c3p1 r-dnmrzs r-1udh08x r-1udbk01 r-3s2u2q r-1iln25a r-cqee49 r-1et8rh5 r-ubezar\"]"))
			.getText();
	   Assert.assertEquals(product.contains(expectedProduct), true);
	}
}
