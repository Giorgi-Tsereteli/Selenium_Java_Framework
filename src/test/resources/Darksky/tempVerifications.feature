Feature: Verify Darksky Temp Values

  Scenario: Verify the current date is highlighted in Time Machine's calendar
    Given I am on www.darksky.com
    When  I click on Time Machine button
    Then I verify that date in Time Machine is correct

  Scenario: Verify same values are displayed in the Today's data
    Given I am on www.darksky.com
    When I expand today details
    Then I verify displayed temp is equal to temp in details