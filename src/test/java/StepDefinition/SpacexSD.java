package StepDefinition;

import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpacexSD {

    @Given("I am on spacex")
    public void launch() {
        MyDriver.launchUrlOnNewWindow("https://www.spacex.com");
    }

    @When("I get title")
    public void title() {
        System.out.println(MyDriver.getDriver().getTitle());
    }

    @Then("I quit")
    public void quite() {
        MyDriver.quitWindows();
    }
}
