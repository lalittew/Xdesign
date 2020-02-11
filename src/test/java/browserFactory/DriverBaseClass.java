package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBaseClass {
    public static WebDriver driver;


    public static WebDriver startBrowser()
    {
        System.setProperty("webdriver.chrome.driver","/Users/lalittewari/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myprotein.com/");

        return driver;
    }
}
