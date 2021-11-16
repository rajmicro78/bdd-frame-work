Feature: Registered user Apply Gift Certificate and create order with Credit card payment
@Run
  Scenario Outline: Read GC and apply on cart page create order with credit card payment
    Given Visit WebSite "<Website>"
    And Click on Min Side Icon
    And Enter the Email-address
    And Click on checkemail Button
    And Enter the Password "BN12345"
    And Click on login Button
    And Click on my GiftCertificate tab
    And Read the Giftcertificate
    And Click on top menu
    When Click on View All link under the Menu
    And Verify product list page is displayed
    And Randomly select product and click on product
    And Select Product Quantity
    And Click on add to Cart button
    And Click cart icon on top
    And Apply Gift Certificate on Cart
    And Click on checkout button
    And Enter the customer payment details "<FirstName>","<LastName>","<Address>","<Zipcode>","<Mobile>" and "<identitynumber>"
 #   And Select the shipping method
    And Select the terms and condition
    And Enter the credit card payment detail
   Then Order created successfully and order  id displayed

  Examples: 
      | Website         | FirstName     | LastName | Address                | Zipcode | Mobile     | identitynumber |
      | Blivakker.no    | Testperson-no | Approved | Sæffleberggate 56      |    0563 |   40123456 |    01087000571 |
      | Cocopanda.nl    | Testperson-nl | Approved | Neherkade 1            | 2521VA  | 0612345678 |       10071970 |
      | Cocopanda.dk    | Testperson-dk | Approved | Sæffleberggate 56,1 mf |    6800 |   20123456 |     0801363945 |
      | Cocopanda.fi    | Testperson-fi | Approved | Kiväärikatu 10         |   28100 | 0401234567 | 190122-829F    |
      | Cocopanda.de    | Testperson-de | Approved | Hellersbergstraße 14   |   41460 |  522113356 |       07071960 |
      | Cocopanda.se    | Approved16    | Sweden16 | Ryggevägen 3           |   27393 | 0701234567 | 410321-9202    |
