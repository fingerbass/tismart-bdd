package automationpractice.stepdefs;

import com.tismart.managers.DriverManager;
import com.tismart.managers.GlobalParams;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
    public static GlobalParams params = new GlobalParams();
    public static DriverManager driverManager = new DriverManager();

    @Before
    public static void startTests() {
        params.inicializaParametrosGlobales();
        driverManager.initDriver();
    }

    @After
    public static void tearDown() {
        driverManager.getDriver().quit();
    }

    @AfterStep
    public void capturaPantalla(Scenario scenario) {
        // if (scenario.isFailed()) {
        byte[] screenshot = ((TakesScreenshot) new DriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        // }
    }
}
