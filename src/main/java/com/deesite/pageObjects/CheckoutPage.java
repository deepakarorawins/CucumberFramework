package com.deesite.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	
	@FindBy(how=How.CSS, using="#billing_first_name")
	private WebElement txtFirstName;
	
	@FindBy(how=How.CSS, using="#billing_last_name")
	private WebElement txtLastName;
	
	@FindBy(how=How.CSS, using="#select2-billing_country-container")
	private WebElement drpdnCountry;
	
	@FindBy(how=How.CSS, using="#select2-billing_country-results li")
	private List<WebElement> lstCountry;
	
	@FindBy(how=How.CSS, using="#billing_address_1")
	private WebElement txtBillingAddress;
	
	@FindBy(how=How.CSS, using="#billing_city")
	private WebElement txtCity;
	
	@FindBy(how=How.CSS, using="#billing_state")
	private WebElement drpdnBillingState;
	
	@FindBy(how=How.CSS, using="#billing_postcode")
	private WebElement txtBillingPostCode;
	
	@FindBy(how=How.CSS, using="#billing_phone")
	private WebElement txtBillingPhone;
	
	@FindBy(how=How.CSS, using="#billing_email")
	private WebElement txtBillingEmail;
	
	@FindBy(how=How.CSS, using="input#terms")
	private WebElement chkbxAcceptTermsAndCondition;
	
	@FindBy(how=How.CSS, using="#place_order")
	private WebElement btnPlaceOrder;
	
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void enterLasName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public void selectCountry(String countryName) {
		drpdnCountry.click();
		try { Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		for (WebElement country : lstCountry) {
			if (country.getText().equals("India")) {
				country.click();
				try { Thread.sleep(3000);} 
				catch (InterruptedException e) {e.printStackTrace();}
				break;
			}
		}
	}
	
	public void enterBillingAddress(String billingAddress) {
		txtBillingAddress.sendKeys(billingAddress);
	}
	
	public void enterCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void selectState(String billingState) {
		Select state = new Select(drpdnBillingState);
		state.selectByVisibleText(billingState);
	}
	
	public void enterBillingPostCode(String billingPostCode) {
		txtBillingPostCode.sendKeys(billingPostCode);
	}
	
	public void enterBillingPhone(String billingPhone) {
		txtBillingPhone.sendKeys(billingPhone);
	}
	
	public void enterBillingEmail(String billingEmail) {
		txtBillingEmail.sendKeys(billingEmail);
	}
	
	public void checkTermsAndCondition(boolean value) {
		if(value) chkbxAcceptTermsAndCondition.click();
	}
	
	public void clickPlaceOrder() {
		btnPlaceOrder.submit();
	}
	
	public void fillPersonalDetails() {
		enterFirstName("Automation");
		enterLasName("Test");
		selectCountry("India");
		enterBillingAddress("Shalimar Bagh");
		enterCity("Delhi");
		selectState("Goa");
		enterBillingPostCode("110088");
		enterBillingPhone("000000000");
		enterBillingEmail("deemet@mailinator.com");
		
		
		
		
		
	}

}
