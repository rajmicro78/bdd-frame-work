Feature:
Scenario: Registered user search for Gift Certificate and do the checkout with credit card payment
    Given Visit WebSite "Blivakker.no"
    When You are on the Homepage
    And Click on Min Side Icon
    And Enter the Email-address
    And Click on checkemail Button
    And Enter the Password "BN12345"
    And Click on login Button
    When Search for "Gift Certificate"
    And Click on search button
    And Randomly select product and click on product
    And Select Product Quantity
    And Click on add to Cart button
    And Click cart icon on top
    And Click on checkout button
    And Enter the guest user detail
    And Select the shipping method
    And Select the terms and condition
    And Enter the credit card payment detail
    Then Order created successfully and order  id displayed

  Scenario: Registered user randomly select a product and do the checkout with klarna pay now payment
    Given Visit WebSite "Blivakker.no"
    And Click on Min Side Icon
    And Enter the Email-address
    And Click on checkemail Button
    And Enter the Password "BN12345"
    And Click on login Button
    And Click on top menu
    When Click on View All link under the Menu
    And Verify product list page is displayed
    And Randomly select product and click on product
    And Select Product Quantity
    And Click on add to Cart button
    And Click cart icon on top
    And Click on checkout button
    And Enter the guest user detail
    And Select the shipping method
    And Select the terms and condition
    And Enter the Pay now card payment detail
    Then Order created successfully and order  id displayed

  Scenario: Registered user randomly select a product and do the checkout with pay later payment
    Given Visit WebSite "Blivakker.no"
    And Click on Min Side Icon
    And Enter the Email-address
    And Click on checkemail Button
    And Enter the Password "BN12345"
    And Click on login Button
    And Click on top menu
    When Click on View All link under the Menu
    And Verify product list page is displayed
    And Randomly select product and click on product
    And Select Product Quantity
    And Click on add to Cart button
    And Click cart icon on top
    And Click on checkout button
    And Enter the guest user detail
    And Select the shipping method
    And Select the terms and condition
    And Select Pay Later payment
    Then Order created successfully and order  id displayed

  Scenario: Guest user randomly select a product do the checkout with credit card payment
    Given Visit WebSite "Blivakker.no"
    When Click on top menu
    And Click on View All link under the Menu
    And Verify product list page is displayed
    And Randomly select product and click on product
    And Select Product Quantity
    And Click on add to Cart button
    And Click cart icon on top
    And Click on checkout button
    And Enter the guest user detail
    And Select the shipping method
    And Select the terms and condition
    And Enter the credit card payment detail
    Then Order created successfully and order  id displayed
