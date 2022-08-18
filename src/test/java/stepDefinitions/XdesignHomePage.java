package stepDefinitions;

import browserFactory.DriverBaseClass;
import enums.SortingOrder;
import functionFile.GeneralFunctions;
import functionFile.XdesignHomePageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class XdesignHomePage extends DriverBaseClass {

    WebDriver driver = DriverBaseClass.startBrowser();
    XdesignHomePageFunctions xdesignHomePageFunctions = PageFactory.initElements(driver,XdesignHomePageFunctions.class);
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);

    @Given("Data should load onto the page")
    public void data_should_load_onto_the_page() {
        //Verify the UI of the page by checking the presence of elements on page
        generalFunctions.verifyPageUrl(DriverBaseClass.homePageUrl);
        generalFunctions.checkElementAttribute(xdesignHomePageFunctions.SpaceXLogo, "src", xdesignHomePageFunctions.homePageLogoSource);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.SpaceXLogo);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.LoadingListText);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.LogoLaunchesText);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.ReloadDataButton);
    }

    @Then("A screen will appear with a list of SpaceX API results")
    public void a_screen_will_appear_with_a_list_of_SpaceX_API_results() throws InterruptedException {
        //Added fluent wait for that Filter drop down appear on screen
        generalFunctions.fluentWait(xdesignHomePageFunctions.FilterByYearDropDown);

        //Verify that the list of shuttle loads and displayed
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.SortAscendingButton);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.ShuttleList);
        generalFunctions.checkElementAttribute(xdesignHomePageFunctions.LaunchShuttleLogo, "src", xdesignHomePageFunctions.launchShuttleLogoSource);

        //Check list is not empty
        generalFunctions.checkListNotEmpty(xdesignHomePageFunctions.listOfShuttlesDisplayed);
    }

    @Given("Selecting filter")
    public void selecting_filter() throws InterruptedException {
        //Added fluent wait for that Filter drop down appear on screen
        generalFunctions.fluentWait(xdesignHomePageFunctions.FilterByYearDropDown);

        //Click the filter button
        generalFunctions.click(xdesignHomePageFunctions.FilterByYearDropDown);
    }

    @When("Setting filter by year to {int}")
    public void setting_filter_by_year_to(Integer int1) throws InterruptedException {
        String year = Integer.toString(int1);

        //Selecting the Year drop down with value as mentioned in Scenario
        generalFunctions.selectDropOptionDownByValue(xdesignHomePageFunctions.FilterByYearDropDown, year);
    }

    @Then("Return a list of only launches in {int}")
    public void return_a_list_of_only_launches_in(Integer int1) {
        String yearToCheck = Integer.toString(int1);

        //Verify that after applying filter for year, the list displayed is from the same year as expected
        generalFunctions.verifyFilteredListDisplayingCorrectYear(xdesignHomePageFunctions.launchItemDates, yearToCheck);
    }

    @Given("No year filter is on")
    public void no_year_filter_is_on() throws InterruptedException {
        //Added fluent wait for that Filter drop down appear on screen
        generalFunctions.fluentWait(xdesignHomePageFunctions.FilterByYearDropDown);

        //Verify that default value of Filter drop down is selected when user lands on home page
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.FilterByYearDropDown);
    }

    @When("Ordering is done {string}")
    public void ordering_is_done(String string) {
        //Clicking Sort button
        generalFunctions.click(xdesignHomePageFunctions.SortButton);

        //To verify that text of button changes to Sort Descending
        generalFunctions.checkElementText(xdesignHomePageFunctions.SortButton,xdesignHomePageFunctions.sortDescendingButtonText);
    }

    @Then("Items should be ordered alphabetically")
    public void items_should_be_ordered_alphabetically() {
        //Verify that list of shuttles displayed in descending order
        xdesignHomePageFunctions.checkIfListSortedDescendingOrder(xdesignHomePageFunctions.launchItemNumbers);
        xdesignHomePageFunctions.checkIfListSortingOrder(xdesignHomePageFunctions.launchItemNumbers, SortingOrder.DESCENDING);
    }
}