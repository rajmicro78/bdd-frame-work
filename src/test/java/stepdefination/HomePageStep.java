package stepdefination;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import implementation.CommonFunction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStep {
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	CommonFunction cf = new CommonFunction();

	private int viewall;

	@Given("^Visit WebSite \"([^\"]*)\"$")
	public void weburl(String weburl) throws Exception {
		String geturl = homePage.getURL();
		weburl = cf.website(weburl);
		geturl = "https://" + geturl + ":" + weburl + "/?consentall=true";
		System.out.println(geturl);
		// DriverFactory.getDriver().get("https://test.brandsdalgroup.com:7002/?consentall=true");
		DriverFactory.getDriver().get(geturl);
		homePage.getLogoText();
		homePage.clicktopLogo();

	}

	@When("Click on top menu")
	public void click_on_top_menu() {
		viewall = homePage.clicktopMenu();

	}

	@And("Click on View All link under the Menu")
	public void click_on_view_all_link_under_the_menu() throws Exception {
		homePage.clickViewallLink(viewall);
	}

	@And("Click on Min Side Icon")
	public void click_on_min_side_icon() throws Exception {
		homePage.clicktopmypage();
	}

	@And("Click on the LogOut Button")
	public void click_the_logout_button() throws Exception {
		homePage.clickLogOut();
	}

	@Given("You are on the Homepage")
	public void you_on_homepage() throws Exception {
		homePage.clicktopLogo();
	}
}
