package com.TestNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsing {
	
	WebDriver w;
	
	@Parameters("browser")
	@Test
	public void launch(String browsers) throws Exception {
		if (browsers.equals("chrome")) {
			w = new ChromeDriver();
		}else if (browsers.equals("firefox")) {
			w = new FirefoxDriver();
		}else if (browsers.equals("edge")) {
			w = new EdgeDriver();
		}
		
		w.get("https://www.facebook.com/");
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) w;
//
//		// Zoom out to 75%
//		js.executeScript("document.body.style.zoom = '150%';");
		
		try {
		    Robot robot = new Robot();
		    // Zoom out twice
		    for (int i = 0; i < 2; i++) {
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        robot.keyPress(KeyEvent.VK_MINUS);
		        robot.keyRelease(KeyEvent.VK_MINUS);
		        robot.keyRelease(KeyEvent.VK_CONTROL);
		    }
		} catch (AWTException e) {
		    e.printStackTrace();
		}
		
	}
	

}
