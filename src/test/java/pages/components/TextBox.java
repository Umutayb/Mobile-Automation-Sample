package pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Printer;
import utils.Utilities;

import static resources.Colors.*;

public class TextBox extends Utilities {

    Printer log = new Printer(TextBox.class);

    @FindBy(css = "button[id='submit']")
    public WebElement submitButton;

    @FindBy(css = "[id='userName']")
    public WebElement nameInput;

    @FindBy(css = "[id='userEmail']")
    public WebElement emailInput;

    @FindBy(css = "[id='currentAddress']")
    public WebElement currentAddressInput;

    @FindBy(css = "[id='permanentAddress']")
    public WebElement permanentAddressInput;

    public void clickSubmit(){
        log.new info("Clicking submit button");
        clickElement(submitButton);
    }

    public void fillNameInput(String text){
        log.new info("Filling name input with "+BLUE+text);
        clearFillInput(nameInput, text, true);
    }

    public void fillEmailInput(String text){
        log.new info("Filling email input with "+BLUE+text);
        clearFillInput(emailInput, text, true);
    }

    public void fillCurrentAddressInput(String text){
        log.new info("Filling current address input with "+BLUE+text);
        clearFillInput(currentAddressInput, text, true);
    }

    public void fillPermanentAddressInput(String text){
        log.new info("Filling permanent address input with "+BLUE+text);
        clearFillInput(permanentAddressInput, text, true);
    }

}
