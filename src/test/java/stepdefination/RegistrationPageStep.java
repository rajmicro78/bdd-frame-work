package stepdefination;

import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class RegistrationPageStep {
	private RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	String sitename = homePage.getLogoText();

	@And("Enter the Email-address in Registration page")
	public void enter_email_registration() {
		registrationPage.emailaddress();

	}

	@And("^Enter First Name \"([^\"]*)\"$")
	public void enter_first_name(String fname) {
		registrationPage.firstname(fname);
	}

	@And("^Enter Last Name \"([^\"]*)\"$")
	public void enter_last_name(String lname) {
		registrationPage.lastname(lname);
	}

	@And("^Enter Address \"([^\"]*)\"$")
	public void enter_address(String address) {
		registrationPage.address(address);

	}

	@And("^Enter PostNumber \"([^\"]*)\"$")
	public void enter_post_number(String zipcode) {
		// registrationPage.zipcode(sitename);
		registrationPage.zipcode(zipcode);

	}

	@And("^Enter Mobile Number \"([^\"]*)\"$")
	public void enter_mobile_number(String mobilenumber) {
		// registrationPage.mobilenumber(sitename);
		registrationPage.mobilenumber(mobilenumber);
	}

	@And("Select Newsletter checkbox")
	public void select_newsletter_checkbox() {
		registrationPage.radionewsletterchk();
	}

	@And("Select SMS checkbox")
	public void select_sms_checkbox() {
		registrationPage.radioSMSchk();
	}

	@And("Enter Password {string}")
	public void enter_password(String password) {
		registrationPage.password(password);
	}

	@And("Click on Submit Registration")
	public void click_on_submit_registration() throws Exception {
		registrationPage.registrationbtn();
		Thread.sleep(4000);
	}

}
