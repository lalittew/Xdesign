package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NeedHelpPageFunction extends DriverBaseClass {

    public String needHelpPageTitle = "Log In";
    public String needHelpPageUrl = "https://www.hudl.com/login/help#";

    @FindBy(how = How.XPATH, using = "//h2[text()='Login Help']")
    public WebElement loginHelpText;
}
