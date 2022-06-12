package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedHomePage {

    public UnitedHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div[role='tablist']>a")
    public List<WebElement> mainMenuNavigationItems;

    @FindBy (css = "ul[class$='travelNav--3RNBj']>li")
    public List<WebElement> travelMenuNavigationItems;

    //@FindBy (xpath = "//span[contains(@class,'checkmark--2DHJD')]")
    //public List<WebElement> tripRadioButtons;

    @FindBy (xpath = "(//span[contains(@class,'checkmark--2DHJD')])[1]")
    public WebElement roundTripRadioButton;

    @FindBy (xpath = "(//span[contains(@class,'checkmark--2DHJD')])[2]")
    public WebElement oneWayRadioButton;

    @FindBy (id = "award")
    public WebElement bookWithMilesCheckbox;

    @FindBy (id = "flexibleDates")
    public WebElement flexibleDatesCheckbox;

    @FindBy (css = "label[for='award']")
    public WebElement bookWithMilesLabel;

    @FindBy (css = "label[for='flexibleDates']")
    public WebElement flexibleDateLabel;

    @FindBy (id = "bookFlightOriginInput")
    public WebElement bookFlightOriginInput;

    @FindBy (id = "bookFlightDestinationInput")
    public WebElement bookFlightDestinationInput;

    @FindBy (id = "DepartDate")
    public WebElement departDate;

    @FindBy (css = "div[id=passengerSelector]>button")
    public WebElement travelerInputButton;

    @FindBy (css = "button[aria-label='Substract one Adult']")
    public WebElement adultTravelerPlusButton;

    @FindBy (css = "button[class='atm-c-btn atm-c-btn--bare']")
    public WebElement travelerPanelCloseButton;

    @FindBy (id = "cabinType")
    public WebElement cabinTypeDropDownMenu;

    @FindBy (css = "ul[role='listbox']>li")
    public List<WebElement> cabinTypes;

    @FindBy (css = "button[class*='findFlightBtn']")
    public WebElement findFlightsButton;

}
