package StepDefinition;

import Pages.Commands;
import Pages.Hotel.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MoreTravelDealsSD {

    LandingPage lPage = new LandingPage();
    DealsPage dPage = new DealsPage();
    AppPage aPage = new AppPage();
    FreeCancellationPage fCPage = new FreeCancellationPage();
    GreatOutdoorPage gOPage = new GreatOutdoorPage();
    Commands c = new Commands();

    @When("I click on more travel dropdown")
    public void clickMoreTravel() {
        lPage.clickMoreTravelDropdown();
    }

    @When("I click on Deals page link")
    public void clickDealsPageLink() {
        lPage.clickDealsPageOption();
    }

    @Then("I verify deal offers are enabled and displayed")
    public void verifyDealsEnabledAndDisplayed() {
        Assert.assertTrue(dPage.areOffersDisplayed(), "Test Fail - Offer was not displayed");
        Assert.assertTrue(dPage.areOffersEnabled(), "Test Fail - Offer was not enabled");
    }

    @When("^I click on (.+) offer$")
    public void clickManageBooking(String userInput) {
        dPage.clickOffer(userInput);
    }

    @Then("I verify Search, book and Save on the go! heading is displayed")
    public void verifyAppPageHeading() {
        Assert.assertTrue(aPage.isHeadingDisplayed());
    }

    @Then("I verify Amazing deals with free cancellation heading is displayed")
    public void verifyFreeCancellationPageHeading() {
        Assert.assertTrue(fCPage.isHeadingDisplayed());
    }

    @Then("I verify Save on your next trip to the great outdoors heading is displayed")
    public void verifyGreatOutdoorsPageHeading() {
        Assert.assertTrue(gOPage.isHeadingDisplayed());
    }

    @When("I return to previous page")
    public void goBack() {
        c.navigateToPreviousPage();
    }
}