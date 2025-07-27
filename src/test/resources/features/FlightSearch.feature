Feature: Flight Search on Booking.com

  @Test
  Scenario: Search for one-way flights
    Given I open the Booking flight page
    When I select one-way trip
    And I enter random From and To cities
    And I select a departure date and passengers
    And I click the Search button
    Then I should see the number of flights available
