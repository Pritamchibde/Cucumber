Feature: Guru Test Cases

@Main
  Scenario: Day 1: Verify that cost of product in list page and details page are equal
    Given I am logged in to "http://live.guru99.com"
    When I click on mobile menu
    And In the list view of all mobiles I read cost of Sony Xperia
    And I click on Sony Xperia phone
    And Read the value from detail view
    Then Verify both the values are equal

@Main
  Scenario: Day 2: Verify item in mobile list can be sorted by name
    Given I am logged in to "http://live.guru99.com"
    Then Verify the title page is displayed as "This is demo site for"
    When I click on mobile menu
    Then Verify the title page is displayed as "Mobile"
    When I sort by name
    Then Verify products are sorted by name

@Main
  Scenario: Day 3: Verify that you cannot add more products in cart than the product available in store
    Given I am logged in to "http://live.guru99.com"
    When I click on mobile menu
    And I click on Add to cart for Sony Xperia
    And Change the Quantity to "10000"
    And Click on Update
    Then An Error message is displayed "The maximum quantity allowed for purchase is 500."
    When I click on Empty cart link
    Then "Shopping Cart is Empty" message should be displayed

@Ready
  Scenario: Day 4: Verify that you are able to compare two products
    Given I am logged in to "http://live.guru99.com"
    When I click on mobile menu
    And I click on Add to Compare button for 2 products
    And Click on Compare button
    Then A new pop up window should be displayed and 2 products should be displayed
    And Close the popup window


