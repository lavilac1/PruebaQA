package Configuration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

public class WebDriverHelper {

    final Duration EXPLICIT_TIMEOUT=Duration.ofSeconds(15);

    public static HashMap<String,String> WindowsHandle = new HashMap<>();

    public WebElement getElement(WebDriver driver, By loc){
        return isWebElementDisplayed (driver,loc)
                ? driver.findElement(loc)
                :null;
    }

    public boolean isWebElementDisplayed(WebDriver driver, By element){
        boolean isDisplayed;
        try {
            System.out.print(String.format("Waiting Element: %s", element));
            WebDriverWait wait= new WebDriverWait(driver,EXPLICIT_TIMEOUT);
            isDisplayed= wait.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed()
                    && wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
        }catch (NoSuchElementException | TimeoutException e){
            isDisplayed=false;
            System.out.print(String.valueOf(e));
        }
        System.out.print(String.format("%s Visibility is %s",element,isDisplayed));
        return isDisplayed;
    }

    public Alert isAlertPresent(WebDriver driver){
        Alert simpleAlert=null;

        try {

            WebDriverWait wait= new WebDriverWait(driver,EXPLICIT_TIMEOUT);
            wait.until(ExpectedConditions.alertIsPresent());
            simpleAlert=driver.switchTo().alert();
            System.out.print("Alert present");

        }catch (NoSuchElementException | TimeoutException e){

            System.out.print("Alert not present");
        }

        return simpleAlert;
    }

    public void getWindowsHandle(WebDriver driver, String windowsName){
        boolean alreadyExist;
        sleep(10);

        if (WindowsHandle.containsKey(windowsName)){
            driver.switchTo().window(WindowsHandle.get(windowsName));
            System.out.println(String.format("I go to windows : %s with value: %s",
                    windowsName,WindowsHandle.get(windowsName)));
            }else {
           for (String winHandle: driver.getWindowHandles()){
               for (String entry : WindowsHandle.keySet()){
                   String value= WindowsHandle.get(entry.trim());
                   alreadyExist= StringUtils.endsWithIgnoreCase(value,winHandle);
                   if(!alreadyExist){
                       WindowsHandle.put(windowsName,winHandle);
                       System.out.print("The new window"+ windowsName
                               + "is saved in scenario with value"
                               + WindowsHandle.get(windowsName));
                       driver.switchTo().window(winHandle);
                       break;
                   }
               }
           }

        }

        }

        public void sleep(int seconds){
            try {
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
            }
        }




}
