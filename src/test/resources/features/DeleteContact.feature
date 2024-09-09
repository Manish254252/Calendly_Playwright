Feature: Testing of DeleteContact feature
  Scenario: Deleting a contact
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    Given user navigates to the Add to Contacts section
    When user clicks on remove button of "contact.firstname" with email as "contact.email"
    Then Verify contact with name "contact.firstname" and  email as "contact.email" is removed