package com.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "FeaturesFileFolder", // folder level name
		glue = "com.StepDefination",
		plugin = "html:./CucumberReport/report.html",
		dryRun = false,
		tags = "@DataDriven"       
		)
public class Runner extends AbstractTestNGCucumberTests {

}
