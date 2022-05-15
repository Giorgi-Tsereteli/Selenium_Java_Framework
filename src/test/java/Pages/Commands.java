package Pages;

import Web.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class Commands {

    /**
     * Methods present in this class
     *
     * - finElement();
     * - finElements();
     *
     * - click();
     * - sendKeys();
     * - getText();
     *
     * - isEnabled();
     * - isDisplayed();
     * - isSelected();
     *
     * - getWindowHandles();
     * - getWindowHandle();
     * - getCurrentUrl();
     * - getTitle();
     *
     * - scroll methods
     *
     * - selectByVisibleText();
     *
     * - Calendar related methods
     */

    // Finding element(s)
    public WebElement findWebElement(By locator) {
        return MyDriver.getDriver().findElement(locator);
    }

    public List<WebElement> findWebElements(By locator) {
        return MyDriver.getDriver().findElements(locator);
    }


    // Clicking, Typing & Get Text
    public void click(By locator) {
        findWebElement(locator).click();
    }

    public void type(By locator, String input) {
        findWebElement(locator).sendKeys(input);
    }

    public String getElementText(By locator) {
        return findWebElement(locator).getText();
    }


    // isElement boolean methods
    public boolean isElementEnabled(By locator) {
        return findWebElement(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

    public boolean isElementSelected(By locator) {
        return findWebElement(locator).isSelected();
    }


    // Window handles, URL & Title methods
    public String getCurrentWindowHandle() {
        return MyDriver.getDriver().getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return MyDriver.getDriver().getWindowHandles();
    }

    public String getPageUrl() {
        return MyDriver.getDriver().getCurrentUrl();
    }

    public String pageTitle() {
        return MyDriver.getDriver().getTitle();
    }


    // Scroll related methods
    public WebElement scrollToElement(By locator) {
        WebElement element = null;
        for (int i = 0; i <= 15; i++) {
            try {
                element = findWebElement(locator); // <-- what is the action? What will cause exception ?
                break;                             // When I use it, it finds WebElement right away, without scrolling
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,150)");
            }
        }
        return element;
    }

    public void scrollAndClickElement(By locator) {
        for (int i = 0; i < 20; i++) {
            try {
                findWebElement(locator).click();
                break;
            } catch (NoSuchElementException | ElementClickInterceptedException e) {
                JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,200)");
            }
        }
    }


    // Calendar, Suggestions & Dropdowns
    public void selectDateInCalendar(By locator, String userDate) {
        // May not be applicable to all calendars. Look for "data-day" attribute
        List<WebElement> allDates = MyDriver.getDriver().findElements(locator);
        for (WebElement dateElement : allDates) {
            String dateValue = dateElement.getAttribute("data-day");
            if (dateValue.equals(userDate)) {
                dateElement.click();
                break;
            }
        }
    }

    public void selectFromSuggestions(By locator, String userSuggestion) {
        List<WebElement> allSuggestions = MyDriver.getDriver().findElements(locator);
        for (WebElement suggestion : allSuggestions) {
            if (suggestion.getText().equalsIgnoreCase(userSuggestion)) {
                suggestion.click();
                break;
            }
        }
    }

    public void selectInDropdown(By locator, String dataToSelect) {
        WebElement element = findWebElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(dataToSelect);
    }

}
