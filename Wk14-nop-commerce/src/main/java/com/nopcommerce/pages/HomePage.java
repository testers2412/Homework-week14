package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import com.nopcommerce.drivermanager.ManageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//li")
    WebElement allMenu;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLink;

    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement registerLink;

    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopcommerceLogo;

    @FindBy(xpath = "")
    WebElement myAccountLink;

    @FindBy(xpath = "")
    WebElement logOutLink;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerTab;

    public HomePage() {
        PageFactory.initElements(ManageDriver.driver, this);
    }

    public void clickOnLogInLink(){
        Reporter.log("Click on Login Link : " +loginLink.toString() + "<br>");
        pmClickOnElement(loginLink);
    }
    public void clickOnRegisterLink(){
        Reporter.log("Click on Register Link : " +registerLink.toString() + "<br>");
        pmClickOnElement(registerLink);
    }
    public void clickOnComputerTab(){
        Reporter.log("Click on computer link : " +computerTab.toString() + "<br>");
        pmClickOnElement(computerTab);
    }
}
