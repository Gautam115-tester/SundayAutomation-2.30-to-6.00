package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSearch {

	public static void main(String[] args) throws Exception {
		
		WebDriver w = new ChromeDriver();
         FlipkartSearchPOMWithoutPageFactory repo  = new FlipkartSearchPOMWithoutPageFactory(w);
         
         w.get("https://www.flipkart.com/");
         repo.SearchByEnter("Ac");
//         repo.SelectFirstProductOnly();
         
         repo.SelectSpecificProduct("Voltas 2023 Model 1 Ton 3 Star Window AC");
         repo.SwitchToEmbeddWindow();
         Thread.sleep(2000);
         repo.AddToCart();
         Thread.sleep(2000);
         w.quit();
         
	}

}
