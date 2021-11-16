package stepdefination;

import java.sql.SQLException;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import src.com.pack.database.database;

public class LoginPageStep {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	
	private database db = new database(DriverFactory.getDriver());

	@And("Enter the Email-address")
	public void enter_the_email_address() throws Exception {
		loginPage.enterEmail();
	}
	@And("Click on Registration button")
	public void click_on_registration_button() throws Exception {
	   loginPage.clickregisterbtn();
	}
	@And ("Click on login Button")
	public void click_login_button() throws Exception {
		loginPage.clickloginbtn();
	}
	@And ("Click on checkemail Button")
	public void click_checkemail_button() throws Exception  {
		loginPage.clickcheckemail();
	}
	@And("Enter the Password {string}")
	public void enter_password(String password) throws Exception {
		loginPage.enterPassword(password);
	}
	
	@And("Click on Send Activation Link")
	public void click_send_activation_link() throws Exception  {
		loginPage.sendactivation();
	}
	
	@And("Get the Activation Link from database")
	public void get_activation_link_database() throws Exception, SQLException {
		String site=homePage.getLogoText();
		
		db.customeremail();
	}
	
	@And("Click on Activation Link")
	public void click_on_activation_link() throws Exception {
		loginPage.clickactivationlink();
	}
	@And("Click on my GiftCertificate tab")
	public void click_giftcertificate_tab() throws Exception {
		loginPage.clickGifttab();
		
	}
	

}
