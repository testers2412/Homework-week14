package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AdminPage extends Utility {

    @FindBy (xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement userManagement;

    @FindBy (xpath = "//a[@id='menu_admin_Job']")
    WebElement job;

    @FindBy (xpath = "//a[@id='menu_admin_Organization']")
    WebElement organizationTabs;
    @FindBy(xpath="//td[@class='left']//a")
    WebElement userNameOnTheList;




    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUsersNameIsInTheResultsTable(String uName){
        Reporter.log("Verifying the username displayed : " + userNameOnTheList.toString() + "<br>");
        pmVerifyElements(userNameOnTheList,uName,"User not displayed");

    }
}
