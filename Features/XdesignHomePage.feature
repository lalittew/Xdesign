Feature: This feature file is to validate features of SpaceX home page

  @test
  Scenario: Data should load onto the page
    Given Data should load onto the page
    Then A screen will appear with a list of SpaceX API results

  @test
  Scenario: Filter by year
    Given Selecting filter
    When Setting filter by year to 2015
    Then Return a list of only launches in 2015

  @test
  Scenario: Order should be done alphabetically
    Given No year filter is on
    When Ordering is done 'descending'
    Then Items should be ordered alphabetically