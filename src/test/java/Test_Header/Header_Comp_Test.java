package Test_Header;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comp_Header.Header_Comp;
import Comp_LeftSideBar.LeftSideBar_Comp;

public class Header_Comp_Test extends Header_Comp {
	
	
	@Test(priority = 4)
	public void CheckMenuBtn() throws IOException {
	    Header_Comp homepagecomp = new Header_Comp();
	    homepagecomp.CheckBurgerMenubtn();
	}

	@Test(priority = 5)
	public void CheckLeftSideBarContainer() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();
	    LeftSideBar.CheckLeftSideBarContainer();
	}

	@Test(priority = 6)
	public void CheckAllItems() throws IOException, InterruptedException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();
	    LeftSideBar.CheckLeftSideBarContainer();
	    LeftSideBar.AllItemsBtn();
	}
	@Test(priority = 7)
	public void CheckAbout() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();
	    LeftSideBar.CheckLeftSideBarContainer();
	    LeftSideBar.CheckAboutBtn();
	}

	@Test(priority = 7)
	public void CheckLogout() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();
	    LeftSideBar.CheckLeftSideBarContainer();
	    LeftSideBar.CheckLogoutBtn();
	}
	
	
	
}