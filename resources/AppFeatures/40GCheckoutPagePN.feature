Feature: Guest Checkout With Pay Now payment
@Run
  Scenario Outline: Guest user buy product with Pay now card
    Given Visit WebSite "<Website>"
    When Click on top menu
    And Click on View All link under the Menu
    And Verify product list page is displayed
    And Randomly select product and click on product
    And Select Product Quantity
    And Click on add to Cart button
    And Click cart icon on top
    And Click on checkout button
    And Enter the customer payment details "<FirstName>","<LastName>","<Address>","<Zipcode>","<Mobile>" and "<identitynumber>"
    And Select the shipping method
    And Select the terms and condition
    And Enter the Pay now card payment detail
    Then Order created successfully and order  id displayed
    
    
   Examples: 
      | Website         | FirstName     | LastName | Address                | Zipcode | Mobile     | identitynumber |
      | Blivakker.no    | Testperson-no | Approved | Sæffleberggate 56      |    0563 |   40123456 |    01087000571 |
      | Netthandelen.no | Testperson-no | Approved | Sæffleberggate 56      |    0563 |   40123456 |    01087000571 |
      | Cocopanda.fi    | Testperson-fi | Approved | Kiväärikatu 10         |   28100 | 0401234567 | 190122-829F    |
   