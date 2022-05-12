package Pages.Instagram;

import Pages.Commands;
import org.openqa.selenium.By;

public class InstaLandingPage extends Commands {

    // Locator Variables
    // Login Form:
    By instagramLoginBtnLocator = By.xpath("//button[@disabled]");


    // Methods
    public int activeWindowCount() {
        return myWindowHandles().size();
    }

    public String instagramPageTitle() {
        return pageTitle();
    }

    public boolean isInstaLoginBtnEnabled() {
        return isElementEnabled(instagramLoginBtnLocator);
    }

}
