package stepDefinitions;

import browserFactory.DriverBaseClass;
import functionFile.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverBaseClass {

    LoginPageFunction loginPageFunction= PageFactory.initElements(driver,LoginPageFunction.class);
    SignUpPageFunction signUpPageFunction= PageFactory.initElements(driver,SignUpPageFunction.class);
    NeedHelpPageFunction needHelpPageFunction= PageFactory.initElements(driver,NeedHelpPageFunction.class);
    OrganizationLoginPageFunction organizationLoginPageFunction = PageFactory.initElements(driver,OrganizationLoginPageFunction.class);
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);

    @Then("I navigate to the Login page")
    public void i_navigate_to_the_Login_page() {
        generalFunctions.verifyPageTitle(loginPageFunction.loginPageTitle);
        generalFunctions.verifyPageUrl(loginPageFunction.loginPageUrl);
    }

    @Then("I verify the UI of login page")
    public void i_verify_the_UI_of_login_page() {
        generalFunctions.checkElementPresent(loginPageFunction.hudl);
        generalFunctions.checkElementPresent(loginPageFunction.backButton);
        generalFunctions.checkElementPresent(loginPageFunction.signUpLink);
        generalFunctions.checkElementPresent(loginPageFunction.emailTextBoxHint);
        generalFunctions.checkElementPresent(loginPageFunction.emailTextBox);
        generalFunctions.checkElementPresent(loginPageFunction.passwordTextBoxHint);
        generalFunctions.checkElementPresent(loginPageFunction.passwordTextBox);
        generalFunctions.checkElementPresent(loginPageFunction.loginButton);
        generalFunctions.checkElementPresent(loginPageFunction.rememberMeCheckBox);
        generalFunctions.checkElementPresent(loginPageFunction.rememberMeText);
        generalFunctions.checkElementPresent(loginPageFunction.needHelpLinkText);
        generalFunctions.checkElementPresent(loginPageFunction.dividerLine);
        generalFunctions.checkElementPresent(loginPageFunction.loginInWithOrganizationButton);
        generalFunctions.checkElementPresent(loginPageFunction.rememberMeCheckBoxNotSelected);
    }

    @When("I click Sign Up button on Login page")
    public void i_click_Sign_Up_button_on_Login_page() throws InterruptedException {
        generalFunctions.click(loginPageFunction.signUpLink);
        Thread.sleep(2000);
    }

    @Then("I navigate to Sign Up page")
    public void i_navigate_to_Sign_Up_page() {
        generalFunctions.verifyPageTitle(signUpPageFunction.signUpPageTitle);
        generalFunctions.verifyPageUrl(signUpPageFunction.signUpPageUrl);
    }

    @When("I click on Need help link on Login page")
    public void i_click_on_Need_help_link_on_Login_page() throws InterruptedException {
        generalFunctions.click(loginPageFunction.needHelpLinkText);
        Thread.sleep(2000);
    }

    @Then("I navigate to Help page to get help on password rest")
    public void i_navigate_to_Help_page_to_get_help_on_password_rest() {
        generalFunctions.verifyPageTitle(needHelpPageFunction.needHelpPageTitle);
        generalFunctions.verifyPageUrl(needHelpPageFunction.needHelpPageUrl);
        generalFunctions.checkElementPresent(needHelpPageFunction.loginHelpText);
    }

    @When("I click on Login with an organization button on Login page")
    public void i_click_on_Login_with_an_organization_button_on_Login_page() throws InterruptedException {
        generalFunctions.click(loginPageFunction.loginInWithOrganizationButton);
        Thread.sleep(2000);
    }

    @Then("I navigate to organization login page")
    public void i_navigate_to_organization_login_page() {
        generalFunctions.verifyPageTitle(organizationLoginPageFunction.organizationLoginPageTitle);
        generalFunctions.verifyPageUrl(organizationLoginPageFunction.organizationLoginPageUrl);
        generalFunctions.checkElementPresent(organizationLoginPageFunction.organizationLoginPageHeading);
    }

    @Given("I click Remember me text")
    public void i_click_Remember_me_text() throws InterruptedException {
        generalFunctions.click(loginPageFunction.rememberMeText);
        Thread.sleep(500);
    }

    @Then("Remember me check box is selected")
    public void remember_me_check_box_is_selected() throws InterruptedException {
        generalFunctions.checkElementPresent(loginPageFunction.rememberMeCheckBoxSelected);
    }

    @Then("Remember me check box is not selected")
    public void remember_me_check_box_is_not_selected() {
        generalFunctions.checkElementPresent(loginPageFunction.rememberMeCheckBoxNotSelected);
    }

    @When("I click Remember me check box")
    public void i_click_Remember_me_check_box() throws InterruptedException {
        generalFunctions.click(loginPageFunction.rememberMeCheckBox);
        Thread.sleep(500);
    }

    @When("I click back button on login page")
    public void i_click_back_button_on_login_page() {
        generalFunctions.click(loginPageFunction.backButton);
    }

    @Then("I confirm that focus is on email text box in login page")
    public void i_confirm_that_focus_is_on_email_text_box_in_login_page() {
        generalFunctions.verifyCursorFocus(loginPageFunction.emailTextBox);
    }

    @When("I enter invalid {string} and {string} and click Login button")
    public void i_enter_invalid_and_and_click_Login_button(String email, String password) throws InterruptedException {
        generalFunctions.enterText(loginPageFunction.emailTextBox,email);
        generalFunctions.enterText(loginPageFunction.passwordTextBox,password);
        generalFunctions.click(loginPageFunction.loginButton);
        Thread.sleep(500);
    }

    @Then("I can see error message for wrong credentials")
    public void i_can_see_error_message_for_wrong_credentials() {
        generalFunctions.checkElementPresent(loginPageFunction.loginErrorHelpIconImage);
        generalFunctions.checkElementPresent(loginPageFunction.invalidCredentialsError);
        generalFunctions.checkElementPresent(loginPageFunction.invalidCredentialNeedHelp);
    }

}
