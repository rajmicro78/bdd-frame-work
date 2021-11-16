Feature: Regression cycle for Registration
@Runt
  Scenario Outline: Registration
    Given Visit WebSite "<Website>"
    When Click on Min Side Icon
    And Enter the Email-address
    And Click on Registration button
    And Enter the Email-address in Registration page
    And Enter First Name "<Firstname>"
    And Enter Last Name "<Lastname>"
    And Enter Address "<Address>"
    And Enter PostNumber "<Zipcode>"
    And Enter Mobile Number "<MobileNumber>"
    And Select Newsletter checkbox
    And Select SMS checkbox
    And Enter Password "BN12345"
    And Click on Submit Registration
    And Click on Min Side Icon
    And Enter the Email-address
    And Click on checkemail Button
    And Enter the Password "BN12345"
    And Click on login Button
    And Click on Send Activation Link
    And Get the Activation Link from database
    And Click on Activation Link

    Examples: 
      | Website         | Firstname | Lastname  | Address                   | Zipcode | MobileNumber |
      | Cocopanda.fi    | AutoTest  | Ertresvåg | c/o S. Voll, Liakroken 14 |   10120 |   0453181878 |