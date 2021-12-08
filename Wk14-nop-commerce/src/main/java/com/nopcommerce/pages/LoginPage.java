package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import com.nopcommerce.drivermanager.ManageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginPage extends Utility {

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailText;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordText;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement logInButton;

    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welComeText;
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutOption;
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutButton;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginOption;



    public LoginPage() {
        PageFactory.initElements(ManageDriver.driver, this);
    }

    public void verifyWelcomeMessage(){
        Reporter.log("verifying the welcome message : " + welComeText.toString() + "<br>");
    String expectedMessage = "Welcome, Please Sign In!";
    String actualMessage = pmGetTextFromElement(welComeText);
        Assert.assertEquals(actualMessage,"Welcome, Please Sign In!","wrong page");

    //pmVerifyElements(welComeText,"Welcome, Please Sign In!","wrong page");
}

    public void enterEmail(String email){
        Reporter.log("Entering the email : " + email.toString() + "<br>");
        pmSendTextToElement(emailText,email);
    }

    public void enterPassword(String password){
        Reporter.log("Entering the password : " + password.toString() + "<br>");
        pmSendTextToElement(passwordText,password);

    }

    public void clickOnLoginButton(){
        Reporter.log("Clicking the login button : " + logInButton.toString() + "<br>");
        pmClickOnElement(logInButton);
    }
    public void verifyErrorMessage(){

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = pmGetTextFromElement(errorMessage);
        Assert.assertEquals( actualErrorMessage,expectedErrorMessage,"Error message not displayed");
    }
    public void verifyLogOutOption() {
        Reporter.log("verifying the Log out Option: " + logOutOption.toString() + "<br>");
        pmVerifyElements(logOutOption, "Log out", "wrong option");

    }

    public void clickOnLogOutButton() {
        Reporter.log("Clicking on Log out Button " + logOutButton.toString() + "<br>");
        pmClickOnElement(logOutButton);
    }

    public void verifyLoginOption() {
        Reporter.log("verifying the Log in Option: " + loginOption.toString() + "<br>");
        pmVerifyElements(loginOption, "Log in", "wrong option");

    }

}
