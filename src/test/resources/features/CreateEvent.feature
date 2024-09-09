Feature: Event creation functionality

  Background: Login steps
    Given user opens website
    When user clicks on loginLink
    Then verify user on login page
    When user enters email as "userEmail"
    And user clicks on loginBtn
    And user enters password as "password"
    Then user clicks on continue button
    And verify user is on homepage
    When user clicks on new event type button
    Then verify new event type page is displayed

  Scenario: verify user can create one-on-one event
    When user choose the event type "eventType.one"
    And user clicks on next button
    And user enters event name "newEvent.name" and duration "newEvent.duration"
    And clicks on continue Button
    Then verify new Event is ready message is displayed
    When user clicks on done button
    Then verify event "newEvent.name" and "newEvent.duration" is listed on home page

  Scenario: verify user can create group event
    When user choose the event type "eventType.group"
    And user clicks on next button
    And user enters event name "newEvent.name" and duration "newEvent.duration"
    And clicks on continue Button
    Then verify new Event is ready message is displayed
    When user clicks on done button
    Then verify event "newEvent.name" and "newEvent.duration" is listed on home page

  Scenario: verify user can create collective event
    When user choose the event type "eventType.collective"
    And user clicks on invite users button
    And user enters invite emails "invite.email"
    And clicks on set roles
#    Then verify upgrade plan popUp is displayed
#    And clicks on assign event button
    And clicks on send invitation
    Then verify invitations are sent



