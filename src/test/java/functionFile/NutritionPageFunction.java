package functionFile;

import browserFactory.DriverBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NutritionPageFunction extends DriverBaseClass {
    public static String nutritionPageTitle = "Sports Nutrition Supplements & Products | MYPROTEIN™";

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav\"]/div[1]/div[2]/div[4]/nav/div[1]/ul/li[1]/a")
    public WebElement nutritionMenuLink;
}
