package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.FlightDeparturePage;
import pages.UnitedHomePage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    // DECLARE GLOBAL VARIABLE
    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    SoftAssert softAssert;
    UnitedHomePage unitedHomePage;
    FlightDeparturePage flightDeparturePage;

    @BeforeMethod
    // INITIALIZING OBJECTS VARIABLES
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 10);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        unitedHomePage = new UnitedHomePage(driver);
        flightDeparturePage = new FlightDeparturePage(driver);
    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver(); // THIS METHOD IN OUR UTIL. CLASS TEARDOWN THE DRIVER COMPLETELY INCLUDING DELETING ANY STORED DATA(COOKIES)
    }
}
