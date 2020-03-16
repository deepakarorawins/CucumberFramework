package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.deesite.pageObjects.CartPage;
import com.deesite.pageObjects.CheckoutPage;
import com.deesite.pageObjects.HomePage;
import com.deesite.pageObjects.ProductListingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;
	HomePage home = new HomePage(driver);
	ProductListingPage productListingPage = new ProductListingPage(driver);
	CartPage cartPage = new CartPage(driver);
	CheckoutPage checkoutPage = new CheckoutPage(driver);
	
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
		System.setProperty("webdriver.chrome.driver", "//Users//deepakarora//soft//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
	}

	@When("he search for {string}")
	public void he_search_for(String product) {
		home = new HomePage(driver);
		home.performSearch(product);
	}

	@When("choose to buy first item")
	public void choose_to_buy_first_item() {
		productListingPage = new ProductListingPage(driver);
		productListingPage.selectProduct(0);
		productListingPage.selectProductColor("White");
		productListingPage.selectProductSize("Medium");
		productListingPage.clickAddToCart();
	}

	@When("moves to checkout from mini cart")
	public void moves_to_checkout_from_mini_cart() {
		cartPage = new CartPage(driver);
		cartPage.clickCart();
		cartPage.clicProceedToCheckout();
	}

	@When("enter personal details on checkout page")
	public void enter_personal_details_on_checkout_page() throws InterruptedException {
		Thread.sleep(5000);
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.fillPersonalDetails();
		
	}

	@When("select same delivery address")
	public void select_same_delivery_address() {
		// WebElement shipToDifferetAddress =
		// driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		// shipToDifferetAddress.click();

	}

	@When("select payment method as {string} payment")
	public void select_payment_method_as_payment(String string) {
		// List<WebElement> paymentMethod =
		// driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		// paymentMethod.get(0).click();
	}

	@When("place the order")
	public void place_the_order() throws InterruptedException {
		Thread.sleep(5000);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.checkTermsAndCondition(true);
		checkoutPage.clickPlaceOrder();
		
		driver.quit();


	}

}
