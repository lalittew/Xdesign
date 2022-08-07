package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageFunction extends DriverBaseClass {

    @FindBy(how = How.LINK_TEXT, using = "Log in")
    public WebElement loginButtonHomePage;
}
