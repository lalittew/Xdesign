package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFunction extends DriverBaseClass {

    public String loginPageTitle = "Log In";
    public String loginPageUrl = "https://www.hudl.com/login";


    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/section/div[2]/div/form/a")
    public WebElement hudl;

    @FindBy(how = How.CLASS_NAME, using = "styles_backIconContainer_MhkioW9m8rx70X7CIGuws")
    public WebElement backButton;

    @FindBy(how = How.LINK_TEXT, using = "Sign up")
    public WebElement signUpLink;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']")
    public WebElement emailTextBoxHint;

    @FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
    public WebElement emailTextBox;

    @FindBy(how = How.XPATH, using = "//label[text()='Password']")
    public WebElement passwordTextBoxHint;

    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
    public WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"logIn\"]")
    public WebElement loginButton;

    @FindBy(how = How.CLASS_NAME, using = "uni-form__check-indicator__background")
    public WebElement rememberMeCheckBox;

    @FindBy(how = How.XPATH, using = "//*[@class=\"uni-form__check-item uni-form__check-item--is-checked\"]")
    public WebElement rememberMeCheckBoxSelected;

    @FindBy(how = How.XPATH, using = "//*[@class=\"uni-form__check-item\"]")
    public WebElement rememberMeCheckBoxNotSelected;

    @FindBy(how = How.XPATH, using = "//label[text()='Remember me']")
    public WebElement rememberMeText;

    @FindBy(how = How.LINK_TEXT, using = "Need help?")
    public WebElement needHelpLinkText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/section/div[2]/div/form/div/hr")
    public WebElement dividerLine;

    @FindBy(how = How.LINK_TEXT, using = "Log In with an Organization")
    public WebElement loginInWithOrganizationButton;

    @FindBy(how = How.XPATH, using = "//span[@class= \"styles_questionMarkContainer_10mxHNOMojCyG6bxLH9qo9\"]")
    public WebElement loginErrorHelpIconImage;

    @FindBy(how = How.XPATH, using = "//p[@class='uni-text' and contains(text(),\"We didn't recognize that email and/or password.\")]")
    public WebElement invalidCredentialsError;

    @FindBy(how = How.XPATH, using = "//a[@class='uni-link uni-link--default uni-margin--quarter--left' and contains(text(),\"Need help?\")]")
    public WebElement invalidCredentialNeedHelp;

}
