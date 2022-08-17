Feature: This feature file is to validate features of SpaceX home page

  @tests
  Scenario: Data should load onto the page
    Given Data should load onto the page
    Then A screen will appear with a list of SpaceX API results

  @test
  Scenario: Filter by year
    Given Selecting filter
    When Setting filter by year to 2015
    Then Return a list of only launches in 2015

  @tests
  Scenario: Verify that the Sort button value changes from ascending to descending by clicking and vice versa
    Given I am on home page
    And I see default sort button value is Ascending
    When I click the sort button
    Then value of sort button change to Descending
    And I click the sort button
    Then sort button value change to ascending

  @tests
  Scenario: Verify that values of Filter by year drop down and the drop down values are sorted
    Given I am on home page
    And I verify the filter by year drop down values
    And I also verify that drop values are sorted