package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();

    }

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    @Parameters({"username", "password"})
    public void loginSuccessfully(String uname, String pword){
        loginPage.enterTheUsernameInTheUsernameField(uname);
        loginPage.enterThePasswordInThePasswordField(pword);
        loginPage.clickOnTheLoginButton();
    }


    @Test//(priority = 1,groups = {"smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully(){
        homePage.verifyTheWelcomeMessage();
    }

    @Test//(priority = 2,groups = {"sanity", "regression"} )
    public void verifyThatTheLogoDisplayOnHomePage(){
        homePage.verifyTheOrangeHRMLogo();
    }

    @Test//(priority = 3,groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        loginPage.clickOnTheLogOutButton();
        loginPage.verifyTheLoginPanelText();
    }





}
