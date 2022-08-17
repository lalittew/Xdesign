package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GeneralFunctions extends DriverBaseClass {

    public void click(WebElement element){
        element.click();
    }

    public void verifyPageUrl(String expectedUrl){
        String actualPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualPageUrl,expectedUrl,"Actual Page Url is different from expected page Url !!!");
    }

    public void enterText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    public void checkElementPresent(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }

    public void checkTextNotPresentOnPage(String textToFind){
        Assert.assertFalse(driver.getPageSource().contains(textToFind));
    }

    public void verifyCursorFocus(WebElement element){
        assert(element).equals(driver.switchTo().activeElement());
    }

    public void verifyElementIsDisabled(WebElement element){
        Assert.assertFalse(element.isEnabled());
    }

    public void pageRefresh() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
    }

    public void checkFieldIsEmpty(WebElement element){
        Assert.assertTrue(element.getAttribute("value").isEmpty());
    }

    public void checkElementText(WebElement element, String expectedText){
        String actualText = element.getText();
        Assert.assertEquals(actualText , expectedText , "Actual text is different from expected text");
    }

    public void checkElementAttribute(WebElement element, String attributeIdentifier, String expectedValue){
        String actualValue = element.getAttribute(attributeIdentifier);
        Assert.assertEquals(actualValue , expectedValue , "Actual attribute value is different from expected value");
    }

    public void checkListSize(List<WebElement> elements, String expectedSize){
        Assert.assertEquals(String.valueOf(elements.size()), expectedSize, "Actual size is different from expected size");
    }

    public String getActualListSize(List<WebElement> elements){
        return  String.valueOf(elements.size());
    }

    public List<String> getAllValuesFromDropDown(WebElement element){
        //Create object of Select class for the weblement/dropdown we want values for
        Select dropDown = new Select(element);

        //Using getOptions we are trying to store all the values in drop down into list in form of Web elements
        List<WebElement> allDropDownOptions = dropDown.getOptions();

        //Creating a List of Strings to hold the actual values in String format for the Webelements
        List<String> actaulDropDownValues = new ArrayList<String>();

        //Iterating the List of webelements and getting the text of value which web element is holding
        for (WebElement ref : allDropDownOptions){
                actaulDropDownValues.add(ref.getText());
        }
        return actaulDropDownValues;
    }

    public void selectDropOptionDownByValue(WebElement element, String value){
        Select ddOption = new Select(element);

        ddOption.selectByValue(value);
        click(element);
    }

    public void verifyFilteredListDisplayingCorrectYear(List<WebElement> elements, String expectedYear){
        // Get the size of list displayed after applying filter
        getActualListSize(elements);

        //Getting the year and splitting it into Date Month and Year
        for (int i=0;i<Integer.parseInt(getActualListSize(elements));i++){
            String splitDate[] = elements.get(i).getText().split(" ");

            //Verify that the year got is equal to expected year
            Assert.assertEquals(splitDate[2], expectedYear, "Year is not matching as expected");
        }
    }
}
