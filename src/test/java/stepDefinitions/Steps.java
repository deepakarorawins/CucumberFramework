package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
		System.setProperty("webdriver.chrome.driver", "//Users//deepakarora//soft//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
	}

	@When("he search for {string}")
	public void he_search_for(String string) {
		driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
	}

	@When("choose to buy first item")
	public void choose_to_buy_first_item() {
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();

		Select chooseColor = new Select(driver.findElement(By.cssSelector("#pa_color")));
		chooseColor.selectByVisibleText("White");

		Select chooseSize = new Select(driver.findElement(By.cssSelector("#pa_size")));
		chooseSize.selectByVisibleText("Medium");

		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();
	}

	@When("moves to checkout from mini cart")
	public void moves_to_checkout_from_mini_cart() {
		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();

		WebElement proceedToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		proceedToCheckout.click();
	}

	@When("enter personal details on checkout page")
	public void enter_personal_details_on_checkout_page() throws InterruptedException {
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");

		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");

		/*
		 * Select countryDropDown = new
		 * Select(driver.findElement(By.cssSelector("#billing_country")));
		 * chooseSize.selectByVisibleText("India");
		 */

		WebElement countryDropDown = driver.findElement(By.cssSelector("#select2-billing_country-container"));
		countryDropDown.click();
		Thread.sleep(2000);

		List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-billing_country-results li"));
		for (WebElement country : countryList) {
			if (country.getText().equals("India")) {
				country.click();
				Thread.sleep(3000);
				break;
			}
		}

		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Shalimar Bagh");

		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");
		// select2-billing_state-results
		Select stateDropDown = new Select(driver.findElement(By.cssSelector("#billing_state")));
		stateDropDown.selectByVisibleText("Goa");

		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("110088");

		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");

		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");

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
		for (int i = 0; i <= 2; i++) {
			try {
				WebElement acceptTC = driver.findElement(By.cssSelector("input#terms"));
				acceptTC.click();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}

		/*
		 * WebElement acceptTC = driver.findElement(By.cssSelector("input#terms"));
		 * acceptTC.click();
		 */

		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
		
		driver.quit();


	}

}
