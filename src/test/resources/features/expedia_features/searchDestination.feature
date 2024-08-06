@expediaAirportSearch
Feature: User should be able to select origin and destination airports

  Scenario Outline: User should be able to select origin and destination airports

    Given user is on the Expedia Landing Page
    When user clicks on Flights
    And user enters "<origin>" by adding nearby airports and enters "<destination>" cities
    And user selects "09/01/2024" and "10/02/2024" dates
    And user clicks search button
    Then origin and destination details are same as entered in the main screen
    And user is able to see "Recommended departing flights" text


    Examples:

      | origin      | destination |
      | Houston     | Orlando     |
      | Los Angeles | New York    |

