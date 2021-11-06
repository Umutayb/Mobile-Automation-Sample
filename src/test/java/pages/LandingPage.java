package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import utils.Utilities;

public class LandingPage extends Utilities {
    @AndroidFindBy(id = "com.allandroidprojects.getirsample:id/btn_next")
    @iOSBy(id = "")
    public MobileElement nextButton;

}
