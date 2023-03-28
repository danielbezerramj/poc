Feature: Login
  Scenario: Invalid Login
    Given I am on the login page
    When I enter my email and password invalid
    And I click the login button
    Then I should be redirected to the dashboard