package com.deesite.managers;

import org.openqa.selenium.WebDriver;

import com.deesite.pageObjects.CartPage;
import com.deesite.pageObjects.CheckoutPage;
import com.deesite.pageObjects.HomePage;
import com.deesite.pageObjects.ProductListingPage;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private CartPage cartPage;
	private ProductListingPage productListingPage;
	private CheckoutPage checkoutPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? new HomePage(driver) : homePage;
	}
	
	public CartPage getCartPage() {
		return (cartPage == null) ? new CartPage(driver) : cartPage;
	}
	
	public ProductListingPage getProductListingPage() {
		return (productListingPage == null) ? new ProductListingPage(driver) : productListingPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? new CheckoutPage(driver) : checkoutPage;
	}
	
}
