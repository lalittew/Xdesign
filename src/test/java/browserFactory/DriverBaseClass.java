package browserFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class DriverBaseClass {
    public static WebDriver driver;


    public static WebDriver startBrowser()
    {
        System.setProperty("webdriver.chrome.driver","./WebDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myprotein.com/");

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
