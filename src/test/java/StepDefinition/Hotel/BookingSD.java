package StepDefinition.Hotel;

import Pages.Hotel.LandingPage;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class BookingSD {

    LandingPage obj = new LandingPage();

    @Given("I am on www.hotels.com")
    public void launchHotels() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");
    }

    // Search error step def
    @When("I click destination search button")
    public void clickSearchBtn() {
        obj.clickSearchBtn();
    }

    @Then("I verify search error is displayed")
    public void verifySearchErrorMessage() {
        Assert.assertTrue(obj.isSearchErrorDisplayed());
        MyDriver.quitWindows();
    }


    // Travelers details step def
    @When("I click travelers field")
    public void clickTravelersField() {
        obj.clickOnTravelersBox();
    }

    @When("I add child travelers")
    public void addChildren() {
        obj.increaseChildTravelerCount();
    }

    @Then("I verify age error is displayed")
    public void verifyAgeErrorIsDisplayed() {
        Assert.assertTrue(obj.isTravelerErrorDisplayed());
    }

    @When("I select children's age")
    public void selectChildrensAge() {
        obj.selectChildrenAge();
    }

    @Then("I verify age error is not displayed")
    public void verifyAgeErrorNotDisplayed() {
        try {
            Assert.assertFalse(obj.isTravelerErrorDisplayed());
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            Assert.assertTrue(true);
        }
        MyDriver.quitWindows();
    }

    @When("I click travelers done button")
    public void clickTravelersDoneBtn() {
        obj.clickTravelerDoneBtn();
    }


    // Search destination before & after step def
    @When("I click search bar")
    public void slickSearchBar() {
        obj.clickSearchBar();
    }

    @When("I Type Seatt")
    public void typeDestination() {
        obj.typeInSearchBar("Seatt");
    }

    @When("I click on Seattle suggestion")
    public void clickSuggestion() {
        obj.clickOnSuggestion("Seattle");
    }

    @When("I click on Check In field")
    public void clickCheckIn() {
        obj.clickCheckInBtn();
    }

    @When("I select 17 August 2022")
    public void selectDate() {
        obj.selectDayMonthYear("17 August 2022");
    }

    @When("I click calendar done button")
    public void clickCalendarDoneBtn() {
        obj.clickCalendarDoneBtn();
    }

    @Then("I verify traveler count is same as before")
    public void verifyTravelersCount() {
        Assert.assertTrue(obj.isTravelersCountSameBeforeAndAfter());
        MyDriver.quitWindows();
    }

}
