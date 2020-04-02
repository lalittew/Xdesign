package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFunction extends DriverBaseClass {

//  public LoginPageFunction(WebDriver ldriver){ this.driver = ldriver;}
    public static String loginPageTitle = "Account Login | MYPROTEIN™";
    public static String invalidLoginErrorText = "The email address or password you entered were invalid";

    @FindBy(how = How.ID, using = "username")
    public WebElement emailAddressTextBox;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordTextBox;

    @FindBy(how = How.ID, using = "login-submit")
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]/div[4]/div/div[1]/strong")
    public WebElement invalidLoginError;
}
