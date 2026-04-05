package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Ebay {
//	WebDriver w;
	
	RemoteWebDriver w;
	
	
	@BeforeMethod
	public void launchAndNavigateToEbaySite() throws Exception {
//		w = new ChromeDriver();
		DesiredCapabilities dc = new DesiredCapabilities();
				dc.setPlatform(Platform.LINUX);
		dc.setBrowserName("chrome");
		 w = new RemoteWebDriver(dc);
		Thread.sleep(2000);
		w.get("https://www.ebay.com/");
	}
	@Test(dataProviderClass = DataForTesting.class,dataProvider = "ebay gautam wishlist")
	public void searchAnProduct(String search,String expectedTitle) throws Exception {
		Thread.sleep(2000);
		w.findElement(By.id("gh-ac")).sendKeys(search,Keys.ENTER);
		Thread.sleep(2000);
		Assert.assertEquals(w.getTitle(), expectedTitle);	
	}
	@AfterMethod
	public void closeAnBrowser() throws Exception {
		Thread.sleep(2000);
		w.quit();
	}
}
