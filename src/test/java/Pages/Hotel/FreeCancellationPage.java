package Pages.Hotel;

import Pages.Commands;
import org.openqa.selenium.By;

public class FreeCancellationPage extends Commands {

    By freeCancellationHeadingLocator = By.xpath("//div[contains(@class,'PageHeading')]//*[contains(text(),'Amazing deals with free cancellation')]");

    public boolean isHeadingDisplayed() {
        return isElementDisplayed(freeCancellationHeadingLocator);
    }
}