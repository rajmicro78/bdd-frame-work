package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.qa.util.GenericFunction;

import implementation.CommonFunction;

public class CheckOutPage {
	private WebDriver driver;
	CommonFunction cf = new CommonFunction();
	GenericFunction gf = new GenericFunction();

	@FindBy(id = "billing-email")
	private WebElement emailaddress;
	@FindBy(id = "klarna-checkout-iframe")
	private WebElement klarnaiframe;
	@FindBy(id = "button-primary")
	private List<WebElement> BtnPrimary;
	@FindBy(id = "billing-postal_code")
	private WebElement bpostalcode;
	@FindBy(xpath = "//div[@id='billing-fieldset']/div")
	private List<WebElement> numberofFields;
	@FindBy(xpath = "(//div[@id='billing-fieldset']/div//input)")
	private List<WebElement> fieldsName;
	@FindBy(xpath = "//input[@id='billing-national_identification_number' or @id='billing-date_of_birth']")
	private WebElement identitynumber;
	@FindBy(xpath = "(//button[contains(@data-cid,'button.buy_button')]/div/div)[1]")
	private WebElement checkoutBuy;
	@FindBy(id = "billing-given_name")
	private WebElement firstname;
	@FindBy(id = "billing-family_name")
	private WebElement lastname;
	@FindBy(id = "billing-street_address")
	private WebElement streetaddress;
	@FindBy(id = "billing-city")
	private WebElement city;
	@FindBy(id = "billing-phone")
	private WebElement phone;
	@FindBy(xpath = "//div[@id='SHIPMO-shipping-options__container']/div/div[2]/label/input")
	private List<WebElement> shippingoptions;
	@FindBy(xpath = "//div[@id='SHIPMO-shipping-options__container']/div/div")
	private List<WebElement> shippingcontainer;
	@FindBy(xpath = "//label[@id='additional_checkbox_from_merchant__label']")
	private List<WebElement> termscheckbox;
	@FindBy(xpath = "//div[contains(@id,'credit_card__container')]/label/input")
	private WebElement creditorDebitcard;
//	@FindBy(xpath = "//input[@id='nin']|//input[@id='dob']|//input[@name='nationalIdentificationNumber']")
	@FindBy(xpath = "//input[@id='nin' or @id='dob' or @name='nationalIdentificationNumber']")
	private WebElement securityNumber;
	static String postalcode;
	static String personname;
	static String familyname;
	static String billingcity;
	static String streetAddress;
	static String phoneNumber;
	static String securitynumber;

