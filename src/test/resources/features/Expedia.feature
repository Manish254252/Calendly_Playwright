Feature: Booking flight with multiple passengers

  Scenario: checking flight price
    Given user is on homepage
    When  user clicks on flight section
    When user clicks on oneWay
    When  user selects source as "Hyderabad, India (HYD-Rajiv Gandhi Intl.)"
    And user selects destination as "Delhi, India (DEL-Indira Gandhi Intl.)"
    When  user selects date
    When  user selects number of adult travelers as "3"
    And user selects number of child travelers as "2"
    And user selects age for child travelers
    And   user clicks on search button
    Then verify search flight is listed


  Scenario: checking stays
    Given user is on homepage
    When  user selects location for stay as "Delhi"
    When  user selects date as "September 12" to "September 15"
    And   user clicks on search button
    Then verify stays are listed
