package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GeneralFunctions extends DriverBaseClass {

    public void click(WebElement element){
        element.click();
    }

    public void quitBrowser(){
        driver.quit();
    }

    public void verifyPageTitle(String expectedPageTitle){
        String actualPageTitle = driver.getTitle();
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

    public void checkElementNotPresent(WebElement element){
        Assert.assertFalse((element.isDisplayed()));
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
}