	// Page constructor
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this);

	}

	public void klarnaguestswitch(String Fieldname, String FirstName, String LastName, String Address, String Zipcode,
			String Mobile, String Identity) throws Exception {
		// klarnadetail(sitecode);

		switch (Fieldname) {
		case "billing-email":
			enteremail(cf.getemail());
			break;
		case "billing-postal_code":
			enterpostal(Zipcode);
			break;
		case "billing-given_name":
			enterfname(FirstName);
			break;
		case "billing-family_name":
			enterlname(LastName);
			break;
		case "billing-street_address":
			enterStadd(Address);

			break;
		case "billing-phone":
			enterphone(Mobile);

			break;
		case "billing-date_of_birth":
		case "billing-national_identification_number":
			enteridentity(Identity);

			break;
		case "billing-city":
			System.out.println("no city");
			break;
		case "billing-care_of":
			System.out.println("no need of billing care of");
			break;
		}

	}

	public void NguestDetail(String FirstName, String LastName, String Address, String Zipcode, String Mobile,
			String Identity) throws Exception {
		Thread.sleep(1000);
		driver.switchTo().frame(klarnaiframe);
		Thread.sleep(1000);
		int countFields = numberofFields.size();
		String fieldsto;
		if (countFields == 0) {
			fieldsto = "zero";
		} else if (countFields == 2) {
			fieldsto = "two";

		} else {
			fieldsto = "greater";

		}

//		switch (countFields) {
		switch (fieldsto) {

//		case 0:
		case "zero":
			break;
//		case 2:
		case "two":
			Thread.sleep(1000);
			enteremail(cf.getemail());
			Thread.sleep(1000);
			enterpostal(Zipcode);
			Thread.sleep(1000);
			clickBtnPrimary();
			Thread.sleep(1000);
			filldata(FirstName, LastName, Address, Zipcode, Mobile, Identity);
			break;
//		case  7:
		case "greater":
			filldata(FirstName, LastName, Address, Zipcode, Mobile, Identity);
			break;
//		case 8:
//			String identival= identitynumber.getAttribute("value");
//			if(identival.contains(Identity)) {
//				break;
//			}else {
//			filldata(FirstName, LastName, Address, Zipcode, Mobile, Identity);
//			}
//			break;
//		case 9:
//			String identiva= identitynumber.getAttribute("value");

//			filldata(FirstName, LastName, Address, Zipcode, Mobile, Identity);
//			break;

		}

	}

	public void filldata(String FirstName, String LastName, String Address, String Zipcode, String Mobile,
			String Identity) throws Exception {
		int field = numberofFields.size();
		boolean identi = driver
				.findElements(By.xpath(
						"//input[@id='billing-national_identification_number' or @id='billing-date_of_birth']"))
				.size() != 0;
		
		System.out.println("field-"+field+"-identi-"+identi);
		if(field > 7 && identi) {
			System.out.println("NO need to fill");
		}else {
			for (int i = 1; i <= field - 1; i++) {
				String attribute = fieldsName.get(i).getAttribute("id");
				String attributevalue = fieldsName.get(i).getAttribute("value");
				System.out.println("attribute-" + attribute + "attributevalue-" + attributevalue);
				klarnaguestswitch(attribute, FirstName, LastName, Address, Zipcode, Mobile, Identity);
			}
		}
		
/*		
		
		if (field > 7) {
			Thread.sleep(5000);

			boolean identi = driver
					.findElements(By.xpath(
							"//input[@id='billing-national_identification_number' or @id='billing-date_of_birth']"))
					.size() != 0;
			if (identi) {
				String identiva = identitynumber.getAttribute("value");
				System.out.println("identiva-" + identiva );
				if (identiva.contains(Identity)) {
					System.out.println("no need to fill");
				} else {
					for (int i = 2; i <= field - 1; i++) {
						String attribute = fieldsName.get(i).getAttribute("id");
						String attributevalue = fieldsName.get(i).getAttribute("value");
						System.out.println("attribute-" + attribute + "attributevalue-" + attributevalue);
						klarnaguestswitch(attribute, FirstName, LastName, Address, Zipcode, Mobile, Identity);
					}
				}
			} else {
				for (int i = 2; i <= field - 1; i++) {
					String attribute = fieldsName.get(i).getAttribute("id");
					String attributevalue = fieldsName.get(i).getAttribute("value");
					System.out.println("attribute-" + attribute + "attributevalue-" + attributevalue);
					klarnaguestswitch(attribute, FirstName, LastName, Address, Zipcode, Mobile, Identity);
				}
			}

		} else {
			System.out.println("field-" + field);
			for (int i = 2; i <= field - 1; i++) {
				String attribute = fieldsName.get(i).getAttribute("id");
				String attributevalue = fieldsName.get(i).getAttribute("value");
				System.out.println("attribute-" + attribute + "attributevalue-" + attributevalue);
				klarnaguestswitch(attribute, FirstName, LastName, Address, Zipcode, Mobile, Identity);
			}
		}
		
		*/
		do {
			clickBtnPrimary();
		}while((BtnPrimary.size() != 0));
		
//		clickBtnPrimary();
//		clickBtnPrimary();

	}

	public void guestdetail(String FirstName, String LastName, String Address, String Zipcode, String Mobile,
			String Identity) throws Exception {
		Thread.sleep(1000);
		driver.switchTo().frame(klarnaiframe);
		Thread.sleep(1000);
		enteremail(cf.getemail());
		Thread.sleep(1000);
		enterpostal(Zipcode);
		Thread.sleep(1000);
		clickBtnPrimary();
		Thread.sleep(1000);
		int field0 = numberofFields.size();
		System.out.println("No Fields to Fill-" + field0);
		if (field0 == 0) {
			System.out.println("No Fields to Fill-" + field0);
		} else {

//		int fields = numberofFields.size();
//		System.out.println("fields-" + fields);

//		if (fields == 2) {
			// enteremail(cf.getemail());
			// enterpostal(Zipcode);
			// clickBtnPrimary();
			// Thread.sleep(2000);
			int field = numberofFields.size();
			System.out.println("field-" + field);
			for (int i = 2; i <= field - 1; i++) {
				String attribute = fieldsName.get(i).getAttribute("id");
				System.out.println("attribute-" + attribute);
				klarnaguestswitch(attribute, FirstName, LastName, Address, Zipcode, Mobile, Identity);
			}
			clickBtnPrimary();

			// } else {
//			int fields = numberofFields.size();
//			System.out.println("fields-" + fields);
//			for (int i = 0; i <= fields - 1; i++) {
//				String attribute = fieldsName.get(i).getAttribute("id");
//				System.out.println("attribute-" + attribute);
//				klarnaguestswitch(attribute, FirstName, LastName, Address, Zipcode, Mobile, Identity);
//			}
//		}
//		clickBtnPrimary();
			int notfill = numberofFields.size();
			int totalnotfill = 0;
			List<String> list = new ArrayList<String>();
			for (int i = 0; i <= notfill - 1; i++) {
				String attribute = fieldsName.get(i).getAttribute("autocomplete");
				if (!attribute.equalsIgnoreCase("")) {
					String NFattribute = fieldsName.get(i).getAttribute("id");
					list.add(NFattribute);
					System.out.println("NFattribute-" + NFattribute);
					// klarnaguestswitch(attribute, FirstName, LastName, Address, Zipcode, Mobile,
					// Identity);
					totalnotfill++;
				}
			}
			for (String att : list) {
				klarnaguestswitch(att, FirstName, LastName, Address, Zipcode, Mobile, Identity);
				System.out.println("att----" + att);
			}

			if (totalnotfill > 0) {
				System.out.println("More than 1 not filled -" + totalnotfill);
				clickBtnPrimary();

			}
			clickBtnPrimary();
		}
		/*
		 * if (fields == 8) { Thread.sleep(1000); enteremail(cf.getemail());
		 * enterpostal(postalcode); enterfname(personname); enterlname(familyname);
		 * enterStadd(streetAddress); enterphone(phoneNumber);
		 * enteridentity(securitynumber); clickBtnPrimary(); clickBtnPrimary(); } else
		 * if (fields == 7) { Thread.sleep(1000);
		 * 
		 * enteremail(cf.getemail()); enterpostal(postalcode); enterfname(personname);
		 * enterlname(familyname); enterStadd(streetAddress); enterphone(phoneNumber);
		 * clickBtnPrimary(); clickBtnPrimary();
		 * 
		 * } else { enteremail(cf.getemail()); enterpostal(postalcode);
		 * clickBtnPrimary(); Thread.sleep(1000);
		 * 
		 * if (BtnPrimary.size() != 0) { int field = numberofFields.size(); if (field ==
		 * 7) { Thread.sleep(500);
		 * 
		 * enterfname(personname); enterlname(familyname); enterStadd(streetAddress);
		 * enterphone(phoneNumber); } else {
		 * 
		 * enterfname(personname); enterlname(familyname); enterStadd(streetAddress);
		 * enterphone(phoneNumber); enteridentity(securitynumber); } clickBtnPrimary();
		 * clickBtnPrimary();
		 * 
		 * } }
		 */
	}

	public void enteremail(String email) throws Exception {
		emailaddress.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(2000);

		emailaddress.sendKeys(email);
		Thread.sleep(1000);
//		 gf.TypeInField(emailaddress,email);
	}

	public void enterpostal(String postal) throws Exception {
		bpostalcode.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(2000);

		bpostalcode.sendKeys(postal);
		Thread.sleep(1000);

		gf.TypeInField(bpostalcode, postal);
	}

	public void clickBtnPrimary() throws Exception {
		boolean primarybtn = BtnPrimary.size() != 0;
		if (primarybtn) {
			gf.retryingFindClick(BtnPrimary.get(0));
//Retry click			BtnPrimary.get(0).click();
			Thread.sleep(1000);
		}
	}

	public void enteridentity(String identity) throws Exception {
		// if (identitynumber.size() > 0) {
		// Thread.sleep(1000);
		identitynumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(1000);
		identitynumber.sendKeys(identity);
		// }
		// gf.TypeInField(identitynumber, identity);

	}

	public void enterfname(String fname) throws Exception {
//		Thread.sleep(1000);

		firstname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(2000);
//		do {
		firstname.sendKeys(fname);
		Thread.sleep(2000);

//		} while (!firstname.getAttribute("autocomplete").equalsIgnoreCase(""));
		// firstname.sendKeys(fname);

//		gf.TypeInField(firstname, fname);
	}

	public void enterlname(String lname) throws Exception {
		lastname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(1000);
//		do {
		lastname.sendKeys(lname);
		Thread.sleep(1000);

//		} while (!lastname.getAttribute("autocomplete").equalsIgnoreCase(""));
//		lastname.sendKeys(lname);

//		gf.TypeInField(lastname, lname);

	}

	public void enterStadd(String address) throws Exception {
		streetaddress.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(1000);
//		do {
		streetaddress.sendKeys(address);
		Thread.sleep(1000);

//		} while (!streetaddress.getAttribute("autocomplete").equalsIgnoreCase(""));
//		streetaddress.sendKeys(address);

//		gf.TypeInField(streetaddress, address);

	}

	public void securityNumber(String securitynumber) throws Exception {
		System.out.println("securitynumber-" + securitynumber);

//		gf.TypeInField(securityNumber, securitynumber);

		securityNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(1000);
		securityNumber.sendKeys(securitynumber);
		Thread.sleep(1000);
	}

	public void enterphone(String phonenum) throws Exception {
//		TypeInField(phone, phonenum);
		phone.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		// phone.sendKeys(phonenum);
		Thread.sleep(1000);
//		do {
		phone.sendKeys(phonenum);
		Thread.sleep(1000);

//		} while (!phone.getAttribute("autocomplete").equalsIgnoreCase(""));

//		gf.TypeInField(phone, phonenum);

	}

	/*
	 * public void klarnadetail(String sitecode) { if
	 * (sitecode.equalsIgnoreCase("BliVakker.no") ||
	 * sitecode.equalsIgnoreCase("Netthandelen.no")) { postalcode = "0563";
	 * personname = "Testperson-no"; familyname = "Approved"; streetAddress =
	 * "Sæffleberggate 56"; phoneNumber = "40123456"; securitynumber =
	 * "01087000571"; billingcity = "Oslo"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.nl")) { postalcode = "2521VA";
	 * personname = "Testperson-nl"; familyname = "Approved"; streetAddress =
	 * "Neherkade 1"; phoneNumber = "0612345678"; securitynumber = "10071970";
	 * billingcity = "Gravenhage"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.at")) { postalcode = "8071"; personname
	 * = "Testperson-at"; familyname = "Approved"; streetAddress =
	 * "Klarna-Straße 1/2/3"; phoneNumber = "06762600000"; securitynumber =
	 * "14041960"; billingcity = "Hausmannstätten"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.dk")) { postalcode = "6800"; personname
	 * = "Testperson-dk"; familyname = "Approved"; streetAddress =
	 * "Sæffleberggate 56,1 mf"; phoneNumber = "20123456"; securitynumber =
	 * "0801363945"; billingcity = "Varde"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.fi")) { postalcode = "28100";
	 * personname = "Testperson-fi"; familyname = "Approved"; streetAddress =
	 * "Kiväärikatu 10"; phoneNumber = "0401234567"; securitynumber = "190122-829F";
	 * billingcity = "Pori"; } else if (sitecode.equalsIgnoreCase("Cocopanda.de")) {
	 * postalcode = "41460"; personname = "Testperson-de"; familyname = "Approved";
	 * streetAddress = "Hellersbergstraße 14"; phoneNumber = "522113356";
	 * securitynumber = "07071960"; billingcity = "Neuss"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.se")) { postalcode = "27393";
	 * personname = "Approved16"; familyname = "Sweden16"; streetAddress =
	 * "Ryggevägen 3"; phoneNumber = "0701234567"; securitynumber = "410321-9202";
	 * billingcity = "TOMELILLA"; } }
	 */
	public void selectShipping(String sitecode) throws Exception {
		boolean shippingoption = shippingoptions.size() > 0;
		if (shippingoption) {
			int shippiption = shippingcontainer.size();
			System.out.println("shippiption-" + shippiption);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(4000);
			/*
			 * if (shippiption > 1) { if (sitecode.equalsIgnoreCase("BliVakker.no") ||
			 * sitecode.equalsIgnoreCase("Cocopanda.fi")) { shippiption = shippiption - 1;
			 * System.out.println("shippiption-"+shippiption);
			 * 
			 * shippingcontainer.get(shippiption).click(); Thread.sleep(2000); } } else {
			 */

			gf.retryingFindClick(shippingcontainer.get(shippiption));
// REtry CLick			shippingcontainer.get(shippiption).click();
			// }
		}
		Thread.sleep(4000);
	}

	public void termscheckbox(String sitecode) throws Exception {
		if (sitecode.equalsIgnoreCase("Cocopanda.dk")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			js.executeScript("arguments[0].scrollIntoView(true);", checkoutBuy);
			// js.executeScript("arguments[0].scrollIntoView(true);", creditorDebitcard);
			Thread.sleep(2000);
			boolean terms = termscheckbox.size() > 0;
			if (terms) {
				gf.retryingFindClick(termscheckbox.get(0));
//REtry CLick				termscheckbox.get(0).click();
				Thread.sleep(2000);
			}
		}
	}
	/*
	 * public void TypeInField(WebElement idelement, String value) throws Exception
	 * { idelement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); String
	 * currentvalue = idelement.getAttribute("value");
	 * System.out.println("currentvalue" + currentvalue); do {
	 * idelement.sendKeys(value); Thread.sleep(1000); } while
	 * (currentvalue.equalsIgnoreCase(value));
	 * 
	 * /* if (currentvalue.equalsIgnoreCase(value)) {
	 * System.out.println("value matches"); } else {
	 * System.out.println("value didn't matches"); String val = value; WebElement
	 * element = idelement; // driver.findElement(By.id(xpath)); element.clear();
	 * element.sendKeys(val); Thread.sleep(1000);
	 * 
	 * for (int i = 0; i < val.length(); i++) { char c = val.charAt(i); String s =
	 * new StringBuilder().append(c).toString(); element.sendKeys(s);
	 * Thread.sleep(100); }
	 * 
	 * }
	 */
//	}

	/*
	 * public boolean retryingFindClick(WebElement webElement) throws Exception {
	 * boolean result = false; int attempts = 0; while (attempts < 2) { try {
	 * webElement.click(); Thread.sleep(1000); result = true; break; } catch
	 * (StaleElementReferenceException e) { } attempts++; } return result; }
	 */

}
