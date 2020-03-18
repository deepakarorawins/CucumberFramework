package stepDefinitions;

import com.deesite.cucumber.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	TestContext testContext;
	public Hooks(TestContext context) {
		this.testContext=context;
	}
	
	@Before
	public void BeforeSteps() {
		/*
		 What all you can perform here
		 Starting a webdriver
		 Setting up  DB connection
		 Setting up test data
		 Setting up browser cookies
		 Navigating to certain page
		 or anything before the test
		 */
	}
	
	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().quiteDriver();
	}
	
	

}
