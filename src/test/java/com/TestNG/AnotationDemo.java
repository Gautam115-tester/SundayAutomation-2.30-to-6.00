package com.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class AnotationDemo {
	@BeforeSuite
	public void bs() {
		System.out.println("This method belong to bs");
	}
	@BeforeTest
	public void bt() {
		System.out.println("This method belong to bt");
	}
	@BeforeClass
	public void bc() {
		System.out.println("This method belong to bc");
	}
	@BeforeMethod
	public void bm() {
		System.out.println("This method belong to bm");
	}
	@Test
	public void cond3() {
		System.out.println("This is third test condition");
	}
	
	@Test
	public void cond2() {
		System.out.println("This is second test condition");
	}
	
	@Test
	public void cond1() {
		System.out.println("This is first test condition");
	}
	@AfterMethod
	public void am() {
		System.out.println("This method belong to am");
	}
	@AfterClass
	public void ac() {
		System.out.println("This method belong to ac");
	}
	@AfterTest
	public void at() {
		System.out.println("This method belong to at");
	}
	@AfterSuite
	public void as() {
		System.out.println("This method belong to as");
	}
	
	

}
