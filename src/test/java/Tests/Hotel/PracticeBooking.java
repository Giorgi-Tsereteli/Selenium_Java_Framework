package Tests.Hotel;

import Helper.Misc;
import Pages.Hotel.PracticeLandingPage;
import Web.MyDriver;
import org.testng.annotations.Test;

public class PracticeBooking {

    /**
     *  My practice version of same code that we did in class
     */

    //Select day in calendar
    @Test
    public void selectJuneDay() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        PracticeLandingPage obj = new PracticeLandingPage();
        obj.clickCheckInBtn();
        obj.selectCheckoutDay("17");
        Misc.pause(3);
        MyDriver.quitWindows();
    }

    // Select from suggestion list
    @Test
    public void selectFromSuggestions() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        PracticeLandingPage obj = new PracticeLandingPage();
        obj.clickSearchBar();
        obj.typeInSearchBar();
        obj.clickOnSuggestion();
        Misc.pause(3);
        MyDriver.quitWindows();
    }

    // Fully automate calendar for user input "November 17 2022"
    @Test
    public void scrollInCalendar() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
        PracticeLandingPage obj = new PracticeLandingPage();
        obj.clickCheckInBtn();
        obj.selectDayMonthYear("17 November 2022");
        Misc.pause(3);
        MyDriver.quitWindows();
    }
}
