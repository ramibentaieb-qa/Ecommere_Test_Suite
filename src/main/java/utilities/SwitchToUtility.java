package utilities;

import org.openqa.selenium.WebDriver;

public class SwitchToUtility extends Utility{

    private static WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }


    public static String getAlertMessage() {
        return switchTo().alert().getText();
    }







}
