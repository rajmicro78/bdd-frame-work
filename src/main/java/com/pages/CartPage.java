package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage {
	private WebDriver driver;
	@FindBy(xpath = "//a[contains(@href,'cart')]")
	private WebElement cart;

	@FindBy(xpath = "//div[contains(@class,'notEmptyCart cart-checkout-cta')]/a")
	private WebElement cartCheckout;

	@FindBy(xpath = "//div[contains(@class,'notEmptyCart top-checkout-button')]/a")
	private List<WebElement> cartofferCheckout;
	
	@FindBy(xpath="(//div[@id='giftcards-content']//table/tbody/tr/td)[1]")
	private WebElement GiftCertificate;
	
	@FindBy(id="showGiftCard")
	private WebElement showGiftCardtextbox;
	@FindBy(id="input-giftcard-number")
	private WebElement inputGC;
	@FindBy(id="btnAddCoupon")
	private WebElement btnApplyGC;

	// Page constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);

	}

	public void clickCart() throws Exception {
		retryingFindClick(cart);
//  Retry Click		cart.click();
	}

	public void clickcartCheckout() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(100,400)");
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// js.executeScript("arguments[0].scrollIntoView(true);", cartCheckout);

		Thread.sleep(1000);

		Actions actions = new Actions(driver);
		actions.moveToElement(cartCheckout).click().build().perform();
		Thread.sleep(5000);
		// cartCheckout.click();
	}
	public String readGiftCertificate() {
		String GiftC=	GiftCertificate.getText();
		
		return GiftC;
		}
	
	public void clickshowGClink() throws Exception {
		retryingFindClick(showGiftCardtextbox);
//Retry Click		showGiftCardtextbox.click();
	}
	
	public void enterGC(String GC) throws Exception {
		Thread.sleep(1000);

		inputGC.sendKeys(GC);
		Thread.sleep(1000);

	}
	public void applyGC() throws Exception {
		retryingFindClick(btnApplyGC);
//Retry Click		btnApplyGC.click();
	}
	
	
	public void offercheck() throws Exception {
		String cURL = driver.getCurrentUrl();
		if (cURL.contains("klarna")) {
			System.out.println("now on checkout page");
		} else {

			System.out.println("cartofferCheckout-" + cartofferCheckout.size());
			boolean offerbtn = cartofferCheckout.size() != 0;
			// boolean offerbtn =
			// driver.findElements(By.xpath("//div[contains(@class,'notEmptyCart
			// top-checkout-button')]/a")).size()!=0;
			if (offerbtn) {
				Thread.sleep(3000);

		//		retryingFindClick(cartofferCheckout.get(0));
				cartofferCheckout.get(0).click();
				Thread.sleep(1000);
			}
		}
	}
	
	
	public boolean retryingFindClick(WebElement webElement) throws Exception {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
            	webElement.click();
				Thread.sleep(1000);

                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
}
}
