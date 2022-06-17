Feature: Feedback Form Verification

  Background:
    Given I am on www.hotels.com
    When I click on sign in field
    And I click on feedback link

  @Sprint-1 @TC-24
  Scenario: Verify empty form submission gives error
    And I click on feedback submit button
    Then I verify empty form submission error is displayed
    And I verify red dotted border around star rating section
    And I quit browser

  @Sprint-2 @TC-25
  Scenario: Verify completed feedback form submission
    And I select 1 star rating
    And I enter Some Random Text in comments field
    And I select Unsure as answer in dropdown question
    And I select Yes as answer in prior booking question
    And I select No as answer in were you successful question
    And I enter johndoe@qaemail.com in email input field
    And I click on feedback submit button
    Then I verify form is submitted
    And I quit browser