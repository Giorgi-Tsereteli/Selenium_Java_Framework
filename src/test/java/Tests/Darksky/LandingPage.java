package Tests.Darksky;

import Web.MyDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPage {

    /**
     * darksky.net
     * Verify the current date is highlighted in Time Machine's calendar
     */
    @Test
    public void verifyTodayDate() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        Pages.Darksky.LandingPage lPage = new Pages.Darksky.LandingPage();
        //lPage.clickBtn1(); // <-- Does not work.
        lPage.clickTimeMachineBtn2();
        // compare local date vs time machine date
        Assert.assertEquals(lPage.timeMachineDate(), lPage.localDate(), "Test Failed - Wrong Date Selected");
        MyDriver.quitWindows();
    }



    /**
     * darksky.net
     * Verify same values are displayed in the Today's data
     */
    @Test
    public void verifyTempBars() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        Pages.Darksky.LandingPage lpage = new Pages.Darksky.LandingPage();
        lpage.clickTodayToggle();
        // Compare displayed temp vs expanded details temp
        Assert.assertEquals(lpage.getTodayTemp(), lpage.getTodayExtraTemp(), "Test Failed - Displayed temp and expanded details don't match");
        MyDriver.quitWindows();
    }

}
