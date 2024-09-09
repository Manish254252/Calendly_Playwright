Feature: Testing Calendly

  Scenario: Testing open website
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage


  Scenario Outline: Testing open website with invalid credentials
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "<userEmail>"
    And user clicks on loginBtn
    Then user clicks on continue button
    And verify user is on not able to login
    Examples:
      | userEmail                  |
      | john.doe123@example.com    |
      | jane.smith456@testmail.com |
