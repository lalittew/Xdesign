package functionFile;

import browserFactory.DriverBaseClass;
import enums.SortingOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XdesignHomePageFunctions extends DriverBaseClass {
    GeneralFunctions generalFunctions= PageFactory.initElements(driver,GeneralFunctions.class);

    //All the Strings defined to be use for Home page
    public String homePageLogoSource = "https://fe-automation-tool.s3.eu-west-1.amazonaws.com/static/media/spacex-logo.e755fcbf.png";
    public String launchShuttleLogoSource = "https://fe-automation-tool.s3.eu-west-1.amazonaws.com/static/media/launch-home.b539e3f9.png";
    public String shuttlelistSize = "111";
    public String sortAscendingButtonText = "Sort Ascending";
    public String sortDescendingButtonText = "Sort Descending";
    public List<String> expectedYearDropDownValues = Arrays.asList("Filter By Year", "2006", "2007", "2008", "2009", "2010", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020");

    //All the element identifiers defined for the Home page
    @FindBy(how = How.XPATH, using = "//img[@alt='SpaceX']")
    public WebElement SpaceXLogo;

    @FindBy(how = How.XPATH, using = "//span[@class='app__logo-txt' and text()='Launches']")
    public WebElement LogoLaunchesText;

    @FindBy(how = How.XPATH, using = "//span[@class='app__message' and text()='Loading...']")
    public WebElement LoadingListText;

    @FindBy(how = How.XPATH, using = "//button[@class='button button--reload' and text()='Reload Data']")
    public WebElement ReloadDataButton;

    @FindBy(how = How.XPATH, using = "//select[@name='Filter By Year']")
    public WebElement FilterByYearDropDown;

    @FindBy(how = How.XPATH, using = "//button[@class='button button--sort']")
    public WebElement SortButton;

    @FindBy(how = How.XPATH, using = "//button[@class='button button--sort' and text()='Sort Ascending']")
    public WebElement SortAscendingButton;

    @FindBy(how = How.XPATH, using = "//button[@class='button button--sort' and text()='Sort Descending']")
    public WebElement SortDescendingButton;

    @FindBy(how = How.XPATH, using = "//ul[@class='launch-list']")
    public WebElement ShuttleList;

    @FindBy(how = How.XPATH, using = "//img[@alt='Launch Home']")
    public WebElement LaunchShuttleLogo;

    @FindBy(how = How.XPATH, using = "//ul[@class='launch-list']/li[@class='launch-item']")
    public List<WebElement> listOfShuttlesDisplayed;

    @FindBy(how = How.XPATH, using = "//span[@class='launch-item__date']")
    public List<WebElement> launchItemDates;

    @FindBy(how = How.XPATH, using = "//span[@class='launch-item__number']")
    public List<WebElement> launchItemNumbers;

    //All functions belong to xDesignHome page
    public List<String> actualYearDropDownOptions(){
        return generalFunctions.getAllValuesFromDropDown(FilterByYearDropDown);
    }

    public void checkIfListSortedDescendingOrder(List<WebElement> elements){
        int size = elements.size();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=0; i<size; i++){
            WebElement element = elements.get(i);
            String text = element.getText();

            String valueStr = text;
            if(String.valueOf(text.charAt(0)).equals("#")){
                valueStr = text.substring(1);
            }
            numbers.add(Integer.valueOf(valueStr));
        }
        for(int i=1; i<size; i++) {
            Assert.assertTrue(numbers.get(i) <= numbers.get(i-1));
        }
    }

    public void checkIfListSortingOrder(List<WebElement> elements, SortingOrder order){
        int size = elements.size();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0; i<size; i++){
            WebElement element = elements.get(i);
            String text = element.getText();

            String valueStr = text;
            if(String.valueOf(text.charAt(0)).equals("#")){
                valueStr = text.substring(1);
            }
            numbers.add(Integer.valueOf(valueStr));
        }
        for(int i=1; i<size; i++) {
            switch (order) {

                // Case 1
                case ASCENDING:

                    // Print statement corresponding Ascending case
                    Assert.assertTrue(numbers.get(i) >= numbers.get(i-1), "List is not sorted in Ascending order");
                    break;

                // Case 2
                case DESCENDING:

                    // Print statement corresponding descending case
                    Assert.assertTrue(numbers.get(i) <= numbers.get(i-1), "List is not sorted in Descending order");
                    break;
            }
        }
    }
}
