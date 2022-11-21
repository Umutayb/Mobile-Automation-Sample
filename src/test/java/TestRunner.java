import common.ShutdownSequence;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.Printer;
import utils.appium.Driver;
import utils.appium.ServiceFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static utils.FileUtilities.properties;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        plugin = {"json:target/reports/Cucumber.json"},
        glue = {"steps"},
        publish = true
)
public class TestRunner {

    static Boolean useAppium2 = Boolean.parseBoolean(properties.getProperty("use-appium2", "false"));

    @BeforeClass
    public static void initialSequence(){
        File dir = new File("screenshots");
        File[] screenshots = dir.listFiles();
        assert screenshots != null;
        String mediaType;
        if(screenshots.length>0) for (File screenshot : screenshots) {
            try {mediaType = Files.probeContentType(screenshot.toPath());}
            catch (IOException e) {throw new RuntimeException(e);}
            if (mediaType.equals("image/jpeg")) screenshot.delete();
        }
        if (useAppium2) Driver.startService();
    }

    @AfterClass
    public static void finalSequence(){
        if (useAppium2) ServiceFactory.service.stop();
        String tags = System.getProperty("cucumber.filter.tags");
        if (tags != null)
            new ShutdownSequence().publishReports(System.getProperty("cucumber.filter.tags"));
        else new Printer(TestRunner.class).new Warning("Tags are null!");
    }
}