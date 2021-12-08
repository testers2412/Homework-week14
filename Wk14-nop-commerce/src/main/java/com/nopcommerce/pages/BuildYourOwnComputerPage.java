package com.nopcommerce.pages;

import com.nopcommerce.drivermanager.ManageDriver;
import com.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement buildYourOwnComputerText;
    @FindBy(xpath = "//dd[1]//select[1]")
    WebElement processorTab;
    @FindBy(xpath = "//select[@class='valid']//option[@value='1']")
    WebElement processorOption1;
    @FindBy(xpath = "//select[@class='valid']//option[@value='2']")
    WebElement processorOption2;
    @FindBy(xpath = "//dd[2]//select[1]")
    WebElement ramTab;
    @FindBy(xpath = "//dd[2]//select[1]//option[@value='3']")
    WebElement ramTabOption1;
    @FindBy(xpath = "//dd[2]//select[1]//option[@value='4']")
    WebElement ramTabOption2;
    @FindBy(xpath = "//dd[2]//select[1]//option[@value='5']")
    WebElement ramTabOption3;
    @FindBy(xpath = "//label[@for='product_attribute_3_6']")
    WebElement hdd320GB;
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement hdd400GB;
    @FindBy(xpath = "//label[@for='product_attribute_4_8']")
    WebElement osVistaHome;
    @FindBy(xpath = "//label[@for='product_attribute_4_9']")
    WebElement osVistaPremium;
    @FindBy(xpath = "//label[@for='product_attribute_5_10']")
    WebElement softwareMSOffice;
    @FindBy(xpath = "//label[@for='product_attribute_5_12']")
    WebElement softwareTotalCommander;
    @FindBy(xpath = "//label[@for='product_attribute_5_11']")
    WebElement softwareAcrobatReader;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//p[@class='content']")
    WebElement productAddedToCartMessage;
    public BuildYourOwnComputerPage(){PageFactory.initElements(ManageDriver.driver, this);}

    public void selectProcessor(String processor) throws InterruptedException {
        Reporter.log("Select Processor : " + processor + "<br>");
        pmSelectByContainsTextFromDropDown(processorTab, processor);
    }

    public void selectRAM(String ram) throws InterruptedException {
        Reporter.log("Select RAM : " + ram + "<br>");
        pmSelectByContainsTextFromDropDown(ramTab, ram);
    }

    public void selectHDD(String hdd) {
        Reporter.log("Select HDD : " + hdd + "<br>");
        if (hdd.equalsIgnoreCase("320 GB")) {
            hdd320GB.click();
        } else if (hdd.equalsIgnoreCase("400 GB [+$100.00]")) {
            hdd400GB.click();
        }
    }

    public void selectOS(String os) {
        Reporter.log("Select OS : " + os + "<br>");
        if (os.equalsIgnoreCase("Vista Home [+$50.00]")) {
            osVistaHome.click();
        } else if (os.equalsIgnoreCase("Vista Premium [+$60.00]")) {
            osVistaPremium.click();
        }
    }

    public void selectSoftware(String software) {
        Reporter.log("Select OS : " + software + "<br>");
        if (software.equalsIgnoreCase("Microsoft Office [+$50.00]")) {
            softwareMSOffice.click();
        } else if (software.equalsIgnoreCase("Acrobat Reader [+$10.00]")) {
            softwareAcrobatReader.click();
        } else if (software.equalsIgnoreCase("Total Commander [+$5.00]")) {
            softwareTotalCommander.click();
        }

    }

    public void clickOnAddToCart() {
        Reporter.log("Click On add to cart : " + addToCartButton + "<br>");
        pmClickOnElement(addToCartButton);
    }

    public void verifyProductAddedToCart(String expectedMessage) {
        pmVerifyElements(productAddedToCartMessage, expectedMessage, "product not added");

    }
}
