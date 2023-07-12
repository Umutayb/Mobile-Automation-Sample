package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pickleib.mobile.driver.Driver;
import pickleib.mobile.driver.ServiceFactory;
import pickleib.utilities.ScreenCaptureUtility;
import utils.Printer;
import utils.PropertyUtility;
import utils.StringUtilities;

import static pickleib.mobile.driver.Driver.driver;
import static pickleib.mobile.driver.Driver.startService;

public class Hooks {

    Printer log = new Printer(CommonSteps.class);
    StringUtilities strUtils = new StringUtilities();
    ScreenCaptureUtility capture = new ScreenCaptureUtility();

    public Scenario scenario;

    public Driver driver = new Driver();

    public Hooks() {
        PropertyUtility.loadProperties("src/test/resources/test.properties");
    }
    @Before
    public void before(Scenario scenario) {
        log.new Info("Running: " + strUtils.highlighted(StringUtilities.Color.BLUE, scenario.getName()));
        if (ServiceFactory.service == null) startService();
        this.scenario = scenario;
        driver.initialize();
    }

    @After
    public void kill(Scenario scenario) {
        if (scenario.isFailed()) log.new Warning(scenario.getName() + ": FAILED!");
        else log.new Success(scenario.getName() + ": PASS!");
        driver.terminate();
    }
}
