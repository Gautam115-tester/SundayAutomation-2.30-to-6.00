package com.PageObjectModel;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class FlipkartSearchPOMWithoutPageFactory {
	private WebDriver w;   // Global variable
//	without --> locator from set of action
	public FlipkartSearchPOMWithoutPageFactory(WebDriver wd /* local variable*/) {    // constructor
		w = wd;
	}
//	element
	// search --> locator --> var --> search
	private By search = By.name("q");   // global variable
	private By searchIcon = By.cssSelector("button[type=\"submit\"]");
	private By product = By.className("k7wcnx");
	private By prevOrnext = By.cssSelector("a[class=\"jgg0SZ\"]");
	private By AddToCart = By.cssSelector("button[class=\"dSM5Ub ugg2XR IUmgrZ\"]");
//	Set of actions
	public void Search(String search /*local variable*/) {
		w.findElement(this.search).sendKeys(search);
	}
	public void SearchByEnter(String search) {
		w.findElement(this.search).sendKeys(search, Keys.ENTER);
	}
	public void SearchByIcon(String search) {
		w.findElement(this.search).sendKeys(search);
		w.findElement(searchIcon).click();
	}
	public void SelectFirstProductOnly() {
		w.findElement(product).click();
	}
	public void SelectSpecificProduct(String productName) throws Exception {
		while (true) {
			Thread.sleep(1000);
			List<WebElement> products	= w.findElements(product);
			for (WebElement product : products) {
				if (product.getText().toString().contains(productName)) {
					product.click();
					return;
				}
			}
			List<WebElement> pn = w.findElements(prevOrnext);
			for (WebElement n : pn) {
				if (n.getText().toString().equalsIgnoreCase("next")) {
					Actions act = new Actions(w);
					act.moveToElement(n).click().perform();
				}
			}		
		}	
	}
	private String main;
	public void SwitchToEmbeddWindow() {
		String mainWindow = w.getWindowHandle();
		main = mainWindow;
		Set<String> childWindow = w.getWindowHandles();
		for (String c : childWindow) {
			if (!c.equals(mainWindow)) {
				w.switchTo().window(c);
			}
		}
	}
	
	public void switchToMainWindow() {
		w.switchTo().window(main);
	}
	
	public void AddToCart() {
		w.findElement(AddToCart).click();
	}
	
	
	

}
