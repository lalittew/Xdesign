Feature: Perform basic function on My Protein UK home page

@test
  Scenario: Open My Protein UK home page and check the title of page
    Given I am on My Protein Home page
    When I click Account link
    Then I am on Login page
    And I can see text boxes for entering Email and Password
    And I close the browser