package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListPage {
	private WebDriver driver;
	@FindBy(id = "sortHidden")
	private WebElement sortDropdown;

	@FindBy(xpath = "(//div[@id='product-list-container']//div[@class='second-button']/button)")
	private List<WebElement> products;

	@FindBy(xpath = "(//div[@id='product-list-container']//div[@class='product-list']/a)")
	private List<WebElement> productImage;
@FindBy(xpath="//input[@data-specialfiltermenuitemid='6']/following-sibling::span")
private WebElement removeoutofStock;
@FindBy(xpath="//button[contains(@class,'filter-button')]")
private WebElement filterOption;
@FindBy(xpath="//button[contains(@class,'show-result')]")
private WebElement showresult;
	// Page constructor
	public ProductListPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void sortingProduct() throws Exception {
		Select sortingdrpdown = new Select(sortDropdown);
		sortingdrpdown.selectByValue("FinalSalesPriceInclTax|Ascending");
		Thread.sleep(1000);
	}

	public void clickProduct() throws Exception {
		filterOption.click();
		Thread.sleep(500);
		removeoutofStock.click();
		Thread.sleep(500);
		showresult.click();
		Thread.sleep(1000);
		
//		int i = 0;
//		do {
//			i++;
//			System.out.println("PA-"+products.get(i).getAttribute("class"));
//		} while (products.get(i).getAttribute("class").contains("sold-out-button"));
		productImage.get(1).click();

	}

}
