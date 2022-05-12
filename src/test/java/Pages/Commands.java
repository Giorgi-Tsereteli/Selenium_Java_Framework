package Pages;

import Web.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class Commands {

    /**
     * Methods present in this class
     * - finElement();
     * - click();
     * - sendKeys();
     * - getText();
     * - isEnabled();
     * - isDisplayed();
     * - selectByVisibleText();
     */

    public WebElement findWebElement(By locator) {
        return MyDriver.getDriver().findElement(locator);
    }

    public void click(By locator) {
        findWebElement(locator).click();
    }

    public void type(By locator, String input) {
        findWebElement(locator).sendKeys(input);
    }

    public String getElementText(By locator) {
        return findWebElement(locator).getText();
    }

    public boolean isElementEnabled(By locator) {
        return findWebElement(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

    public void selectInDropdown(By locator, String dataToSelect) {
        WebElement element = findWebElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(dataToSelect);
    }

    public Set<String> myWindowHandles() {
        return MyDriver.getDriver().getWindowHandles();
    }

    public String pageTitle(){
        return MyDriver.getDriver().getTitle();
    }

    public WebElement scrollToElement(By locator) {
        WebElement element = null;
        for (int i=0 ; i <= 15 ; i++) {
            try {
                element = findWebElement(locator); // <-- what is the action? What will cause exception ?
                break;                             // it finds WebElement right away, without scrolling
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
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
                js.executeScript("scrollBy(0,100)");
            }
        }
    }
}
