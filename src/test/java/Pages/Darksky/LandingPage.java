package Pages.Darksky;

import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LandingPage extends Commands {

    // Locator Variables
    // Time Machine:
    By timeMachineLocator = By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']");
    By daySelectedLocator = By.xpath("//td[@class='is-today']");
    By monthSelectedLocator = By.xpath("//select[@class='pika-select pika-select-month']/option[@selected='selected']");
    By yearSelectedLocator = By.xpath("//select[@class='pika-select pika-select-year']/option[@selected='selected']");

    //Temperature Bars:
    By todayToggleLocator = By.xpath("(//span[@class='toggle'])[1]");
    By todayMinTemp = By.xpath("(//span[@class='minTemp'])[1]");
    By todayMaxTemp = By.xpath("(//span[@class='maxTemp'])[1]");
    By dayExtrasMinTemp = By.xpath("((//div[@class='dayExtras']/div)[1]//span[@class='temp'])[1]");
    By dayExtrasMaxTemp = By.xpath("((//div[@class='dayExtras']/div)[1]//span[@class='temp'])[2]");


    // Methods
    // Time Machine:
    public WebElement scrollToTimeMachineButton() {
        return scrollToElement(timeMachineLocator);
    }

    public void clickTimeMachineBtn() {
        scrollToTimeMachineButton().click(); // < --- why it does not work?
        // When I debug, it never scrolls. It just never throws exception to get into catch block and scroll
    }

    public void clickTimeMachineBtn2() {
        scrollAndClickElement(timeMachineLocator);
    }

    public String timeMachineDate() {
        String day = getElementText(daySelectedLocator);
        String month = getElementText(monthSelectedLocator);
        String year = getElementText(yearSelectedLocator);
        return month + ":" + day + ":" + year;
    }

    public String localDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM:dd:yyyy");
        String dateLocal = sdf.format(d);
        return dateLocal;
    }


    // Temp Bar:
    public void clickTodayToggle() {
        scrollAndClickElement(todayToggleLocator);
    }

    public String getTodayTemp() {
        String min = getElementText(todayMinTemp).split("˚")[0];
        String max = getElementText(todayMaxTemp).split("˚")[0];
        return min + " | " + max;
    }

    public String getTodayExtraTemp() {
        String min = getElementText(dayExtrasMinTemp).split("˚")[0];
        String max = getElementText(dayExtrasMaxTemp).split("˚")[0];
        return min + " | " + max;
    }
}
