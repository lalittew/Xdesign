package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePageFunction extends DriverBaseClass {

    public HomePageFunction(WebDriver ldriver){
        this.driver = ldriver;
    }

    @FindBy(how = How.LINK_TEXT, using = "Account")
    public WebElement accountOption;

}
