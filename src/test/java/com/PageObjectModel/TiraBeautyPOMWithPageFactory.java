package com.PageObjectModel;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TiraBeautyPOMWithPageFactory {
	public TiraBeautyPOMWithPageFactory(WebDriver w) {
		PageFactory.initElements(w, this);
	}
	@FindBy(id = "search")
	private WebElement search;
	
	@FindBy(css = "h3[class=\"productName--Ys8wX\"]")
	private List<WebElement> products;
	
	@FindBy(xpath = "//*[@class=\"bagBtnMain--WvS4H\"]/button")
	private WebElement addToBag;
	
	public void search(String search) {
		this.search.sendKeys(search,Keys.ENTER);
	}
	public void product(String productName) {
		for (WebElement product : products) {
			if (product.getText().contains(productName)) {
				product.click();
				break;
			}
		}
	}
	public void addToBag() {
		addToBag.click();
	}
	

}
