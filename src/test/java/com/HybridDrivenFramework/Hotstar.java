package com.HybridDrivenFramework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Hotstar {
	public static void main(String[] args) throws Exception {
		FileInputStream fis  = new FileInputStream("./src/test/resources/hotstar.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1; i <= 7; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell testDatas = row.getCell(2);
			DataFormatter dt = new DataFormatter();
			String str = dt.formatCellValue(testDatas);
			WebDriver w = null;
			RepoOfHotstar r = null;
			String testdata[] = str.split(",");
			int j = 0;
			do {
				XSSFCell teststeps = row.getCell(1);
				String teststep[] = teststeps.toString().split("[0-9]");
				for (String step : teststep) {
					System.out.println(step);
					if (step.trim().equalsIgnoreCase("launch an chrome browser")) {
						w = new ChromeDriver();
						r = new RepoOfHotstar(w);
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("navigate to hotstar site")) {
						w.get("https://www.hotstar.com/in/home");
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("click on search icon")) {
						r.searchIcon();
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("Enter search data")) {
						r.searchTextBox(testdata[j]);
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("click on cross icon in search module")) {
						r.SearchCrossIcon();
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("click on myspace icon")) {
						r.myspace();
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("click on login button")) {
						r.loginbtn();
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("Enter mobile number")) {
						r.mobileNumberField(testdata[j]);
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("click on get otp")) {
						r.getOTP();
						Thread.sleep(2000);
					}else if (step.trim().equalsIgnoreCase("close browser")) {
						w.quit();
					}	
				}
				j++;
			} while (j < testdata.length);	
		}	
	}

}
