package utilities;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.WebDriver;

public class SwitchToUtility extends Utility{

    private static WebDriver.TargetLocator switchTo() {
        return  BasePage.getDriver().switchTo();
    }


    public static String getAlertMessage() {
        return switchTo().alert().getText();
    }







}
