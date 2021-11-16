package stepdefination;

import com.pages.HomePage;
import com.pages.ProductListPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;



public class ProductListPageStep {
	private ProductListPage productListPage = new ProductListPage(DriverFactory.getDriver());
	
	@When("Verify product list page is displayed")
	public void verify_product_list_page_is_displayed() throws Exception  {
		productListPage.sortingProduct();

	}

	@When("Randomly select product and click on product")
	public void randomly_select_product_and_click_on_product() throws Exception  {
		productListPage.clickProduct();
	}
}
