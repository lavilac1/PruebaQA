package PageObjects;

import org.openqa.selenium.By;

public class SerenityPageObjects {
    public By sessionElm= By.id("LoginPanel0_LoginButton");
    public By northwindElm= By.xpath("//span[contains(text(),'Northwind')]");
    public By clientsElm= By.xpath("//i[@class='s-sidebar-icon fa fa-credit-card']");
    public By newclient= By.xpath("//i[@class='fa fa-plus-circle text-green']");
    public By ID= By.name("CustomerID");
    public By name= By.name("CompanyName");
    public By contactName= By.name("ContactName");
    public By contactTitle= By.name("ContactTitle");
    public By represent= By.id("s2id_autogen10");
    public By representselec= By.id("//ul[@class='select2-results']//div[contains(text(),'Anne')]");

    public By address= By.name("Address");
    public By country= By.name("select2-chosen-11");
    public By city= By.name("select2-chosen-12");
    public By region= By.name("Region");
    public By postalCode= By.name("PostalCode");
    public By phone= By.name("Phone");
    public By fax= By.name("Fax");
    public By lastContactDate= By.name("LastContactDate");
    public By contact= By.id("select2-drop");
    public By email= By.name("Email");
    public By sendbulletin= By.name("SendBulletin");
    public By saved= By.xpath("//div[@class='tool-button save-and-close-button icon-tool-button']");


    public By productEl= By.xpath("//i[@class='s-sidebar-icon fa fa-cube']");
    public By newprduct= By.xpath("//i[@class='fa fa-plus-circle text-green']");
    public By nameprduc= By.name("ProductName");
    public By UnitsInStock= By.name("UnitsInStock");
    public By UnitsOnOrder= By.name("UnitsOnOrder");
    public By ReorderLevel= By.name("ReorderLevel");











}
