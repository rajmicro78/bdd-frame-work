package stepdefination;

import com.pages.HomePage;
import com.pages.SearchPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class SearchPageStep {
	private SearchPage searchPage = new SearchPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	String sitename = homePage.getLogoText();

	@And("Search for {string}")
	public void search_gift_certificate(String Giftcertificate) {
		searchPage.doSearch(sitename);

	}

	@And("Click on search button")
	public void click_search_button() throws Exception {
		searchPage.clicksearchbtn();
	}
}
