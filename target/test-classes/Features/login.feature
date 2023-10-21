Feature: Login Page Sauce Demo

  Scenario: Success Login
    Given User in Login page
    When Input Username
    And Input Password
    And click Login button
    Then User in on dashboard page

  Scenario: Failed Login
    Given User in Login page
    When Input Username
    And Input invalid Password
    And click Login button
    Then User get error message

  Scenario: Success Logout
    Given User in Login page
    When Input Username
    And Input Password
    And click Login button
    Then User in on dashboard page
    And User click tab
    And User click Logout
    Then User in Login page

  Scenario: Succes Add Cart
    Given User in Login page
    When Input Username
    And Input Password
    And click Login button
    Then User in on dashboard page
    And click Add to cart
    Then product added to cart