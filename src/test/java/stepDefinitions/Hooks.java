package stepDefinitions;

import browserFactory.DriverBaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void beforeTest() {
        DriverBaseClass.startTest();
    }

    @After
    public void afterTest() {
        DriverBaseClass.afterTest();
    }
}
