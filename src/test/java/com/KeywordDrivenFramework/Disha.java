package com.KeywordDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Disha {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/Disha.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1; i <= 4;i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell testStep = row.getCell(3);
			String[] testSteps = testStep.toString().split("[0-9]");
			WebDriver w = null;
			RepoOfDisha r = null;
			for (String ts : testSteps) {
				if ("Launch chrome browser".equalsIgnoreCase(ts.trim())) {
					w = new ChromeDriver();
					r = new RepoOfDisha(w);
				}else if ("navigate to url".equalsIgnoreCase(ts.trim())) {
					w.get("http://103.251.94.38:8080/MIDMS/index.jsp");
				}else if ("Enter username".equalsIgnoreCase(ts.trim())) {
					r.username();
				}else if ("Enter Password".equalsIgnoreCase(ts.trim())) {
					r.password();
				}else if ("Enter capcha".equalsIgnoreCase(ts.trim())) {
					Thread.sleep(10000);
				}else if ("click on keep me sign in checkbox".equalsIgnoreCase(ts.trim())) {
					r.keepMeSignIn();
				}else if ("click on login button".equalsIgnoreCase(ts.trim())) {
					r.Login();
				}else if ("Click on menu".equalsIgnoreCase(ts.trim())) {
					r.menu();
					Thread.sleep(2000);
				}else if ("click on Registration".equalsIgnoreCase(ts.trim())) {
					r.registration();
					Thread.sleep(2000);
				}else if ("Select an Prefix".equalsIgnoreCase(ts.trim())) {
					r.prefix();
					Thread.sleep(2000);
				}else if ("Enter FirstName".equalsIgnoreCase(ts.trim())) {
					r.firstName();
					Thread.sleep(2000);
				}else if ("Enter LastName".equalsIgnoreCase(ts.trim())) {
					r.lastName();
					Thread.sleep(2000);
				}else if ("Select B To C".equalsIgnoreCase(ts.trim())) {
					r.BTOC();
					Thread.sleep(2000);
				}else if ("close browser".equalsIgnoreCase(ts.trim())) {
					Thread.sleep(2000);
					w.quit();
				}
			}
			
			
		}
		
		
		
		
		

	}

}
