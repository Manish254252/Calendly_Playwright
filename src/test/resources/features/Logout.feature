Feature: Logout Functionality

  Scenario: verify user can logout

    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user clicks on profile icon
    And clicks on profile link
    Then verify profile page is displayed
    When user clicks on logout link
    Then verify is on landing page