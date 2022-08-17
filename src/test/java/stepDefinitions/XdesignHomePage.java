package stepDefinitions;

import browserFactory.DriverBaseClass;
import functionFile.GeneralFunctions;
import functionFile.XdesignHomePageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XdesignHomePage extends DriverBaseClass {

    WebDriver driver = DriverBaseClass.startBrowser();
    XdesignHomePageFunctions xdesignHomePageFunctions = PageFactory.initElements(driver,XdesignHomePageFunctions.class);
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);

    @Given("Data should load onto the page")
    public void data_should_load_onto_the_page() {
        generalFunctions.verifyPageUrl(DriverBaseClass.homePageUrl);
        generalFunctions.checkElementAttribute(xdesignHomePageFunctions.SpaceXLogo, "src", xdesignHomePageFunctions.homePageLogoSource);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.SpaceXLogo);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.LoadingListText);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.LogoLaunchesText);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.ReloadDataButton);
    }

    @Then("A screen will appear with a list of SpaceX API results")
    public void a_screen_will_appear_with_a_list_of_SpaceX_API_results() throws InterruptedException {
        Thread.sleep(10000);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.FilterByYearDropDown);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.SortAscendingButton);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.ShuttleList);
        generalFunctions.checkElementAttribute(xdesignHomePageFunctions.LaunchShuttleLogo, "src", xdesignHomePageFunctions.launchShuttleLogoSource);
        generalFunctions.checkListSize(xdesignHomePageFunctions.listOfShuttlesDisplayed, xdesignHomePageFunctions.shuttlelistSize);
    }

    @Given("Selecting filter")
    public void selecting_filter() throws InterruptedException {
        Thread.sleep(10000);
        generalFunctions.click(xdesignHomePageFunctions.FilterByYearDropDown);
    }

    @When("Setting filter by year to {int}")
    public void setting_filter_by_year_to(Integer int1) throws InterruptedException {
        String year = Integer.toString(int1);
        generalFunctions.selectDropOptionDownByValue(xdesignHomePageFunctions.FilterByYearDropDown, year);
    }

    @Then("Return a list of only launches in {int}")
    public void return_a_list_of_only_launches_in(Integer int1) {
        String yearToCheck = Integer.toString(int1);
        generalFunctions.verifyFilteredListDisplayingCorrectYear(xdesignHomePageFunctions.launchItemDate, yearToCheck);
    }

    @Given("I am on home page")
    public void i_am_on_home_page() throws InterruptedException {
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.SpaceXLogo);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.LoadingListText);
        Thread.sleep(10000);
    }

    @Given("I see default sort button value is Ascending")
    public void i_see_default_sort_button_value_is_Ascending() {
        generalFunctions.checkElementText(xdesignHomePageFunctions.SortButton,xdesignHomePageFunctions.sortAscendingButtonText);
    }

    @When("I click the sort button")
    public void i_click_the_sort_button() throws InterruptedException {
        generalFunctions.click(xdesignHomePageFunctions.SortButton);
    }

    @Then("value of sort button change to Descending")
    public void value_of_sort_button_change_to_Descending() throws InterruptedException {
        Thread.sleep(2000);
        generalFunctions.checkElementText(xdesignHomePageFunctions.SortButton,xdesignHomePageFunctions.sortDescendingButtonText);
    }

    @Then("sort button value change to ascending")
    public void sort_button_value_change_to_ascending() {
        generalFunctions.checkElementText(xdesignHomePageFunctions.SortButton,xdesignHomePageFunctions.sortAscendingButtonText);
    }

    @Given("I verify the filter by year drop down values")
    public void i_verify_the_filter_by_year_drop_down_values() {
        Assert.assertEquals(xdesignHomePageFunctions.actualYearDropDownOptions(), xdesignHomePageFunctions.expectedYearDropDownValues, "Actual values in Year drop down is not matching the expected values");
    }

    @Given("I also verify that drop values are sorted")
    public void i_also_verify_that_drop_values_are_sorted() {
        //Creating copy of actual list
        List templist = new ArrayList(xdesignHomePageFunctions.actualYearDropDownOptions());

        System.out.println("Temp List: " + templist);
        System.out.println("Actual List: " + xdesignHomePageFunctions.actualYearDropDownOptions());

        //Sort the actual list
        Collections.sort(xdesignHomePageFunctions.actualYearDropDownOptions());

        //Assert that list is sorted or not by comparing temp list and actual list
        Assert.assertEquals(xdesignHomePageFunctions.actualYearDropDownOptions(), templist, "Actual list is not in sorted order");Assert.assertEquals(xdesignHomePageFunctions.expectedYearDropDownValues, xdesignHomePageFunctions.expectedYearDropDownValuess, "Actual list is not in sorted order");
    }
}