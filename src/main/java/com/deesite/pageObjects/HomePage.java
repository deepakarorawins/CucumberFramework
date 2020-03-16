package com.deesite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void performSearch(String searchTerm) {
		driver.navigate().to("http://shop.demoqa.com/?s=" + searchTerm + "&post_type=product");
	}
	
	public void navigateToHomePage() {
		driver.get("http://www.shop.demoqa.com");
	}
	
	
}
