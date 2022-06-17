Feature: Destination Booking Verification

  Background:
    Given I am on www.hotels.com

  Scenario: Verify search error is displayed if search with no destination
    When I click destination search button
    Then I verify search error is displayed
    And I quit browser

  Scenario: Verify enter-children's age error
    When I click travelers field
    And I add 2 child travelers
    And I click travelers done button
    Then I verify age error is displayed
    When I select first child's age as 7
    And I select second child's age as 2
    Then I verify age error is not displayed
    And I quit browser

  Scenario: Verify numbers of travelers before and after search is same
    When I click search bar
    And I type destination Seatt
    And I click on Seattle from destination suggestion
    And I click on Check In field
    And I select check in date 18 July 2022
    And I click calendar done button
    And I click travelers field
    And I add 2 child travelers
    And I select first child's age as 4
    And I select second child's age as 10
    And I click travelers done button
    And I click destination search button
    Then I verify traveler count after search is same as before
    And I quit browser

  @Sprint-1 @TC-19
  Scenario: Verify Tell us how we can improve our site is displayed on search page
    When I click search bar
    And I type destination bora
    And I click on Bora Bora from destination suggestion
    And I click on Check In field
    And I select check in date 1 August 2022
    And I select check out date 10 August 2022
    And I click calendar done button
    And I click destination search button
    Then I verify Tell us how we can improve our site is displayed
    And I verify share feedback button is displayed
    And I verify share feedback button is enabled
    And I quit browser

  @Sprint-1 @TC-18
  Scenario: Verify traveler count is correct
    When I click travelers field
    And I add 6 adult travelers
    And I add 2 child travelers
    And I select first child's age as 4
    And I select second child's age as Under 1
    And I click travelers done button
    Then I verify total count of travelers is correct
    And I quit browser

  @Sprint-1 @TC-17
  Scenario: Verify calendar past dates and back button are disabled
    When I click on Check In field
    Then I verify disabled day count is correct
    And I verify previous month button is disabled
    When I click calendar done button
    And I quit browser

  @Sprint-2 @TC-23
  Scenario: Verify search results using star rating and price
    When I click search bar
    And I type destination Manha
    And I click on Manhattan from destination suggestion
    And I click on Check In field
    And I select check in date 10 August 2022
    And I select check out date 15 August 2022
    And I click calendar done button
    And I click destination search button
    And I select 5 star rating filter
    And I sort the search results using price
    Then I verify star filter is correct
    And I verify price filter is correct
    And I quit browser