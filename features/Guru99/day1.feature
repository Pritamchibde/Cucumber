Feature: Day1


@Ready
  Scenario: Verify that cost of product in list page and details page are equal
    Given I am logged in to "http://live.guru99.com"
    When I click on mobile menu
    And In the list view of all mobiles I read cost of Sony Xperia
    And I click on Sony Xperia phone
    And Read the value from detail view
    Then Verify both the values are equal
