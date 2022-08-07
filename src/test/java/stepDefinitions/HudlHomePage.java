package stepDefinitions;

import browserFactory.DriverBaseClass;
import functionFile.GeneralFunctions;
import functionFile.HomePageFunction;
import functionFile.LoginPageFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HudlHomePage extends DriverBaseClass {

    private String homePageTitle = "Performance analysis tools for sports teams and athletes at every level.";
    private String homePageUrl = "https://www.hudl.com/en_gb/";

    WebDriver driver = DriverBaseClass.startBrowser();
    HomePageFunction homePageFunction= PageFactory.initElements(driver,HomePageFunction.class);
    LoginPageFunction loginPageFunction= PageFactory.initElements(driver,LoginPageFunction.class);
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);

    @Given("I am on Hudl home page")
    public void i_am_on_Hudl_home_page() {
        generalFunctions.verifyPageTitle(homePageTitle);
        generalFunctions.verifyPageUrl(homePageUrl);
    }

    @Given("I can see Login button is present on home page")
    public void i_can_see_Login_button_is_present_on_home_page() {
        generalFunctions.checkElementPresent(homePageFunction.loginButtonHomePage);
    }

    @When("I click Login button on Home page")
    public void i_click_Login_button_on_Home_page() throws InterruptedException {
        generalFunctions.click(homePageFunction.loginButtonHomePage);
        Thread.sleep(1000);
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        generalFunctions.quitBrowser();
    }

}
