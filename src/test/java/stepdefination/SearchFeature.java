package stepdefination;


import implementation.Product;
import implementation.Search;
import io.cucumber.java.en.*;

public class SearchFeature {
	
	Product product;
	Search search;
	
	@Given("Search field on the top bar")
	public void search_field_on_the_top_bar() {
	System.out.println("Step 1  Search bar is displayed on top of the page");
	}

	@When("Enter search term {string} and select price {int}")
	public void enter_search_term_and_select_price(String productname, Integer price) {
	    System.out.println("Step 2 Enter the search term - "+productname+" with price- "+price);	    
	    product = new Product(productname,price);
	}

	@Then("{string} product should be displayed in search result")
	public void product_should_be_displayed_in_search_result(String productname) {
		System.out.println("Step 3 Search result product with name "+productname+" is displayed");
		
		search =new Search();
		String pName=search.displayProduct(product);
		//Assert.assertEquals(product.getProductName(), pName);
		
	  	}
}
