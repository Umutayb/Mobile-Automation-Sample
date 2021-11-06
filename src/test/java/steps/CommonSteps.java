package steps;

import utils.Utilities;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.cucumber.core.api.Scenario;

public class CommonSteps extends Utilities {

    @Before
    public void start(){initialize();}

    @After
    public void kill(Scenario scenario){terminate(scenario);}

    @Given("Wait {} seconds")
    public void wait(Double seconds){waitFor(seconds);}

}