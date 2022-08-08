package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrganizationLoginPageFunction extends DriverBaseClass {

    public String organizationLoginPageTitle = "Log In with Organization - Hudl";
    public String organizationLoginPageUrl = "https://www.hudl.com/app/auth/login/organization";

    @FindBy(how = How.XPATH, using = "//h2[text()='Log into Hudl with your Organization']")
    public WebElement organizationLoginPageHeading;
}
