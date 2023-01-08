@CheckOut
  Feature: Feature check out
    description feature

#  Scenario: Normal login
#    Given user open the website sauce demo
#    When user input "standard_user" as userName and input "secret_sauce" as password
#    And user pick item Sauce Labs Backpack

  Scenario: Filter Product and Checkout
    Given user open the website sauce demo
    When user input "standard_user" as userName and input "secret_sauce" as password, character will be inputed
    Then user click login button
    When user select "Name (Z to A)" to FILTER PRODUCT item, product will be sorted by selected input
    And user pick item "Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)"
    When user has picked the products item, click Shopping Cart
    Then user will be redirected to page titled "YOUR CART"
    Then verify picked item "Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)"
    When user click remove item "Test.allTheThings() T-Shirt (Red)"
    Then verify picked item "Sauce Labs Onesie"
    When user click Checkout Button
    Then user will be redirected to page titled "CHECKOUT: YOUR INFORMATION"
    When user need to input Information First Name/Last Name/Postal Code :"firstName"/"lastName"/"postalCode"
    When user click Continue Button
    Then user will be redirected to page titled "CHECKOUT: OVERVIEW"
    Then verify product Name "Sauce Labs Onesie"
    Then verify component summary cost
    When user click Finish Button
    Then user will be redirected to page titled "CHECKOUT: COMPLETE!"
