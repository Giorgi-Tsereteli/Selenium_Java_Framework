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


    @Test
    public void footerLinkVerification() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
        LandingPage lPage = new LandingPage();

        lPage.clickFooterLinks();
        Misc.pause(4);
        lPage.closeTabs();

        InstaLandingPage obj = new InstaLandingPage();
        Assert.assertEquals(obj.instagramPageTitle(), "Instagram", "Test Failed - Title is not Instagram");
        Assert.assertFalse(obj.isInstaLoginBtnEnabled());
        Assert.assertEquals(obj.activeWindowCount(), 1, "Test Failed - more than 1 window handle");
        MyDriver.quitWindows();
    }
}