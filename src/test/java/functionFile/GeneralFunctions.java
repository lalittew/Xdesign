package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GeneralFunctions extends DriverBaseClass {

    public GeneralFunctions(WebDriver ldriver){
        this.driver = ldriver;
    }

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

}
