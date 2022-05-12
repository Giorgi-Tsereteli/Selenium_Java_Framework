package Tests.Darksky;

import Helper.Misc;
import Web.MyDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.Darksky.LandingPage;

public class TemperatureTest {

    /**
     * Due May 12
     * darksky.net
     * Verify the current date is highlighted in Time Machine's calendar
     */
    @Test
    public void verifyTodayDate() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        LandingPage lpage = new LandingPage();

        //lPage.clickBtn1(); // <-- Does not work.
        lpage.clickTimeMachineBtn2();
        Misc.pause(2);

        Assert.assertEquals(lpage.timeMachineDate(), lpage.localDate(), "Test Failed - Wrong Date Selected");
        MyDriver.quitWindows();
    }


    /**
     * Due May 12
     * darksky.net
     * Verify same values are displayed in the Today's data
     */
    @Test
    public void verifyTempBars() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        LandingPage lpage = new LandingPage();

        lpage.clickTodayToggle();
        Misc.pause(2);

        // Compare displayed temp vs expanded details temp
        Assert.assertEquals(lpage.getTodayTemp(), lpage.getTodayExtraTemp(), "Test Failed - Displayed temp and expanded details don't match");
        MyDriver.quitWindows();
    }

}
