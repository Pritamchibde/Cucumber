Feature: Day2

Scenario: Verify item in mobile list can be sorted by name
  Given I am logged in to "http://live.guru99.com"
  Then Verify the title page is displayed as "This is demo site for"
  When I click on mobile menu
  Then Verify the title page is displayed as "Mobile"
  When I sort by name
  Then Verify products are sorted by name