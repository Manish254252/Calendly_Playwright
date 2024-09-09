Feature: Profile Picture upload

  Scenario: verify user can change the profile picture

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
    When user selects profile as "gorilla.profileImg"
    Then verify profile is changed
    When user clicks on save changes button
    Then verify changes have been saved