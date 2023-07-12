
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pickleib.mobile.driver.Driver;
import pickleib.mobile.driver.ServiceFactory;
import utils.PropertyUtility;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        plugin = {"json:target/reports/Cucumber.json"},
        glue = {"steps"},
        publish = true
)
public class TestRunner {


    static Boolean useAppium2 = Boolean.parseBoolean(PropertyUtility.getProperty("use-appium2", "false"));

    @BeforeClass
    public static void initialSequence(){
        if (useAppium2) Driver.startService();
    }

    @AfterClass
    public static void finalSequence(){
        if (useAppium2) ServiceFactory.service.stop();
    }
}