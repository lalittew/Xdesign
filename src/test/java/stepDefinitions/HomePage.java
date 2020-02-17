package stepDefinitions;

import browserFactory.DriverBaseClass;
import functionFile.GeneralFunctions;
import functionFile.HomePageFunction;
import functionFile.LoginPageFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class HomePage extends DriverBaseClass {
    private String homePageTitle = "MYPROTEIN™ | Sports Nutrition & Clothing | UK's No. 1 Brand";
    private String loginPageTitle = "Account Login | MYPROTEIN™";

    WebDriver driver = DriverBaseClass.startBrowser();
    HomePageFunction homePageFunction= PageFactory.initElements(driver,HomePageFunction.class);
    LoginPageFunction loginPageFunction= PageFactory.initElements(driver,LoginPageFunction.class);
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);


    @Given("I am on My Protein Home page")
    public void i_am_on_My_Protein_Home_page() {
        generalFunctions.verifyPageTitle(homePageTitle);
    }

    @When("I click Account link")
    public void i_click_Account_link() {
        generalFunctions.click(homePageFunction.accountOption);
    }

    @Then("I am on Login page")
    public void i_am_on_Login_page() {
        generalFunctions.verifyPageTitle(loginPageTitle);
    }

    @Then("I can see text boxes for entering Email and Password")
    public void i_can_see_text_boxes_for_entering_Email_and_Password() {
        generalFunctions.checkElementPresent(loginPageFunction.emailAddressTextBox);
        generalFunctions.checkElementPresent(loginPageFunction.passwordTextBox);
    }

    @Then("I enter wrong {string} and {string} and click Login")
    public void i_enter_wrong_and_and_click_Login(String username, String password) throws InterruptedException {
        generalFunctions.enterText(loginPageFunction.emailAddressTextBox,username);
        generalFunctions.enterText(loginPageFunction.passwordTextBox,password);
        generalFunctions.click(loginPageFunction.signInButton);
    }

    @Then("I can see error message")
    public void i_can_see_error_message() {
        generalFunctions.checkElementPresent(loginPageFunction.invalidLoginError);
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        generalFunctions.quitBrowser();
    }
}
