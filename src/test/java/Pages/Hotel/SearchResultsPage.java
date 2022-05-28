package Pages.Hotel;

import Helper.Misc;
import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends Commands {

    // Locator variables
    By popularCheckboxLocator = By.xpath("//*[@name='popularFilter']");
    By sortByLocator = By.xpath("//*[@id='sort']");
    By sortBySuggestionsLocator = By.xpath("//*[@id='sort']//option");
    By lowestPriceLocator = By.xpath("(//*[@data-test-id='price-summary-message-line']//span/div)[1]");
    By starRatingLocator = By.xpath("//div[@class='uitk-button-toggle']/input[@name='star']");
    By searchPropertyFieldLocator = By.xpath("//button[@aria-label='Search by property name']");
    By searchPropertyTypeFieldLocator = By.xpath("//input[@placeholder='e.g. Best Western']");
    By noMatchesErrorLocator = By.xpath("//*[@data-stid='section-results']//h3[text()='No matches']");
    By getErrorFilterLocator2 = By.xpath("//*[@aria-label='Remove PPPPPP']");


    // Methods
    public boolean isPopularFilterChecked() {
        List<WebElement> popularCheckboxes = findWebElements(popularCheckboxLocator);
        for (WebElement i : popularCheckboxes) {
            if (i.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void clickSortByField() {
        click(sortByLocator);
        Misc.pause(2);
    }

    public void clickPriceSuggestion() {
        selectFromSuggestions(sortBySuggestionsLocator,"Price");
        Misc.pause(8);
    }

    public int getLowestPrice() {
        String price = getElementText(lowestPriceLocator);
        return Integer.valueOf(price.substring(1));
    }

    public boolean verifyStarOrder() {
        List<WebElement> starRatings = findWebElements(starRatingLocator);
        boolean result = true;
        for (int i = 1; i <= starRatings.size()-1; i++) {
            String currentStar = MyDriver.getDriver().findElement(By.xpath("(//div[@class='uitk-button-toggle']/input[@name='star'])["+i+"]")).getAttribute("value");
            String nextStar = MyDriver.getDriver().findElement(By.xpath("(//div[@class='uitk-button-toggle']/input[@name='star'])["+(i+1)+"]")).getAttribute("value");
            //System.out.println(currentStar + " is (10 points) less than " + nextStar);
            if (Integer.valueOf(currentStar) + 10 != Integer.valueOf(nextStar)) {
               result = false;
            }
        }
        return result;
    }

    public void clickSearchByProperty() {
        click(searchPropertyFieldLocator);
        Misc.pause(1);
    }

    public void typeProperty() {
        type(searchPropertyTypeFieldLocator,"PPPPPP");
        Misc.pause(1);
        WebElement toClick = findWebElement(searchPropertyTypeFieldLocator);
        toClick.sendKeys(Keys.RETURN);
        Misc.pause(5);
    }

    public boolean isNoMatchesErrorDisplayed() {
        return isElementDisplayed(noMatchesErrorLocator);
    }

    public boolean isRemovableFilterDisplayed() {
        return isElementDisplayed(getErrorFilterLocator2);
    }
}