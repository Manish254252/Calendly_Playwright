Feature: Create Routing Functionality

  Scenario: verify user can create a routing
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user clicks on routing link
    Then verify routing page is displayed
    When user clicks on new routing form button
    And clicks on create new form
    Then verify routing popup is displayed
    When user enters routing form name as "routing.name"
    And clicks on create form
    And user clicks on Add a question
    And selects name and perform click
    And user writes a question for name "name.question"
    And clicks on save button
    And user clicks on Add a question
    And selects email and perform click
    And user writes a question for email "email.question"
    And clicks on save button
    When user clicks on next button of routing page
    And clicks on publish button
    Then verify copy routing link popup is displayed
