package automationpractice.stepdefs;

import com.tismart.managers.DriverManager;
import com.tismart.managers.GlobalParams;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    public static GlobalParams params = new GlobalParams();
    public static DriverManager driverManager = new DriverManager();

    @Before
    public static void startTests(){
        params.inicializaParametrosGlobales();
        driverManager.initDriver();
    }

    @After
    public static void tearDown(){
        driverManager.getDriver().quit();
    }
}
