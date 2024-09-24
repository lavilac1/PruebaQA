package Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    WebDriver driver=null;
    public WebDriverFactory(){

    }

    public WebDriver createWebDriver(String browser,String url){

        try {

            if (StringUtils.equalsIgnoreCase(browser,"CHROME")){
                System.out.print("Creating CHROME Session...");
               System.setProperty("webdriver.chrome.driver","./target/test-classes/bin/chromedriver.exe");
                //System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
                driver=new ChromeDriver();
            }else if (StringUtils.equalsIgnoreCase(browser,"FIREFOX")){
                System.out.print("Creating FIREFOX Session...");
                System.setProperty("webdriver.chrome.driver","./geckodriver.exe");
                driver=new FirefoxDriver();

            }else if(StringUtils.equalsIgnoreCase(browser,"CHROME_WEB_DRIVER")){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();

            }else {
                System.out.println(String.format("No drivers configured for this param"));
            }

        }catch (Exception e){
            throw new SkipException("Skipping the test case, review configuration driver");
        }



        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }
}
