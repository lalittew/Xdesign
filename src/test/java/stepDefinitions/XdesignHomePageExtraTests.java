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
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XdesignHomePageExtraTests extends DriverBaseClass {

    WebDriver driver = DriverBaseClass.startBrowser();
    XdesignHomePageFunctions xdesignHomePageFunctions = PageFactory.initElements(driver,XdesignHomePageFunctions.class);
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);

    @Given("I am on home page")
    public void i_am_on_home_page() throws InterruptedException {
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.SpaceXLogo);
        generalFunctions.checkElementPresent(xdesignHomePageFunctions.LoadingListText);

        //Added fluent wait for that Filter drop down appear on screen
        generalFunctions.fluentWait(xdesignHomePageFunctions.FilterByYearDropDown);
    }

    @Given("I see default sort button value is Ascending")
    public void i_see_default_sort_button_value_is_Ascending() {
        //Default value of Sort drop down is "Sort Ascending"
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
        Assert.assertEquals(xdesignHomePageFunctions.actualYearDropDownOptions(), templist, "Actual list is not in sorted order");
    }

    @Given("I also verify that shuttle list displayed is sorted in Ascending Order")
    public void i_also_verify_that_shuttle_list_displayed_is_sorted_in_Order() {
        //Verify that displayed list is sorted in ascending order of numbers
        xdesignHomePageFunctions.checkIfListSortingOrder(xdesignHomePageFunctions.launchItemNumbers, SortingOrder.ASCENDING);

    }
}