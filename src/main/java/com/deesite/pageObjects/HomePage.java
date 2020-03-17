package com.deesite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.deesite.dataProfider.ConfigFileReader;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
	}
	
	public void performSearch(String searchTerm) {
		driver.navigate().to("http://shop.demoqa.com/?s=" + searchTerm + "&post_type=product");
	}
	
	public void navigateToHomePage() {
		driver.get(configFileReader.getApplicationUrl());
	}
	
	
}
