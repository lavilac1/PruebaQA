package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;

import PageObjects.SerenityPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;

public class Serenity extends WebDriverHelper {


        SerenityPageObjects serenityPageObjects = new SerenityPageObjects();
        WebDriver driver = null;
        WebDriverFactory webDriverFactory = new WebDriverFactory();


        //**Instanciar Web Driver- configuraciones- Data de la prueba
        @BeforeTest
        public void setUP() {

            driver = webDriverFactory.createWebDriver("CHROME_WEB_DRIVER", "https://demo.serenity.is/Account/Login/?ReturnUrl=%2F");

        }

        //**Prueba
        @Test
        public void seleniumTestCreateClient() {
            //convertir lo elementos para que selenium los interprete
            WebElement session = getElement(driver, serenityPageObjects.sessionElm);
            session.click();
            WebElement northwind = getElement(driver, serenityPageObjects.northwindElm);
            northwind.click();
            sleep(10);
            WebElement clients = getElement(driver, serenityPageObjects.clientsElm);
            clients.click();
            WebElement newclient = getElement(driver, serenityPageObjects.newclient);
            newclient.click();

            WebElement Customer  = getElement(driver, serenityPageObjects.ID);
            Customer.sendKeys("10171");

            WebElement Company   = getElement(driver, serenityPageObjects.name);
            Company.sendKeys("Mercados");

            WebElement contactName   = getElement(driver, serenityPageObjects.contactName);
            contactName.sendKeys("Luisa");

            WebElement title   = getElement(driver, serenityPageObjects.contactTitle);
            title.sendKeys("Sra");


/*
            WebElement represent   = getElement(driver, serenityPageObjects.represent);
            represent.click();
            sleep(1);
            WebElement representselec   = getElement(driver, serenityPageObjects.representselec);
            representselec.click();
*/
            WebElement address   = getElement(driver, serenityPageObjects.address);
            address.sendKeys("Calle98");

            WebElement saved   = getElement(driver, serenityPageObjects.saved);
            saved.click();




        }

    @Test
    public void seleniumTestCreateProdcut() {
        //convertir lo elementos para que selenium los interprete
        WebElement session = getElement(driver, serenityPageObjects.sessionElm);
        session.click();
        WebElement northwind = getElement(driver, serenityPageObjects.northwindElm);
        northwind.click();
        sleep(10);
        WebElement productEl = getElement(driver, serenityPageObjects.productEl);
        productEl.click();
        WebElement newprduct = getElement(driver, serenityPageObjects.newprduct);
        newprduct.click();

        WebElement nameprduc  = getElement(driver, serenityPageObjects.nameprduc);
        nameprduc.sendKeys("Cama");

        WebElement UnitsInStock   = getElement(driver, serenityPageObjects.UnitsInStock);
        UnitsInStock.sendKeys("5");

        WebElement UnitsOnOrder   = getElement(driver, serenityPageObjects.UnitsOnOrder);
        UnitsOnOrder.sendKeys("2");

        WebElement ReorderLevel   = getElement(driver, serenityPageObjects.ReorderLevel);
        ReorderLevel.sendKeys("2");


        WebElement saved   = getElement(driver, serenityPageObjects.saved);
        saved.click();



    }

        //**Cerrar
        @AfterTest
        public void tearDown() {

            driver.quit();

        }
    }

