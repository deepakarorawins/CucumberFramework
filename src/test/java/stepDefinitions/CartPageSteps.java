package stepDefinitions;

import com.deesite.cucumber.TestContext;
import com.deesite.pageObjects.CartPage;

import io.cucumber.java.en.When;

public class CartPageSteps {
	TestContext testContext;
	CartPage cartPage;

	public CartPageSteps(TestContext testContext) {
		this.testContext = testContext;
		cartPage = this.testContext.getPageObjectManager().getCartPage();
	}

	@When("moves to checkout from mini cart")
	public void moves_to_checkout_from_mini_cart() {
		cartPage.clickCart();
		cartPage.clicProceedToCheckout();
	}
}
