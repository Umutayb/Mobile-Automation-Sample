package common;

import slack.Slack;
import utils.MobileUtilities;
import utils.Printer;

public class ShutdownSequence extends CucumberUtilities {
    static Printer log = new Printer(ShutdownSequence.class);

    public void publishReports(String testName){ // This method is called upon after the tests are done running
        log.new Info("Performing final sequence for the test specification: " + highlighted(MobileUtilities.Color.PURPLE,testName));
        log.new Info("Final sequence completed.");
    }
}