package stepDefinitions;

import com.deesite.cucumber.TestContext;
import com.deesite.pageObjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps {
	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext testContext) {
		this.testContext = testContext;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
		homePage.navigateToHomePage();
	}

	@When("he search for {string}")
	public void he_search_for(String product) {
		homePage.performSearch(product);
	}
}
