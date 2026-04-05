package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartAddTocart {

	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		w.get("https://www.flipkart.com/");
		FlipkartSearchPOMWithoutPageFactory repo = new FlipkartSearchPOMWithoutPageFactory(w);
		repo.SearchByIcon("Mobile");
		repo.SelectFirstProductOnly();
		repo.SwitchToEmbeddWindow();
		Thread.sleep(2000);
		repo.AddToCart();
//		w.quit();

	}

}
