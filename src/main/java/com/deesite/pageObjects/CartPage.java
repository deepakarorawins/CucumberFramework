package com.deesite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(how=How.CSS, using=".cart-button")
	private WebElement btnCart;
	
	@FindBy(how=How.CSS, using=".checkout-button.alt")
	private WebElement btnProceedToCheckout;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clicProceedToCheckout() {
		btnProceedToCheckout.click();
		try { Thread.sleep(5000);} 
		catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public void clickCart() {
		btnCart.click();
	}

}
