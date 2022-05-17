package StepDefinition.Darksky;

import Helper.Misc;
import Pages.Darksky.LandingPage;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TemperatureSD {

    LandingPage obj = new LandingPage();

    @Given("I am on www.darksky.com")
    public void launchDarkSky() {
        MyDriver.launchUrlOnNewWindow("https://darksky.net/");
    }

    // Time Machine related step def
    @When("I click on Time Machine button")
    public void clickTimeMachine() {
        obj.clickTimeMachineBtn2();
        Misc.pause(2);
    }

    @Then("I verify that date in Time Machine is correct")
    public void verifyHighlightedDate() {
        Assert.assertEquals(obj.timeMachineDate(), obj.localDate(), "Test Failed - Wrong Date Selected");
        MyDriver.quitWindows();
    }


    // Temp bars related step def
    @When("I expand today details")
    public void clickTodayDetails() {
        obj.clickTodayToggle();
        Misc.pause(2);
    }

    @Then("I verify displayed temp is equal to temp in details")
    public void verifyTempInDetails() {
        Assert.assertEquals(obj.getTodayTemp(), obj.getTodayExtraTemp(), "Test Failed - Displayed temp and expanded details don't match");
        MyDriver.quitWindows();
    }
}
