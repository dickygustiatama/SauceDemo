$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/CheckOut.feature");
formatter.feature({
  "line": 2,
  "name": "Feature check out",
  "description": "description feature",
  "id": "feature-check-out",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CheckOut"
    }
  ]
});
formatter.before({
  "duration": 3106925000,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 5,
      "value": "#  Scenario: Normal login"
    },
    {
      "line": 6,
      "value": "#    Given user open the website sauce demo"
    },
    {
      "line": 7,
      "value": "#    When user input \"standard_user\" as userName and input \"secret_sauce\" as password"
    },
    {
      "line": 8,
      "value": "#    And user pick item Sauce Labs Backpack"
    }
  ],
  "line": 10,
  "name": "Filter Product and Checkout",
  "description": "",
  "id": "feature-check-out;filter-product-and-checkout",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "user open the website sauce demo",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "user input \"standard_user\" as userName and input \"secret_sauce\" as password, character will be inputed",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user click login button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user select \"Name (Z to A)\" to FILTER PRODUCT item, product will be sorted by selected input",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user pick item \"Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "user has picked the products item, click Shopping Cart",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "user will be redirected to page titled \"YOUR CART\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "verify picked item \"Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)\"",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user click remove item \"Test.allTheThings() T-Shirt (Red)\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "verify picked item \"Sauce Labs Onesie\"",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "user click Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "user will be redirected to page titled \"CHECKOUT: YOUR INFORMATION\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "user need to input Information First Name/Last Name/Postal Code :\"firstName\"/\"lastName\"/\"postalCode\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "user click Continue Button",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "user will be redirected to page titled \"CHECKOUT: OVERVIEW\"",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "verify product Name \"Sauce Labs Onesie\"",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "verify component summary cost",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "user click Finish Button",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "user will be redirected to page titled \"CHECKOUT: COMPLETE!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.displayPage()"
});
formatter.result({
  "duration": 1244386700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 12
    },
    {
      "val": "secret_sauce",
      "offset": 50
    }
  ],
  "location": "LoginSteps.inputCredential(String,String)"
});
formatter.result({
  "duration": 166978400,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.clickLogin()"
});
formatter.result({
  "duration": 109314100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Name (Z to A)",
      "offset": 13
    }
  ],
  "location": "PurchaseSteps.filterProduct(String)"
});
formatter.result({
  "duration": 2120776000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)",
      "offset": 16
    }
  ],
  "location": "PurchaseSteps.addToCart(String)"
});
formatter.result({
  "duration": 7168876700,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseSteps.shoppingCart()"
});
formatter.result({
  "duration": 2058065900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "YOUR CART",
      "offset": 40
    }
  ],
  "location": "PurchaseSteps.redirectPage(String)"
});
formatter.result({
  "duration": 32769200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)",
      "offset": 20
    }
  ],
  "location": "PurchaseSteps.isDisplayItem(String)"
});
formatter.result({
  "duration": 2119685700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test.allTheThings() T-Shirt (Red)",
      "offset": 24
    }
  ],
  "location": "PurchaseSteps.removingAnItem(String)"
});
formatter.result({
  "duration": 1070022000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sauce Labs Onesie",
      "offset": 20
    }
  ],
  "location": "PurchaseSteps.isDisplayItem(String)"
});
formatter.result({
  "duration": 2063895800,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseSteps.checkoutCart()"
});
formatter.result({
  "duration": 1068112400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CHECKOUT: YOUR INFORMATION",
      "offset": 40
    }
  ],
  "location": "PurchaseSteps.redirectPage(String)"
});
formatter.result({
  "duration": 24025100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "firstName",
      "offset": 66
    },
    {
      "val": "lastName",
      "offset": 78
    },
    {
      "val": "postalCode",
      "offset": 89
    }
  ],
  "location": "PurchaseSteps.informationForm(String,String,String)"
});
formatter.result({
  "duration": 1269968800,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseSteps.submitInfoBuyer()"
});
formatter.result({
  "duration": 1086557700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CHECKOUT: OVERVIEW",
      "offset": 40
    }
  ],
  "location": "PurchaseSteps.redirectPage(String)"
});
formatter.result({
  "duration": 23707100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sauce Labs Onesie",
      "offset": 21
    }
  ],
  "location": "PurchaseSteps.verifyProductName(String)"
});
formatter.result({
  "duration": 21732300,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseSteps.isDisplaySummaryCost()"
});
formatter.result({
  "duration": 74196300,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseSteps.FinishCheckout()"
});
formatter.result({
  "duration": 1060954600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CHECKOUT: COMPLETE!",
      "offset": 40
    }
  ],
  "location": "PurchaseSteps.redirectPage(String)"
});
formatter.result({
  "duration": 25863000,
  "status": "passed"
});
formatter.after({
  "duration": 690861300,
  "status": "passed"
});
});