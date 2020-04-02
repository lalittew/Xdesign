Feature: Perform basic function on My Protein UK home page

  @test
  Scenario: Open My Protein UK home page and check the title of page
    Given I am on My Protein Home page
    When I click Account link
    Then I am on Login page
    And I can see text boxes for entering Email and Password

  @test
  Scenario Outline: Check user gets error message on giving wrong username and password
    Given I am on My Protein Home page
    When I click Account link
    Then I am on Login page
    And I enter wrong "<username>" and "<password>" and click Login
    Then I can see error message

    Examples:
      |username|password|
      |lalit   |Abcd1234|
      |WrongUID|Abcd1234|