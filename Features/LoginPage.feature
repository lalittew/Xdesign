Feature: This feature file is to validate the functionality of the login page

  @testHudls
  Scenario: Verify the UI of the Login page
    Given I am on Hudl home page
    When I click Login button on Home page
    Then I navigate to the Login page
    And I verify the UI of login page
    Then I close the browser

   @testHudls
   Scenario: Verify that clicking SignUp button in Login page will navigate user to SigningUp page
     Given I am on Hudl home page
     And I click Login button on Home page
     When I click Sign Up button on Login page
     Then I navigate to Sign Up page
     And I close the browser

   @testHudls
   Scenario: Verify that clicking Need help link on Login page navigates user to help page to get help on resetting password
     Given I am on Hudl home page
     And I click Login button on Home page
     When I click on Need help link on Login page
     Then I navigate to Help page to get help on password rest
     And I close the browser

  @testHudls
  Scenario: Verify that clicking Login with an organization button navigates user to organization login page
    Given I am on Hudl home page
    And I click Login button on Home page
    When I click on Login with an organization button on Login page
    Then I navigate to organization login page
    And I close the browser

  @testHudls
  Scenario: Verify that user is able to select/deselect Remember me check box by either clicking on Remember me text or check box
    Given I am on Hudl home page
    And I click Login button on Home page
    And I click Remember me text
    Then Remember me check box is selected
    And I click Remember me text
    Then Remember me check box is not selected
    When I click Remember me check box
    Then Remember me check box is selected
    When I click Remember me check box
    Then Remember me check box is not selected
    And I close the browser

  @testHudls
  Scenario: Verify that clicking back button on login page taking user back to home page
    Given I am on Hudl home page
    And I click Login button on Home page
    When I click back button on login page
    Then I am on Hudl home page
    And I close the browser

  @testHudls
  Scenario: Verify that when user lands on login screen from home page then focus of cursor is in Email text box
    Given I am on Hudl home page
    And I click Login button on Home page
    Then I confirm that focus is on email text box in login page
    And I close the browser

  @testHudls
  Scenario Outline: Verify that user is not able to login into Hudl on giving wrong email or password
    Given I am on Hudl home page
    And I click Login button on Home page
    When I enter invalid "<email>" and "<password>"
    And I click Login button on login screen
    Then I can see error message for wrong credentials

    Examples:
      |email             |password|
      |lalit@gmail.com   |Abcd1234|
      |lalitgmail.com    |Abcd1234|
      |lalit             |Abcd1234|
      |                  |Abcd1234|
      |lalit@gmail.com   |        |

  @testHudl
  Scenario: Verify that error message disappears when user tries to re-enter email or password
    Given I am on Hudl home page
    And I click Login button on Home page
    When I click Login button on login screen
    Then I can see error message for wrong credentials
    When I enter email
    Then I cannot see error message for wrong credentials
    And I click Login button on login screen
    Then I can see error message for wrong credentials
    When I enter password
    Then I cannot see error message for wrong credentials


#  Note: For the valid login credentials I needed to register into website which i was not compeletely sure how I can do, hence I have not written
#  exclusive test for the same but can be easily written using the test steps defined under test "Verify that user is not able to login into Hudl on giving wrong email or password"
#  and replacing the last step with correct page expection and also by replacing invalid credentials with valid credential