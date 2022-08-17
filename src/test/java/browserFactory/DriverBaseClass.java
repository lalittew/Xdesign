package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBaseClass {
    public static WebDriver driver;

    public static String homePageUrl = "https://fe-automation-tool.s3.eu-west-1.amazonaws.com/index.html";

    public static WebDriver startBrowser()
    {
        System.setProperty("webdriver.chrome.driver","./WebDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePageUrl);

        return driver;
    }

    public static void startTest()
    {
        System.out.println("**********************");
        System.out.println("Test Started");

    }

    public static void afterTest()
    {
        driver.quit();
        System.out.println("**********************");
        System.out.println("Test Finished");
    }
}
