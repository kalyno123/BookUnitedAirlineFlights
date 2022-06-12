package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightDeparturePage {

    public FlightDeparturePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h2>div")
    public WebElement flightDepartureHeading;

}
