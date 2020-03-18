package stepDefinitions;

import com.deesite.cucumber.TestContext;
import com.deesite.pageObjects.ProductListingPage;

import io.cucumber.java.en.When;

public class ProductPageSteps {
	TestContext testContext;
	ProductListingPage productListingPage;

	public ProductPageSteps(TestContext testContext) {
		this.testContext = testContext;
		productListingPage = this.testContext.getPageObjectManager().getProductListingPage();
	}

	@When("choose to buy first item")
	public void choose_to_buy_first_item() {
		productListingPage.selectProduct(0);
		productListingPage.selectProductColor("White");
		productListingPage.selectProductSize("Medium");
		productListingPage.clickAddToCart();
	}

}
