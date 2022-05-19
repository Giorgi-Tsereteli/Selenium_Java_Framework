package Web;

import Helper.Misc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyDriver {

    private static WebDriver driver;


    public static void launchUrlOnNewWindow(String url) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        Misc.pause(5);
    }


    public static WebDriver getDriver() {
        return driver;
    }


    public static void quitWindows() {
        driver.quit();
    }

}
