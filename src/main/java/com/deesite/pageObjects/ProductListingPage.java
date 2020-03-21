package com.deesite.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {
	WebDriver driver;
	
	@FindAll(@FindBy(how=How.CSS, using=".noo-product-inner"))
	private List<WebElement> lstProduct;
	
	@FindBy(how=How.CSS, using="#pa_color")
	private WebElement drpdnColor;
	
	@FindBy(how=How.CSS, using="#pa_size")
	private WebElement drpdnSize;
	
	@FindBy(how=How.CSS, using="button.single_add_to_cart_button")
	private WebElement btnAddToCart;
	
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct(int productNumber) {
		lstProduct.get(productNumber).click();
	}
	
	public void selectProductColor(String productColor) {
		Select color=new Select(drpdnColor);
		color.selectByVisibleText(productColor);
	}
	
	public String getProductName(int productNumber) {
		return lstProduct.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}
	
	
	public void selectProductSize(String productSize) {
		Select size=new Select(drpdnSize);
		size.selectByVisibleText(productSize);
	}
	
	
	public void clickAddToCart() {
		btnAddToCart.click();
	}

}
