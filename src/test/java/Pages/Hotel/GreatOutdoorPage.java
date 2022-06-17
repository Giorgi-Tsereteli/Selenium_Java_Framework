package Pages.Hotel;

import Pages.Commands;
import org.openqa.selenium.By;

public class GreatOutdoorPage extends Commands {

    By saveOnNextTripHeadingLocator = By.xpath("//ul[@class='breadcrumb']/following-sibling::div/*[contains(text(),'Save on your next')]");

    public boolean isHeadingDisplayed() {
        return isElementDisplayed(saveOnNextTripHeadingLocator);
    }
}
