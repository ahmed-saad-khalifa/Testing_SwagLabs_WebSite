package Comp_LeftSideBar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Comp_Header.Header_Comp;

public class LeftSidebarWebElements extends Header_Comp {

    public WebElement getSideBarListContainer()throws IOException {return findElementByClassName("bm-item-list"); }
    public WebElement getAllItemsContainer() throws IOException {return findElementByID("inventory_sidebar_link"); }
    public WebElement getAboutContainer() throws IOException {return findElementByID("about_sidebar_link"); }
    public WebElement getLogoutContainer()throws IOException {return findElementByID("logout_sidebar_link"); }
    public WebElement getResetAppStateContainer() throws IOException {return findElementByID("reset_sidebar_link"); }
}