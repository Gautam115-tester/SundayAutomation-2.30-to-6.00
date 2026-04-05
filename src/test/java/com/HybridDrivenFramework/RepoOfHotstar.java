package com.HybridDrivenFramework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepoOfHotstar {
	WebDriver w;
	public RepoOfHotstar(WebDriver w) {
		PageFactory.initElements(w, this);
		this.w = w;
	}
	@FindBy(xpath = 
	"//*[@class=\"_3O2khXNePOp8a3Gd1EocHu absolute h-full flex items-center ELEVATION_5\"]/nav/div[2]/a/button")
    private WebElement searchicon;
	@FindBy(id = "searchBar")
	private WebElement searchTextBox;
	@FindBy(xpath = "//*[@data-testid=\"input-clear-option\"]/i")
	private WebElement crossIconInSearchTextBox;
	@FindBy(xpath = 
	"//*[@class=\"_3O2khXNePOp8a3Gd1EocHu absolute h-full flex items-center ELEVATION_5\"]/nav/div[8]/a/button")
	private WebElement myspaceIcon;
	@FindBy(xpath = "//*[@data-testid=\"action\"]/button")
	private WebElement loginbtn;
	@FindBy(css = "input[title=\"Mobile number\"]")
	private WebElement mobileNumberField;
	@FindBy(css = "button[data-testid=\"signup-form-submit-button\"]")
	private WebElement getOTP;
	
	public void searchIcon() {
		searchicon.click();
	}
	public void searchTextBox(String search) {
		searchTextBox.sendKeys(search);
	}
	public void SearchCrossIcon() {
		crossIconInSearchTextBox.click();
	}
	 public void myspace() {
		 myspaceIcon.click();
	 }
	 public void loginbtn() {
		 loginbtn.sendKeys(Keys.ENTER);
	 }
	 public void mobileNumberField(String mobileNumber) {
		 this.mobileNumberField.sendKeys(mobileNumber);
	 }
	 public void getOTP() {
		 getOTP.click();
	 }
	
	
	
	

}
