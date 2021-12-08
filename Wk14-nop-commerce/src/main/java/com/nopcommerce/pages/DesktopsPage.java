package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DesktopsPage extends Utility {
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsText;

    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortBy;

    @FindBy(xpath = "//select[@id='products-pagesize']")
    WebElement display;

    @FindBy(xpath = "//a[normalize-space()='List']")
    WebElement selectProductList;
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputer;



    public DesktopsPage() {
        PageFactory.initElements(driver,this);
    }
    public void verifyDesktopPage(String expectedMessage){
        Reporter.log("Verify Desktop Page : "+desktopsText.toString()+"<br>");
        pmVerifyElements(desktopsText,expectedMessage,"wrong page");
    }
    public void clickOnBuildYourOwnComputer(){
        Reporter.log("Click on Build your own Computer : "+buildYourOwnComputer.toString()+"<br>");
        pmClickOnElement(buildYourOwnComputer);
    }



}
