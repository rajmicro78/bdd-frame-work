package com.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaymentPage {
	private WebDriver driver;
	@FindBy(xpath = "//div[contains(@id,'credit_card__container')]/label/input")
	private WebElement creditorDebitcard;
	@FindBy(xpath = "//input[contains(@id,'-pay_later')]")
	private WebElement paylaterid;
	@FindBy(xpath = "//button[contains(@data-cid,'button.buy_button')]/div/div[1]")
	private WebElement checkoutBuy;
	@FindBy(xpath = "//div[contains(@id,'pay_later__container')]/label/input")
	private WebElement Klarnapaylater;
	@FindBy(xpath = "//input[@id='cardNumber']")
	private WebElement cardNumber;
	@FindBy(id = "expire")
	private WebElement expire;
	@FindBy(id = "securityCode")
	private WebElement securityCode;
	@FindBy(xpath = "//div[@class='credit-card-pgw-iframe-wrapper']/iframe | //div[@data-cid='granular-category-content']/iframe")
	private WebElement creditcardframe;
	@FindBy(xpath = "//iframe[contains(@id,'pgw-iframe-')]")
	private WebElement iframe1;
	@FindBy(xpath = "(//iframe[contains(@id,'pgw-iframe-')])[2] | //iframe[@id='alps-card__card-wrapper']")
	private WebElement iframe2;
	@FindBy(xpath = "//div[contains(@id,'pay_now__container')]/label/input")
	private WebElement Klarnapaynow;
	@FindBy(xpath = "//div[@id='payment-selector-klarna_category__container']/label/input")
	private WebElement Klarnapaynowcpse;
	@FindBy(xpath = "//input[@id='nin' or @id='dob']")
	private WebElement securityNumber;
	@FindBy(id = "klarna-checkout-iframe")
	private WebElement klarnaiframe;
	@FindBy(xpath = "//h1[@data-cid=\"shopping-cart-amount\"]")
	private WebElement cartvalue;
	// @FindBy(xpath = "(//button[contains(@id,'continue')]/div/div)[2]")
	@FindBy(xpath = "(//div[@id='supplement_nin_dialog__bottom']//button/div/div)[1] | (//div[@id='supplement_dob_dialog__bottom']//button/div/div)[1]")
	private WebElement securityenter;
	@FindBy(xpath = "//div[@class='island-list']//a/strong")
	private WebElement orderNum;

	static String securitynumber;
	private String creditcardNumber = "4687388888888881";
	private static String paynowcard = "4111111111111111";
	private static String cardExpiry = "12/25";
	private static String cardCVV = "467";
	HomePage hp = new HomePage(driver);
	CheckOutPage CoP = new CheckOutPage(driver);

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void creditDebitCard(String sitecode) throws Exception {
		String cartamount = cartvalue.getText();

		String intValue = cartamount.replaceAll("[^0-9]", "");
		System.out.println("intValue" + intValue);
		if (Integer.parseInt(intValue) != 0) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);

			js.executeScript("arguments[0].scrollIntoView(true);", creditorDebitcard);
			Thread.sleep(1000);
			retryingFindClick(creditorDebitcard);
//Retry CLick			creditorDebitcard.click();
			Thread.sleep(1000);
			creditorDebitcard.sendKeys(Keys.TAB);
			String iframeattribute = creditcardframe.getAttribute("id");
			if (iframeattribute.contains("credit_card") || sitecode.equalsIgnoreCase("Cocopanda.se")) {
				driver.switchTo().frame(iframe1);
			} else {
				driver.switchTo().frame(iframe2);
			}
			Thread.sleep(2000);
			int x = cardNumber.getLocation().getX();
			int y = cardNumber.getLocation().getY();
			JavascriptExecutor jaas = (JavascriptExecutor) driver;
			jaas.executeScript("window.scrollBy(" + x + ", " + y + ")");
			Thread.sleep(1000);
			cardNumber.sendKeys(creditcardNumber);
			expire.sendKeys(cardExpiry);
			securityCode.sendKeys(cardCVV);
			Thread.sleep(1000);
			if (sitecode.equalsIgnoreCase("Cocopanda.dk")) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(klarnaiframe);
				retryingFindClick(checkoutBuy);
//REtry Click				checkoutBuy.click();
				securityNumberPoP(sitecode);
			} else {
				securityCode.sendKeys(Keys.ENTER);
			}
			Thread.sleep(5000);
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			js.executeScript("arguments[0].scrollIntoView(true);", checkoutBuy);
			Thread.sleep(1000);
			retryingFindClick(checkoutBuy);
