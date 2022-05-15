package Pages.Hotel;

import Helper.Misc;
import Pages.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeLandingPage extends Commands {

    /**
     *  My practice version of same code that we did in class
     */

    // Locator variables
    // Check in/out related locators
    By checkInBoxLocator = By.id("d1-btn");
    By checkOutDaysLocator = By.xpath("//h2[text()='June 2022']/following-sibling::table//button[@data-day]");

    // Suggestion related locators
    By searchBarLocator = By.xpath("//button[@aria-label='Going to']");
    By searchBarInputLocator = By.id("location-field-destination");
    By destinationSuggestions = By.xpath("//div[@class='uitk-typeahead-results']//div[contains(@class,'truncat') and not(contains(@class,'uitk'))]");

    // Calendar scrolling locators
    By currentMonthYear = By.xpath("(//div[@class='uitk-date-picker-month']/h2)[1]"); // <-- change this, not h2, target div
    By nextMonthBtnLocator = By.xpath("(//button[@data-stid='date-picker-paging'])[2]");


    // Methods
    // Check in/out related methods
    public void clickCheckInBtn() {
        click(checkInBoxLocator);
        Misc.pause(1);
    }

    public void selectCheckoutDay(String day) {
        List<WebElement> daysToSelect = findWebElements(checkOutDaysLocator);
        for (WebElement value : daysToSelect) {
            if (value.getAttribute("data-day").equals(day)) {
                value.click();
            }
        }
    }


    // Search bar related methods
    public void clickSearchBar() {
        click(searchBarLocator);
        Misc.pause(1);
    }

    public void typeInSearchBar() {
        type(searchBarInputLocator,"Colora");
        Misc.pause(2);
    }

    public void clickOnSuggestion() {
//        List<WebElement> suggestions = findWebElements(destinationSuggestions);
//        for (WebElement value : suggestions) {
//            if (value.getText().equalsIgnoreCase("denver")){
//                value.click();
//                break;
//            }
//        }
        selectFromSuggestions(destinationSuggestions,"denver");
    }


    // Calendar scrolling related methods
    public void clickNextMonthBtn() {
    click(nextMonthBtnLocator);
    Misc.pause(1);
}

    public void selectDayMonthYear(String date) {
        String monthYear = date.split(" ")[1] + " " + date.split(" ")[2];
        String day = date.split(" ")[0];
        By dayLocator = By.xpath("(//div[@class='uitk-date-picker-month'])[1]/h2[text()='"+monthYear+"']/following-sibling::table//button[@data-day='"+day+"']");
        for (int i = 0; i < 12; i++) {
            if (getElementText(currentMonthYear).equalsIgnoreCase(monthYear)) {
                click(dayLocator);
                break;
            }
            clickNextMonthBtn();
        }
    }
}
