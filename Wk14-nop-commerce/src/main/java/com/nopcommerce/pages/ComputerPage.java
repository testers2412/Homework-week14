package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import com.nopcommerce.drivermanager.ManageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ComputerPage extends Utility {

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computersText;

    @FindBy(xpath = "//a[@title='Show products in category Desktops'][normalize-space()='Desktops']")
    WebElement desktopsLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']")
    WebElement noteBooksLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Software']")
    WebElement softwareLink;

    public ComputerPage() {
        PageFactory.initElements(ManageDriver.driver, this);
    }
    public void verifyComputerPage(String expectedMessage){
        Reporter.log("Verify Computer Page : "+computersText.toString()+"<br>");
        pmVerifyElements(computersText,expectedMessage,"Wrong Page");
    }
    public void clickOnDesktop(){
        Reporter.log("Click On Desktop : "+desktopsLink.toString()+"<br>");
        pmClickOnElement(desktopsLink);
    }



}
