package stepDefinitions;

import com.deesite.cucumber.TestContext;
import com.deesite.managers.FileReaderManager;
import com.deesite.pageObjects.CheckoutPage;
import com.deesite.testDataTypes.Customer;

import io.cucumber.java.en.When;

public class CheckoutPageSteps {
	TestContext testContext;
	CheckoutPage checkoutPage;

	public CheckoutPageSteps(TestContext testContext) {
		this.testContext = testContext;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}

	@When("enter {string} personal details on checkout page")
	public void enter_personal_details_on_checkout_page(String customerName) throws InterruptedException {
		Thread.sleep(5000);
		Customer customer = FileReaderManager.getInstance().getJsonDataReader().getCustomerByName(customerName);
		checkoutPage.fillPersonalDetails(customer);

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
		checkoutPage.checkTermsAndCondition(true);
		checkoutPage.clickPlaceOrder();
		Thread.sleep(5000);
	}

}
