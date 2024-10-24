package Comp_LeftSideBar;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;  

import org.openqa.selenium.WebElement;

public class LeftSideBar_Comp extends LeftSidebarWebElements {

    public void CheckLeftSideBarContainer() throws IOException {
        WebElement container = getSideBarListContainer();
        assertNotNull(container);
    }
    public void CheckMenuBtn() throws IOException {

        WebElement container = CheckMenuButtonContainer();
        assertNotNull(container);

        driver.findElement(By.id("react-burger-menu-btn")).click();
        assertNotNull(driver.findElement(By.className("bm-menu-wrap")));
    }

    public void AllItemsBtn() throws IOException, InterruptedException {
        Actions action = new Actions(driver);
        WebElement AllItem = getAllItemsContainer();
        assertNotNull(AllItem);
        Thread.sleep(10000);
        action.moveToElement(AllItem).perform();
        action.click();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        System.out.println(driver.getCurrentUrl());
    }

    public void CheckAboutBtn() throws IOException {
        Actions action = new Actions(driver);
        WebElement About = getAboutContainer();
        assertNotNull(About);
        action.moveToElement(About).perform();
        action.click();
        assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }
    public void CheckLogoutBtn() throws IOException {
        Actions action = new Actions(driver);

        WebElement Logout = getLogoutContainer();
        assertNotNull(Logout);
        action.moveToElement(Logout).perform();
        action.click();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    public void CheckResetAppStateBtn() throws IOException {
        Actions action = new Actions(driver);
        WebElement ResetAppState = getResetAppStateContainer();
        assertNotNull(ResetAppState);
        action.moveToElement(ResetAppState).perform();
        action.click();
    }
}