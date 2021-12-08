package com.nopcommerce.testsuite;

import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.pages.RegisterPage;
import com.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class RegisterPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPagsuccessFully() {
        homePage.clickOnRegisterLink();
        registerPage.gettextRegistertext();
        registerPage.verifyRegisterText();

    }

        @Test
    public void verifyThatFirstNameLastNameEmailAndPasswordAndConfirmPasswordFieldsAreMandatory(){


        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        registerPage.verifyTheErrorMessageFirstNameIsRequired();
        registerPage.verifyTheErrorMessageLastNameIsRequired();
        registerPage.verifyTheErrorMessageEmailIsRequired();
        registerPage.verifyTheErrorMessagePasswordIsRequired();
        registerPage.verifyTheErrorMessageForConfirmPasswordIsRequired();
    }


    @Test
    public void VerifyThatUserShouldCreateAccountSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.selectGender("Female");
        registerPage.enterFirstName("Prime");
        registerPage.enterLastName("Testing");
        registerPage.selectBirthDay("2");
        registerPage.selectBirthMonth("4");
        registerPage.selectBirthYear("1983");
        registerPage.enterEmail("tiapatel@gmail.com");
        registerPage.enterPassword("Prime123");
        registerPage.enterConfirmPassword("Prime123");
        registerPage.clickOnRegisterButton();
        registerPage.verifyRegistrationComplete("Register");
    }
}
