package stepdefination;

import com.pages.CartPage;
import com.pages.ProductDetailPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class CartPageStep {
	private String GCNumber;

	private CartPage cartPage = new CartPage(DriverFactory.getDriver());

	@And("Click cart icon on top")
	public void navigate_to_cart_page_and_verify() throws Exception {
		cartPage.clickCart();
	}

	@And("Click on checkout button")
	public void click_on_checkout_button() throws Exception {
		cartPage.clickcartCheckout();
		cartPage.offercheck();
	}
	
	@And("Read the Giftcertificate")
	public void read_giftcertificate() {
		GCNumber=	cartPage.readGiftCertificate();
	}
	
	@And("Apply Gift Certificate on Cart")
	public void apply_gift_certificate_cart() throws Exception{
		Thread.sleep(1000);
		cartPage.clickshowGClink();
		cartPage.enterGC(GCNumber);
		cartPage.applyGC();
		Thread.sleep(1000);

		
	}

}
