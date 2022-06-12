package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitedAirlinesTest extends Base{

    /* Test Case 1: Validate "Main menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see “Main menu” navigation items
        |BOOK                |
        |MY TRIPS            |
        |TRAVEL INFO         |
        |MILEAGEPLUS® PROGRAM|
        |DEALS               |
        |HELP                |
    */
    @Test (description = "Test Case 1: Validate 'Main menu' navigation items")
    public void validateMainMenuNavigation(){
        driver.get("https://www.united.com/en/us");
        String[] mainNavigationItems = {"Book", "My Trips", "Travel Info", "MileagePlus Program", "Deals", "Help"};
        int index = 0;
        for (WebElement mainMenuItem : unitedHomePage.mainMenuNavigationItems){
            softAssert.assertTrue(mainMenuItem.isDisplayed(), mainNavigationItems[index++] + "FAILED");
        }
    }


    /* Test Case 2: Validate "Book travel menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see "Book travel menu" navigation items
        |Book         |
        |Flight Status|
        |Check-in     |
        |My trips     |
    */
    @Test (description = "Test Case 2: Validate 'Book travel menu' navigation items")
    public void validateTravelMenuNavigation(){
        driver.get("https://www.united.com/en/us");
        String[] travelNavigationItems = {"Book", "Flight Status", "Check-in", "My Trips"};
        int index = 0;
        for (WebElement travelMenuItem : unitedHomePage.travelMenuNavigationItems){
            softAssert.assertTrue(travelMenuItem.isDisplayed(), travelNavigationItems[index++] + "FAILED");
        }
    }

    /* Test Case 3: Validate "Round-trip" and "One-way" radio buttons
    Given user is on "https://www.united.com/en/us"
    Then validate "Roundtrip" radio button is displayed, is enabled and is selected
    And validate "One-way" radio button is displayed, is enabled but is not selected
    When user clicks on "One-way" radio button
    Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
    */
    @Test (description = "Test Case 3: Validate 'Round-trip' and 'One-way' radio buttons")
    public void validateFlightRadioButtons(){
        driver.get("https://www.united.com/en/us");
        softAssert.assertTrue(unitedHomePage.roundTripRadioButton.isDisplayed());
        softAssert.assertTrue(unitedHomePage.roundTripRadioButton.isEnabled());
        softAssert.assertTrue(unitedHomePage.roundTripRadioButton.isSelected());

        softAssert.assertTrue(unitedHomePage.oneWayRadioButton.isDisplayed());
        softAssert.assertTrue(unitedHomePage.oneWayRadioButton.isEnabled());
        softAssert.assertFalse(unitedHomePage.oneWayRadioButton.isSelected());

        unitedHomePage.oneWayRadioButton.click();
        softAssert.assertTrue(unitedHomePage.oneWayRadioButton.isSelected());
        softAssert.assertFalse(unitedHomePage.roundTripRadioButton.isSelected());
    }


    /* Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
    Given user is on "https://www.united.com/en/us"
    Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
    And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
    When user clicks both checkboxes
    Then validate both checkboxes are selected
    When user clicks on both selected checkboxes again
    Then validate both checkboxes are deselected
    */
    @Test (description = "Test Case 4: Validate 'Book with miles' and 'Flexible dates' checkboxes")
    public void validateFlightCheckboxes(){
        driver.get("https://www.united.com/en/us");
        softAssert.assertTrue(unitedHomePage.bookWithMilesCheckbox.isDisplayed());
        softAssert.assertTrue(unitedHomePage.bookWithMilesCheckbox.isEnabled());
        softAssert.assertFalse(unitedHomePage.bookWithMilesCheckbox.isSelected());

        softAssert.assertTrue(unitedHomePage.flexibleDatesCheckbox.isDisplayed());
        softAssert.assertTrue(unitedHomePage.flexibleDatesCheckbox.isEnabled());
        softAssert.assertFalse(unitedHomePage.flexibleDatesCheckbox.isSelected());

        unitedHomePage.bookWithMilesLabel.click();
        unitedHomePage.flexibleDateLabel.click();

        softAssert.assertTrue(unitedHomePage.bookWithMilesCheckbox.isSelected());
        softAssert.assertTrue(unitedHomePage.flexibleDatesCheckbox.isSelected());

        unitedHomePage.bookWithMilesLabel.click();
        unitedHomePage.flexibleDateLabel.click();

        softAssert.assertFalse(unitedHomePage.bookWithMilesCheckbox.isSelected());
        softAssert.assertFalse(unitedHomePage.flexibleDatesCheckbox.isSelected());
    }


    /* Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "Miami, FL, US (MIA)" to to input box
    And user selects "Jan 30" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US"
    */
    @Test (description = "Test Case 5: Validate One-way ticket search results")
    public void validateFlightResult(){
        driver.get("https://www.united.com/en/us");
        unitedHomePage.oneWayRadioButton.click();
        unitedHomePage.bookFlightOriginInput.clear();
        unitedHomePage.bookFlightOriginInput.sendKeys("Chicago, IL, US (ORD)");
        unitedHomePage.bookFlightDestinationInput.sendKeys("Miami, FL, US (MIA)");
        unitedHomePage.departDate.clear();
        unitedHomePage.departDate.click();
        unitedHomePage.departDate.sendKeys("Jan 30");
        unitedHomePage.travelerInputButton.click();
        unitedHomePage.adultTravelerPlusButton.click();
        unitedHomePage.travelerPanelCloseButton.click();
        unitedHomePage.cabinTypeDropDownMenu.click();
        unitedHomePage.cabinTypes.get(2).click(); // dont need to loop
        unitedHomePage.findFlightsButton.click();
        Assert.assertEquals(flightDeparturePage.flightDepartureHeading.getText(), "Depart: Chicago, IL, US to Miami, FL, US");
    }
}
