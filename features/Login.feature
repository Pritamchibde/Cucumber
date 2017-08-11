Feature: Login

  @new_test
  Scenario: Login to the application
    Given I am navigate to BrownTape site
    When I enter username
    And I enter password
    And Click on Sign in button
    Then User should be logged in

  @new_test
  Scenario: Search a string on google
    Given I navigate to google site
    When I ente string "Test Google" in search string
    Then Results should be displayed