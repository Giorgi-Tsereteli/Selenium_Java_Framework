package Pages.Hotel;

import Pages.Commands;
import org.openqa.selenium.By;

public class AppPage extends Commands {

    By searchBookGoHeadingLocator = By.xpath("//*[contains(text(),'Search, book, and save')]");

    public boolean isHeadingDisplayed() {
        return isElementDisplayed(searchBookGoHeadingLocator);
    }
}