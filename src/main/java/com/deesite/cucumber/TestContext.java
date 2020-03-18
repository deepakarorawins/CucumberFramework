package com.deesite.cucumber;

import com.deesite.managers.PageObjectManager;
import com.deesite.managers.WebDriverManager;

public class TestContext {
	private WebDriverManager webDriverManager;

	private PageObjectManager pageObjectManager;

	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
