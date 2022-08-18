Feature: This feature file is to validate features of SpaceX home page not mentioned in task

  @tests
  Scenario: Verify that the Sort button value changes from ascending to descending by clicking and vice versa
    Given I am on home page
    And I see default sort button value is Ascending
    When I click the sort button
    Then value of sort button change to Descending
    And I click the sort button
    Then sort button value change to ascending

  @test
  Scenario: Verify that values of Filter by year drop down and the drop down values are sorted
    Given I am on home page
    And I verify the filter by year drop down values
    And I also verify that drop values are sorted