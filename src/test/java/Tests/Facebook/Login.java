package Tests.Facebook;

import Helper.Misc;
import Pages.Facebook.LandingPage;
import Pages.Instagram.InstaLandingPage;
import Web.MyDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

    @Test
    public void enterLoginInfo() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        LandingPage lPage = new LandingPage();
        lPage.enterLoginEmail("rickdeckard@bladerunner.com");
        lPage.enterLoginPassword("nexus6");
        Assert.assertTrue(lPage.isLoginButtonEnabled());
        Assert.assertTrue(lPage.isCreateNewAccBtnEnabled());
        lPage.clickCreateNewAccBtn();
        MyDriver.quitWindows();
    }


    /**
     * Due May 12
     * Launch facebook.com
     * Click on Facebook Pay, Oculus, Instagram, Portal and Bulletin
     * Close ALL windows except Instagram
     * Verify number of window-Handles is 1
     * Verify Page Title is Instagram
     * Verify Log in button on Instagram is disabled by default
     */
    @Test
    public void footerLinkVerification() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        LandingPage lPage = new LandingPage();

        lPage.clickFooterLinks();
        Misc.pause(5);
        lPage.closeTabs();

        InstaLandingPage obj = new InstaLandingPage();
        Assert.assertEquals(obj.instagramPageTitle(), "Instagram", "Test Failed - Title is not Instagram");
        Assert.assertFalse(obj.isInstaLoginBtnEnabled());
        Assert.assertEquals(obj.activeWindowCount(), 1, "Test Failed - more than 1 window handle");
        MyDriver.quitWindows();
    }
}