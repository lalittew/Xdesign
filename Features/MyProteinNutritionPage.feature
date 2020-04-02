Feature: This feature file is validate the Nutrition Page

  @test
  Scenario: Verify that the user is on Nutrition page
    Given I am on My Protein Home page
    When I click Nutrition from the Menu
    Then I am on Nutrition page