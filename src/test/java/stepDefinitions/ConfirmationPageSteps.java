package stepDefinitions;

import org.junit.Assert;

import com.deesite.cucumber.TestContext;
import com.deesite.pageObjects.ConfirmationPage;

import enums.Context;
import io.cucumber.java.en.When;

public class ConfirmationPageSteps {
	TestContext testContext;
	ConfirmationPage confirmationPage;

	public ConfirmationPageSteps(TestContext context) {
		this.testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@When("verify the order details")
	public void verify_the_order_details() throws InterruptedException {
		String productName = (String)testContext.getScenarioContext().getContext(Context.PRODUCT_NAME);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x->x.contains(productName.toLowerCase())).findFirst().get().length()>0);
	}
}
