Feature: Facebook


  Scenario: Post a message on facebook
    Given I login to facebook account
    When I post a message on the wall
    Then The message should be displayed on the wall