package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFunction extends DriverBaseClass {

    public LoginPageFunction(WebDriver ldriver){
        this.driver = ldriver;
    }

    @FindBy(how = How.ID, using = "username")
    public WebElement emailAddressTextBox;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordTextBox;
}
