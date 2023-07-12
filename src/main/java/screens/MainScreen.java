package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pickleib.mobile.utilities.MobileUtilities;


import java.util.List;

public class MainScreen extends MobileUtilities {

    @AndroidFindBy(id = "trendyol.com:id/textViewCountryName")
    List<WebElement> countries;

    @FindBy(id = "trendyol.com:id/textViewSearchSuggestionText")
    List<WebElement> searchResults;

    @FindBy(id = "trendyol.com:id/buttonSelectGenderMan")
    WebElement genderSelectionMaleButton;

    @FindBy(id = "trendyol.com:id/buttonSelectGenderWoman")
    WebElement genderSelectionFemaleButton;

    @FindBy(id = "trendyol.com:id/imageViewTooltipClose")
    WebElement tooltipCloseButton;

    @FindBy(id = "trendyol.com:id/edittext_search_view")
    WebElement searchInput;

    @FindBy(id = "trendyol.com:id/imageview_action_start")
    WebElement searchButton;

    @AndroidFindBy(accessibility = "Ana Sayfa")
    WebElement homePageTabButton;
}
