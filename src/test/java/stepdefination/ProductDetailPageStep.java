package stepdefination;

import com.pages.HomePage;
import com.pages.ProductDetailPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class ProductDetailPageStep {
	
	private ProductDetailPage PDP = new ProductDetailPage(DriverFactory.getDriver());

	
	
	@When("Select Product Quantity")
	public void select_product_quantity() {
		PDP.selectqty();
	}
	@When("Click on add to Cart button")
	public void click_on_add_to_cart() throws Exception  {
		PDP.clickaddtocart();
	  
	}


}
