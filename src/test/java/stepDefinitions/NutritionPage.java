package stepDefinitions;

import browserFactory.DriverBaseClass;
import functionFile.GeneralFunctions;
import functionFile.HomePageFunction;
import functionFile.LoginPageFunction;
import functionFile.NutritionPageFunction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class NutritionPage extends DriverBaseClass {
    HomePageFunction homePageFunction= PageFactory.initElements(driver,HomePageFunction.class);
    LoginPageFunction loginPageFunction= PageFactory.initElements(driver,LoginPageFunction.class);
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);
    NutritionPageFunction nutritionPageFunction = PageFactory.initElements(driver,NutritionPageFunction.class);

    @When("I click Nutrition from the Menu")
    public void i_click_Nutrition_from_the_Menu() {
        generalFunctions.click(nutritionPageFunction.nutritionMenuLink);
    }

    @Then("I am on Nutrition page")
    public void i_am_on_Nutrition_page() {
        generalFunctions.verifyPageTitle(nutritionPageFunction.nutritionPageTitle);
    }
}
