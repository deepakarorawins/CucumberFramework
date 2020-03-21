package stepDefinitions;

import com.deesite.cucumber.TestContext;
import com.deesite.pageObjects.ProductListingPage;

import enums.Context;
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
		String productName = productListingPage.getProductName(0);
		testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
		productListingPage.selectProduct(0);
		productListingPage.selectProductColor("White");
		productListingPage.selectProductSize("Medium");
		productListingPage.clickAddToCart();
	}

}
