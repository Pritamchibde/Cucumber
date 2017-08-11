Feature: TicketShala


  Scenario: Search for a Hotel
    Given I navigate to "https://www.ticketshala.com"
    When I click on Hotels
    And Select destination "Saint Martin"
    And Select future start date and end date
    And Select "2" rooms and "7" guests
    And Click on Search
#  8. Assert that total number of found result and printed result with label "Found Results :" must equal.
  #9. Store found all result title and price in array and print in testNG reort with respective title.