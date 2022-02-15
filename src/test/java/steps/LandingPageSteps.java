package steps;

import io.cucumber.java.en.Then;
import pages.LandingPage;

public class LandingPageSteps {
    LandingPage landingPage = new LandingPage();

    @Then("Click landing next button")
    public void clickNext(){landingPage.clickElement(landingPage.nextButton);}
}
