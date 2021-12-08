package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @FindBy(xpath = "//h1[normalize-space()='Register']")
    WebElement registerText;

    @FindBy(xpath = "//span[@class='male']")
    WebElement maleRadio;

    @FindBy(xpath = "//span[@class='female']")
    WebElement femaleRadio;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement birthDayDropDown;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement birthMonthDropDown;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement birthYearDropDown;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameRequiredErrorMessage;

    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameRequiredErrorMessage;

    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailIsRequiredErrorMessage;

    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordIsRequiredErrorMessage;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmationPasswordErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompleteMessage;

    @FindBy(xpath = "(//a[normalize-space()='Continue'])[1]")
    WebElement continueButton;
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutButton;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginOption;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;


    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }
    public void selectGender(String gender){
        Reporter.log("Select Gender : " + femaleRadio.toString() + "<br>"+"Select Gender : " + maleRadio.toString() + "<br>");
        if(gender.equalsIgnoreCase("Female")){
            pmClickOnElement(femaleRadio);
        }else if(gender.equalsIgnoreCase("male")){
            pmClickOnElement(maleRadio);
        }else{
            System.out.println("Entered wrong gender");
        }
    }
    public void enterFirstName(String firstNameValue){
        Reporter.log("Entering the First Name : " + firstName.toString() + "<br>");
        pmSendTextToElement(firstName,firstNameValue);

    }
    public void enterLastName(String lastNameValue){
        Reporter.log("Entering the last Name : " + lastName.toString() + "<br>");
        pmSendTextToElement(lastName,lastNameValue);
    }
    public void selectBirthDay(String value){
        Reporter.log("Entering the Birth day : " + birthDayDropDown.toString() + "<br>");
        pmSelectByValueFromDropDown(birthDayDropDown,value);
    }
    public void selectBirthMonth(String value){
        Reporter.log("Entering the Birth Month : " + birthMonthDropDown.toString() + "<br>");
        pmSelectByValueFromDropDown(birthMonthDropDown,value);
    }
    public void selectBirthYear(String value){
        Reporter.log("Entering the Birth Year : " + birthYearDropDown.toString() + "<br>");
        pmSelectByValueFromDropDown(birthYearDropDown,value);
    }
    public void enterEmail(String emailAddress){
        Reporter.log("Entering the email : " + email.toString() + "<br>");
        pmSendTextToElement(email,emailAddress);
    }
    public void enterPassword(String passwordValue){
        Reporter.log("Entering the password : " + password.toString() + "<br>");
        pmSendTextToElement(password,passwordValue);
    }
    public void enterConfirmPassword(String confirmPasswordValue){
        Reporter.log("Entering the Confirm Password : " + confirmPassword.toString() + "<br>");
        pmSendTextToElement(confirmPassword,confirmPasswordValue);

    }
    public void clickOnRegisterButton(){
        Reporter.log("Click on Register : " + registerButton.toString() + "<br>");
        pmClickOnElement(registerButton);
    }
    public void verifyRegistrationComplete(String expectedMessage){
        Reporter.log("Verify the register Tex : " + registerText.toString() + "<br>");

        pmVerifyElements(registerText,expectedMessage,"Wrong Page");

    }
    public void clickOnRegisterLink(){

        pmClickOnElement(registerLink);
    }
    public String gettextRegistertext(){
        Reporter.log("getOnRegisterText : " + registerText.toString() + "<br>");
        return pmGetTextFromElement( registerText);
    }
    public void verifyRegisterText(){
        Reporter.log("verifying the RegistrText : " +registerText.toString() + "<br>");
        pmVerifyElements(registerText,"Register","RegisterText is not displayed");

    }
    public void verifyTheErrorMessageFirstNameIsRequired(){
        Reporter.log("Verifying the first name is required : " + firstNameRequiredErrorMessage.toString() + "<br>");
        pmVerifyElements(firstNameRequiredErrorMessage, "First name is required.","First name error message is displayed incorrectly");
    }

    public void verifyTheErrorMessageLastNameIsRequired(){
        Reporter.log("Verifying the last name is required : " + lastNameRequiredErrorMessage.toString() + "<br>");
        pmVerifyElements(lastNameRequiredErrorMessage, "Last name is required.","Last name error message is displayed incorrectly");
    }

    public void verifyTheErrorMessageEmailIsRequired(){
        Reporter.log("Verifying email is required : " + emailIsRequiredErrorMessage.toString() + "<br>");
        pmVerifyElements(emailIsRequiredErrorMessage, "Email is required.","Email error message is displayed incorrectly");

    }

    public void verifyTheErrorMessagePasswordIsRequired(){
        Reporter.log("Verifying password is required : " + passwordIsRequiredErrorMessage.toString() + "<br>");
        pmVerifyElements(passwordIsRequiredErrorMessage, "Password is required.","Password error message is displayed incorrectly");

    }

    public void verifyTheErrorMessageForConfirmPasswordIsRequired(){
        Reporter.log("Verifying Confirmation password is required : " + confirmationPasswordErrorMessage.toString() + "<br>");
        pmVerifyElements(confirmationPasswordErrorMessage, "Password is required.","Confirm Password error message is displayed incorrectly");

    }



}
