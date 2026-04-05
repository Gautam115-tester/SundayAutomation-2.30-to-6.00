package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FoodMandu {

	public static void main(String[] args) {
		
		WebDriver w = new FirefoxDriver();
		w.get("https://foodmandu.com/");
		
		FoodManduPOMWithPageFactory repo = new FoodManduPOMWithPageFactory(w);
		repo.login();
		
		repo.sendEmail("xyz@gmail.com");
		repo.sendPassword("1234567890");
		repo.loginbtn();
		
		
		
		
		
		
		
		
		
		

	}

}
