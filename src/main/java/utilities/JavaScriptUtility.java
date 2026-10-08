package utilities;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility{

    public static void scrollToElementJS(By locator){
        WebElement element  = BasePage.getDriver().findElement(locator);
        String jsScript = "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});";
        ((JavascriptExecutor) BasePage.getDriver()).executeScript(jsScript, element);

    }

    public static void clickJs(By locator){
        WebElement element  = BasePage.getDriver().findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) BasePage.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


























}
