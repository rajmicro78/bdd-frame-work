Feature: Regression cycle for Registration

  Scenario Outline: 
    Given Visit WebSite "<Website>"
    When Click on Min Side Icon
    And Enter the Email-address
    And Click on Registration button
    And Enter First Name "<Firstname>"
    And Enter Last Name "<Lastname>"
    And Enter Address "<Address>"
    And Enter PostNumber "<ZipCode>"
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
      | Website      | Firstname     | Lastname | Address           | Zipcode | MobileNumber |
      | Blivakker.no | Testperson-no | Approved | Sæffleberggate 56 |    0563 |     40123456 |
      |Netthandelen.no| Testperson-no | Approved | Sæffleberggate 56 |    0563 |     40123456 |
      |Cocopanda.nl		|Testperson-nl	|Approved		|Neherkade 1				|2521VA		|0612345678		|
      |Cocopanda.dk		|Testperson-dk	|Approved		|Sæffleberggate 56,1 mf|6800	|20123456			|
      |Cocopanda.fi		|Testperson-fi	|Approved		|Kiväärikatu 10					|28100	|0401234567	|
      |Cocopanda.de		|Testperson-de	|Approved		|Hellersbergstraße 14		|41460		|522113356|
      |Cocopanda.se		|Approved16			|Sweden16			|Ryggevägen 3						|27393|0701234567	|
      |Cocopanda.pl		|AutoTest				|Ertresvęg		|Neherkade 1				|70-001		|666555444	|