package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.qa.util.GenericFunction;

import implementation.CommonFunction;

public class LoginPage {

	private WebDriver driver;
	GenericFunction gf = new GenericFunction();

	// Page locators

	@FindBy(id = "Email")
	private WebElement emailID;
	@FindBy(xpath = "//a[contains(@href,'register')]")
	private WebElement registerBtn;
	@FindBy(xpath = "//div/button[contains(@class,'btnCheckEmail')]")
	private WebElement CheckEmailBtn;
	@FindBy(id = "Password")
	private WebElement password;
	@FindBy(id = "LoginButton")
	private WebElement loginBtn;
	@FindBy(xpath = "//div[@id='orders-content']/div/p/a")
	private WebElement sendactivation;
	@FindBy(xpath = "(//button[@class='button-large'])[1]")
	private List<WebElement> activationLink;
	@FindBy(id = "not-you")
	private List<WebElement> notyou;
	@FindBy(xpath = "//a[contains(@href,'giftcards')]")
	private WebElement gifttab;
	@FindBy(xpath = "//div[contains(@class,'style-light-background')]/div")
	private List<WebElement> clearEmailLink;
	
	CommonFunction cf = new CommonFunction();

	// Page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	// Page Actions
	public String getPageTile() {
		return driver.getTitle();
	}

	public void enterEmail() throws Exception {
		int totaldiv = clearEmailLink.size();
		if (totaldiv > 8) {
gf.retryingFindClick(notyou.get(0));
		//	notyou.get(0).click();
		}
		gf.TypeInField(emailID, cf.getemail());
//		emailID.clear();
//		emailID.sendKeys(cf.getemail());
	}

	public void clickregisterbtn() throws Exception {
		gf.retryingFindClick(registerBtn);
	//	registerBtn.click();
	}

	public void clickloginbtn() throws Exception {
	//	gf.retryingFindClick(loginBtn);
	//	Thread.sleep(1000);

		loginBtn.click();
		Thread.sleep(1000);
	}

	public void clickcheckemail() throws Exception  {
		gf.retryingFindClick(CheckEmailBtn);
	//	CheckEmailBtn.click();
		Thread.sleep(2000);
	}

	public void enterPassword(String pass) throws Exception {
	//	password.clear();
	//	password.sendKeys(pass);
		gf.TypeInField(password, pass);
	}

	public void sendactivation() throws Exception  {
	//	gf.retryingFindClick(sendactivation);
		sendactivation.click();
		Thread.sleep(2000);
	}

	public void clickactivationlink() throws Exception {
		boolean activaion = activationLink.size() != 0;
		if (activaion) {
		//	gf.retryingFindClick(activationLink.get(0));
			activationLink.get(0).click();
		}

	}

	public void clickGifttab() throws Exception {
		gf.retryingFindClick(gifttab);
		//gifttab.click();
	}
	
	
}
