package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Printer;
import utils.ScreenCaptureUtility;
import utils.StringUtilities;
import utils.appium.Driver;
import utils.appium.ServiceFactory;

import static utils.appium.Driver.driver;


public class Hooks {

    Printer log = new Printer(CommonSteps.class);
    StringUtilities strUtils = new StringUtilities();
    ScreenCaptureUtility capture = new ScreenCaptureUtility();

    public Scenario scenario;


    @Before
    public void before(Scenario scenario) {
        log.new Info("Running: " + strUtils.highlighted(StringUtilities.Color.PURPLE, scenario.getName()));
        if (ServiceFactory.service == null) Driver.startService();
        this.scenario = scenario;
        Driver.initialize();
    }

    @After
    public void kill(Scenario scenario) {
        if (scenario.isFailed())
            capture.captureScreen(
                    scenario.getName().replaceAll(" ", "") + "@" + scenario.getLine(), driver
            );
        else log.new Success(scenario.getName() + ": PASS!");
        Driver.terminate();
    }
}
