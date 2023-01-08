@Login
  Feature: Login
    as a user I want to login to website sauce demo

  Scenario: Normal login
    Given user open the website sauce demo
    When user input "standard_user" as userName and input "secret_sauce" as password, character will be inputed

#  Scenario: Invalid Login
#    Given user open the website sauce demo
#    When user input "dicky" as userName and input "123" as password
#    Then user see error "Username and password do not match any user in this service" on login page

  Scenario Outline: Invalid Login
    Given user open the website sauce demo
    When user input "<userName>" as userName and input "<password>" as password, character will be inputed
    Then user see error "<errorMessage>" on login page
    Examples:
      | userName | password | errorMessage                                                              |
      | dicky    | 123      | Epic sadface: Username and password do not match any user in this service |
      | Dicky    |          | Epic sadface: Password is required                                        |
      |          | 123      | Epic sadface: Username is required                                        |
