package com.pages;

import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import implementation.CommonFunction;

public class RegistrationPage {
	private WebDriver driver;
	@FindBy(id = "txt-post-number")
	private WebElement zipCodeTxtFld;
	@FindBy(id = "txt-mobile-number")
	private WebElement mobileTxtFld;
	@FindBy(id = "txt-email")
	private WebElement emailTxtFld;
	@FindBy(id = "txt-first-name")
	private WebElement fnameTxtFld;
	@FindBy(id = "txt-last-name")
	private WebElement lnameTxtFld;
	@FindBy(id = "txt-address")
	private WebElement addressTxtFld;
	@FindBy(id = "btn-register")
	private WebElement RegisterBtn;
	@FindBy(id = "txt-password")
	private WebElement Passwordtxt;
	@FindBy(id = "radio-newsletter-on")
	private WebElement radionewsletter;
	@FindBy(id = "radio-sms-on")
	private WebElement radiosms;
	CommonFunction cf = new CommonFunction();

	static String registzip;
	static String registmobile;

	// Page constructor
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void emailaddress() {
		emailTxtFld.clear();
		emailTxtFld.sendKeys(cf.getemail());
	}

	public void firstname(String fname) {
		fnameTxtFld.clear();
		fnameTxtFld.sendKeys(fname);

	}

	public void lastname(String lname) {
		lnameTxtFld.clear();
		lnameTxtFld.sendKeys(lname);
	}

	public void address(String address) {
		addressTxtFld.clear();
		addressTxtFld.sendKeys(address);

	}

	public void password(String password) {
		Passwordtxt.clear();
		Passwordtxt.sendKeys(password);

	}

	public void zipcode(String registzip) {
	//	registrationmobilezip(sitecode);
		zipCodeTxtFld.clear();
		zipCodeTxtFld.sendKeys(registzip);

	}

	public void mobilenumber(String registmobile) {
		//registrationmobilezip(sitecode);
		mobileTxtFld.clear();
		mobileTxtFld.sendKeys(registmobile);

	}

	public void radionewsletterchk() {
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radionewsletter);

	}

	public void radioSMSchk() {
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radiosms);

	}

	public void registrationbtn() throws Exception {
		RegisterBtn.click();
	}

	public void registrationmobilezip(String sitecode) {
		if (sitecode.equals("Cocopanda.de")) {
			registzip = "68159";
			registmobile = "01512345690";
		} else if (sitecode.equals("Cocopanda.se")) {
			registzip = "58002";
			registmobile = "0762552625";
		} else if (sitecode.equals("Cocopanda.at")) {
			registzip = "2320";
			registmobile = "066123456789";

		} else if (sitecode.equals("BliVakker.no") || sitecode.equals("Netthandelen.no")) {
			registzip = "5802";
			Calendar cals = Calendar.getInstance();
			int minute = cals.get(Calendar.MINUTE);
			int date = cals.get(Calendar.DATE);
			int year = cals.get(Calendar.MONTH);
			int start = 47;
			if (minute < 10) {
				minute = minute + 10;
			}
			if (date < 10) {
				date = date + 10;
			}
			if (year < 10) {
				year = year + 10;
			}
			String mobile = String.valueOf(
					String.valueOf(start) + String.valueOf(minute) + String.valueOf(date) + String.valueOf(year));
			registmobile = mobile;
		} else if (sitecode.equals("Cocopanda.fi")) {
			registzip = "10120";
			registmobile = "0453181878";
		} else if (sitecode.equals("Cocopanda.nl")) {
			registzip = "5011";
			registmobile = "0612345678";

		} else if (sitecode.equals("Cocopanda.dk")) {
			registzip = "4000";
			registmobile = "47544754";
		}

	}

}
