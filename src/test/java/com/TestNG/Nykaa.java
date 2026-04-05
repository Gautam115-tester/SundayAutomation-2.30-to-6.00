package com.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Nykaa {
	ThreadLocal<WebDriver> w;
	
	@Parameters("bs")
	@BeforeMethod
	public void launchAnBrowser(String browser) throws Exception {
		
		if (browser.equals("chrome")) {
			w = new ThreadLocal<>();
			w.set(new ChromeDriver());
		}else if (browser.equals("firefox")) {
			w = new ThreadLocal<>();
			w.set(new FirefoxDriver());
		}else if (browser.equals("edge")) {
			w = new ThreadLocal<>();
			w.set(new EdgeDriver());
		}
		Thread.sleep(2000);
		w.get().get("https://www.nykaa.com/");
	}
	@Test
	public void search() throws Exception {
	
		w.get().findElement(By.name("search-suggestions-nykaa")).sendKeys("shoes",Keys.ENTER);
		Thread.sleep(2000);
		AssertJUnit.assertEquals(w.get().getCurrentUrl(), 
			"https://www.nykaa.com/search/result/?q=shoes&root=search&searchType=Manual&sourcepage=home");
	}
	@Test
	public void category() throws Exception {
		Thread.sleep(2000);
		w.get().findElement(By.xpath("//*[@id=\"my-menu\"]/ul/li[9]/a")).click();
		String main = w.get().getWindowHandle();
		Set<String> multi = w.get().getWindowHandles();
		for (String m : multi) {
			if (!m.equals(main)) {
				w.get().switchTo().window(m);
			}
		}
		SoftAssert soft = new SoftAssert();
		Thread.sleep(2000);
		AssertJUnit.assertEquals(w.get().getTitle(), "Men's Store");
		w.get().close();
		w.get().switchTo().window(main);
		soft.assertAll();
	}
	@Test
	public void bag() throws Exception {
		w.get().findElement(By.tagName("html")).sendKeys(Keys.CONTROL,Keys.SUBTRACT);
		Thread.sleep(2000);
	WebElement bag =	w.get().findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/div[2]/div[2]/button"));
//	JavascriptExecutor js = (JavascriptExecutor) w;
//	js.executeScript("document.body.style.zoom = '80%';");
	Robot r = new Robot();
	for(int i = 1; i <= 2;i++) {
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_SUBTRACT);
	r.keyRelease(KeyEvent.VK_SUBTRACT);
	r.keyRelease(KeyEvent.VK_CONTROL);
	}
	bag.click();
		Thread.sleep(2000);
		AssertJUnit.assertEquals( w.get().findElement(By.cssSelector("span[data-test-id=\"header-title\"]")).getText(), "Bag");
	}
	@AfterMethod
	public void closeBrowser() {
		w.get().quit();
	}
	
	
	
	
	

}