//REtry CLick			checkoutBuy.click();
		//	Thread.sleep(1000);

		}
		securityNumberPoP(sitecode);

	}

	public void klarnaPaynow(String sitecode) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		if (sitecode.equalsIgnoreCase("Cocopanda.se")) {
			js.executeScript("arguments[0].scrollIntoView(true);", Klarnapaynowcpse);
			retryingFindClick(Klarnapaynowcpse);
//REtry Click			Klarnapaynowcpse.click();
			Thread.sleep(1000);
			Klarnapaynowcpse.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[contains(@id,'paynow')])[1]")).click();

		} else {
			js.executeScript("arguments[0].scrollIntoView(true);", Klarnapaynow);
			retryingFindClick(Klarnapaynow);
//Retry Click			Klarnapaynow.click();
			Thread.sleep(1000);

			Klarnapaynow.sendKeys(Keys.TAB);
			Thread.sleep(1000);
			String iframeattribute = creditcardframe.getAttribute("id");
			if (iframeattribute.contains("paynow")) {
				driver.switchTo().frame(iframe1);
			} else {
				driver.switchTo().frame(iframe2);

			}
		}
		Thread.sleep(2000);
		cardNumber.sendKeys(paynowcard);
		expire.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		expire.sendKeys(cardExpiry);
		securityCode.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		securityCode.sendKeys(cardCVV);
		securityCode.sendKeys(Keys.ENTER);

//		  do { securityCode.sendKeys(Keys.ENTER); Thread.sleep(3000);
//		  driver.switchTo().defaultContent(); Thread.sleep(2000); boolean iframecheck =
//		  driver.findElements(By.xpath("//iframe[@id='klarna-fullscreen-iframe']")).
//		  size() > 0; System.out.println("10-" + iframecheck); if (iframecheck) {
//		  driver.switchTo().frame("klarna-fullscreen-iframe"); } else { boolean
//		  ordercreated =
//		  driver.findElements(By.xpath("//div[@class='island-list']//a/strong"))
//		  .size() != 0; if (ordercreated) { break; 
//		  } } } while(!(driver.findElements(By.xpath("//input[@id='nin']|//input[@id='dob']")).size() != 0));
		// boolean ordercreated = orderNum.isDisplayed();
		// if (ordercreated) { Thread.sleep(1000);
		// } else {
		securityNumberPoP(sitecode);
		// }

	}

	public void securityNumberPoP(String sitecode) throws Exception {
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		boolean ordercreated =  driver.findElements(By.xpath("//div[@class='island-list']//a/strong")).size()!=0;
		if (ordercreated) {	
			System.out.println("Order created");
		//	break;
			}
		else {
		
		driver.switchTo().frame("klarna-fullscreen-iframe");
		if (driver.findElements(By.xpath("//input[@id='nin' or @id='dob']")).size() != 0) {
			klarnasecurity(sitecode);
			securityNumber.sendKeys(securitynumber);
			// CoP.securityNumber(securitynumber);
			retryingFindClick(securityenter);
//REtry Click			securityenter.click();
			Thread.sleep(1000);
		}
		Thread.sleep(000);
		driver.switchTo().defaultContent();}
	}

	public void klarnasecurity(String sitecode) {
		if (sitecode.equalsIgnoreCase("BliVakker.no") || sitecode.equalsIgnoreCase("Netthandelen.no")) {
			securitynumber = "01087000571";
		} else if (sitecode.equalsIgnoreCase("Cocopanda.nl")) {
			securitynumber = "10071970";
		} else if (sitecode.equalsIgnoreCase("Cocopanda.at")) {
			securitynumber = "14041960";
		} else if (sitecode.equalsIgnoreCase("Cocopanda.dk")) {
			securitynumber = "0801363945";
		} else if (sitecode.equalsIgnoreCase("Cocopanda.fi")) {
			securitynumber = "190122-829F";
		} else if (sitecode.equalsIgnoreCase("Cocopanda.de")) {
			securitynumber = "07071960";
		} else if (sitecode.equalsIgnoreCase("Cocopanda.se")) {
			securitynumber = "410321-9202";
		}
	}

	public void klarnaPayLater(String sitecode) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", paylaterid);
		retryingFindClick(paylaterid);
// REtry CLick		paylaterid.click();
		Thread.sleep(1000);
		retryingFindClick(checkoutBuy);
//REtry Click		checkoutBuy.click();
		securityNumberPoP(sitecode);
	}

	public void orderNumber() throws Exception {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		boolean ordervisible = orderNum.isDisplayed();
		if (ordervisible) {
			String OrderNumber = orderNum.getText();
			System.out.println(OrderNumber);
			// hp.clicktopLogo();
			//Thread.sleep(1000);

		} else {

			hp.clicktopLogo();
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
