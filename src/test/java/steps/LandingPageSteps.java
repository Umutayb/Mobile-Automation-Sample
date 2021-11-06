package steps;

import io.cucumber.java.en.Then;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;

import java.lang.reflect.Method;

public class LandingPageSteps {
    LandingPage landingPage = new LandingPage();

    @Then("Click landing next button")
    public void clickNext(){landingPage.clickElement(landingPage.nextButton);}
}
