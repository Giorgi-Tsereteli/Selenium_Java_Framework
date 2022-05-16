package StepDefinition;

import Helper.Misc;
import Web.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class DemoSD {

    @Given("I am on amazon.com")
    public void amazonHomePage() {
        MyDriver.launchUrlOnNewWindow("https://www.amazon.com/");
    }

//    @When("I click on Coupons link")
//    public void clickCouponNavLink() {
//        MyDriver.getDriver().findElement(By.xpath("//a[text()='Coupons']"));
//        Misc.pause(5);
//    }

    @Then("I verify page title contains coupons")
    public void verifyPageTitle() {
        System.out.println(MyDriver.getDriver().getTitle());
        MyDriver.quitWindows();
    }



    @Given("I am on spacex")
    public void goToSpaceX() {
        MyDriver.launchUrlOnNewWindow("https://www.spacex.com");
    }

    @Then("I print page title")
    public void getPageTitle() {
        System.out.println(MyDriver.getDriver().getTitle());
    }
}