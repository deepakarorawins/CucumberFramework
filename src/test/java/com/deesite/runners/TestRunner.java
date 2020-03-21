package com.deesite.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests", 
		glue = { "stepDefinitions" },
		//plugin = {"usage" },
		plugin = {"pretty", 
				"json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports"}, 
		monochrome = true)
public class TestRunner {

}
