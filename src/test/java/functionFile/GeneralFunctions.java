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
       Assert.assertEquals(actualPageTitle,expectedPageTitle,"Actual Page title is different from expected page title !!!");
    }

    public void enterText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    public void checkElementPresent(WebElement element){
        org.junit.Assert.assertTrue(element.isDisplayed());
    }
}
