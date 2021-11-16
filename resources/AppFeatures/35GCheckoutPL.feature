Feature: Guest user checkout with paylater card
@Run

 Scenario Outline: Guest user randomly select a product and do the checkout with pay later payment
    Given Visit WebSite "<Website>"
    And Click on top menu
    When Click on View All link under the Menu
    And Verify product list page is displayed
    And Randomly select product and click on product
    And Select Product Quantity
    And Click on add to Cart button
    And Click cart icon on top
    And Click on checkout button
    And Enter the customer payment details "<FirstName>","<LastName>","<Address>","<Zipcode>","<Mobile>" and "<identitynumber>"
    And Select the shipping method
    And Select the terms and condition
    And Select Pay Later payment
    Then Order created successfully and order  id displayed
   
      Examples: 
      | Website         | FirstName     | LastName | Address                | Zipcode | Mobile     | identitynumber |
      | Blivakker.no    | Testperson-no | Approved | Sæffleberggate 56      |    0563 |   40123456 |    01087000571 |
      | Netthandelen.no | Testperson-no | Approved | Sæffleberggate 56      |    0563 |   40123456 |    01087000571 |
      | Cocopanda.nl    | Testperson-nl | Approved | Neherkade 1            | 2521VA  | 0612345678 |       10071970 |
      | Cocopanda.fi    | Testperson-fi | Approved | Kiväärikatu 10         |   28100 | 0401234567 | 190122-829F    |
      | Cocopanda.de    | Testperson-de | Approved | Hellersbergstraße 14   |   41460 |  522113356 |       07071960 |
      
    