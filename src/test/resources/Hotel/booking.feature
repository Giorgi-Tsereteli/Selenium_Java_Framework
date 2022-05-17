Feature: Booking automation

  Scenario: Verify destination error displayed if search with no destination
    Given I am on www.hotels.com
    When I click destination search button
    Then I verify search error is displayed


  Scenario: Verify enter-children's age error
    Given I am on www.hotels.com
    When I click travelers field
      And I add child travelers
    Then I verify age error is displayed
    When I select children's age
      And I verify age error is not displayed


  Scenario: Verify numbers of travelers before and after search is same
    Given I am on www.hotels.com
    When I click search bar
      And I Type Seatt
      And I click on Seattle suggestion
      And I click on Check In field
      And I select 17 August 2022
      And I click calendar done button
      And I click travelers field
      And I add child travelers
      And I select children's age
      And I click travelers done button
      And I click destination search button
    Then I verify traveler count is same as before