package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	@Test (priority = 2,invocationCount = 10,enabled = false) // test condition
	public void flipkart() {
		WebDriver w = new ChromeDriver();
		w.get("https://www.flipkart.com/");
	}
	
	@Test (priority = 1)
	public void snapdeal() {
		WebDriver w = new ChromeDriver();
		w.get("https://www.snapdeal.com/");
	}
	

	

}
