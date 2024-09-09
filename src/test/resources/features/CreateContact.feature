Feature: Testing of CreateContact feature
  Scenario: Creating a contact
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    Given user navigates to the Add to Contacts section
    When user clicks on the Add to Contacts icon
    Then verify the Add Contact form is displayed
    When user enters "contact.firstname" as the first name for the contact
    And user enters "contact.email" as the email for the contact
    And user selects "contact.timezone" as the timezone for the contact
    And user enters "contact.phoneNo" as the phone number for the contact
    And user clicks on the Save Contact button
    Then verify the contact "contact.email" is successfully added to the contact list
