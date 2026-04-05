package com.KeywordDrivenFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RepoOfDisha {
	public RepoOfDisha(WebDriver w) {
		PageFactory.initElements(w, this);
	}
//	Suvarna
	@FindBy(id = "userName")
 private	WebElement username;
	@FindBy(id = "password")
 private	WebElement password;
	@FindBy(css = "input[type=\"checkbox\"]")
	private WebElement keepMeSignInCheckBox;
	@FindBy(id = "SignIn")
	private WebElement signin;
	@FindBy(css = "a[data-toggle=\"tooltip\"]")
	private WebElement menu;
	@FindBy(linkText = "Registration")
	private WebElement registration;
	@FindBy(id = "prefix")
	private WebElement prefix;
	@FindBy(id = "fName")
	private WebElement firstName;
	@FindBy(id = "lName")
	private WebElement lastName;
	@FindBy(css = "input[id=\"b2c\"]")
	private WebElement btoc;
	@FindBy(xpath = "//*[@id=\"s2id_patientTypeList\"]/a")
	private WebElement patientType;
	public void username() {
		username.sendKeys("Suvarna");
	}
	public void password() {
		password.sendKeys("Suvarna@123");
	}
	public void keepMeSignIn() {
		keepMeSignInCheckBox.click();
	}
	public void Login() {
		signin.click();
	}
	 public void menu() {
		 menu.click();
	 }
	 public void registration() {
		 registration.click();
	 }
	 public void prefix() {
		Select s1 = new Select(prefix);
		s1.selectByVisibleText("MS.");
	 }
	 public void firstName() {
		 firstName.sendKeys("Akash");
	 }
	 public void lastName() {
		 lastName.sendKeys("Mane");
	 }
	 public void BTOC() {
		 btoc.click();
	 }
	
	

}
