package com.PageObjectModel;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TiraBeauty {

	public static void main(String[] args) throws Exception {
		
		WebDriver w = new ChromeDriver();
		w.get("https://www.tirabeauty.com/");
		
		TiraBeautyPOMWithPageFactory repo = new TiraBeautyPOMWithPageFactory(w);
		repo.search("mens perfume");
		Thread.sleep(3000);
		repo.product("AJMAL Kuro Eau De Perfume (90ml)");
		String main = w.getWindowHandle();
		Set<String> mainAndChild = w.getWindowHandles();
		for (String mac : mainAndChild) {
			if (!mac.equals(main)) {
				w.switchTo().window(mac);
			}
		}
		Thread.sleep(3000);
		repo.addToBag();
		

	}

}
