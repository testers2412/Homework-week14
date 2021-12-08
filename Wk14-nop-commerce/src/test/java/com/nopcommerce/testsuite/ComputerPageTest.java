package com.nopcommerce.testsuite;

import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.pages.BuildYourOwnComputerPage;
import com.nopcommerce.pages.ComputerPage;
import com.nopcommerce.pages.DesktopsPage;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
@Listeners(CustomListeners.class)
public class ComputerPageTest extends TestBase {
    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;
    @BeforeMethod//(groups = {"smoke","sanity","regression"})
    public void inIt(){
        homePage= new HomePage();
        computerPage= new ComputerPage();
        desktopsPage= new DesktopsPage();
        buildYourOwnComputerPage=new BuildYourOwnComputerPage();
    }
    @BeforeMethod//(groups = {"smoke","sanity","regression"})
    @Test //(groups = {"smoke"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputerTab();
        computerPage.verifyComputerPage("Computers");
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnComputerTab();
        computerPage.clickOnDesktop();
        desktopsPage.verifyDesktopPage("Desktops");
    }
    @Test(dataProvider = "configuration", dataProviderClass = TestData.class)
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) throws InterruptedException {
        homePage.clickOnComputerTab();
        computerPage.clickOnDesktop();
        desktopsPage.clickOnBuildYourOwnComputer();
        buildYourOwnComputerPage.selectProcessor(processor);
       buildYourOwnComputerPage.selectRAM(ram);
        buildYourOwnComputerPage.selectHDD(hdd);
        buildYourOwnComputerPage.selectOS(os);
        buildYourOwnComputerPage.selectSoftware(software);
        buildYourOwnComputerPage.clickOnAddToCart();
        buildYourOwnComputerPage.verifyProductAddedToCart("The product has been added to your shopping cart");





    }
}

