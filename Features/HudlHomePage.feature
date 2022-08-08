Feature: This feature file is to validate that user is able to launch the Hudl website and login link is present in home page

  @testHudls
  Scenario: Launch Hudl website in browser and verify that Login link is present in Home page
    Given I am on Hudl home page
    And I can see Login button is present on home page
    Then I close the browser