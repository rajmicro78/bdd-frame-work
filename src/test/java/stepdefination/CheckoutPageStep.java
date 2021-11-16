package stepdefination;

import com.pages.CheckOutPage;
import com.pages.HomePage;
import com.pages.PaymentPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Step.DataTable;

public class CheckoutPageStep {
	private CheckOutPage checkoutPage = new CheckOutPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private PaymentPage paymentPage = new PaymentPage(DriverFactory.getDriver());
	String sitename = homePage.getLogoText();

	// @And("Enter the guest user detail")
	@And("^Enter the customer payment details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_the_guest_user_detail(String FirstName, String LastName, String Address, String Zipcode,
			String Mobile, String Identity) throws Exception {

	//	checkoutPage.guestdetail(FirstName, LastName, Address, Zipcode, Mobile, Identity);
		
		checkoutPage.NguestDetail(FirstName, LastName, Address, Zipcode, Mobile, Identity);
	}

	@And("Select the shipping method")
	public void select_shipping_method() throws Exception {
		// checkoutPage.selectShipping(sitename);
	}

	@And("Select the terms and condition")
	public void select_terms_condition() throws Exception {
		checkoutPage.termscheckbox(sitename);
	}

	@And("Enter the credit card payment detail")
	public void enter_credit_card_payment() throws Exception {
		paymentPage.creditDebitCard(sitename);
	}

	@And("Enter the Pay now card payment detail")
	public void enter_paynow_card_payment() throws Exception {
		paymentPage.klarnaPaynow(sitename);
	}

	@And("Select Pay Later payment")
	public void select_pay_later_payment() throws Exception {
		paymentPage.klarnaPayLater(sitename);
	}

	@Then("Order created successfully and order  id displayed")
	public void order_created_successfully_and_order_id_displayed() throws Exception {
		paymentPage.orderNumber();
	}

}
