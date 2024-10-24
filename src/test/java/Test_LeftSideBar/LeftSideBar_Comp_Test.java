package Test_LeftSideBar;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comp_LeftSideBar.LeftSideBar_Comp;

public class LeftSideBar_Comp_Test extends LeftSideBar_Comp{
	@BeforeMethod
	public void OpenBrowser() throws Exception {
		driver = new ChromeDriver();
	    driver.navigate().to("https://www.saucedemo.com/");

	    driver.manage().window().maximize();
	    findElementByID("username").sendKeys("standard_user");
	    findElementByID("password").sendKeys("secret_sauce");

	    findElementByID("login-button").click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority = 1)
	public void CheckLeftSideBarContainer() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();

	    LeftSideBar.CheckBurgerMenubtn();
	    LeftSideBar.CheckLeftSideBarContainer();
	}

	@Test(priority = 2)
	public void CheckAllItems() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();

	    LeftSideBar.CheckLeftSideBarContainer();
	    LeftSideBar.AllItemsBtn();
	}
	
	@Test(priority = 3)
	public void CheckAboutBtn() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();

	    LeftSideBar.CheckLeftSideBarContainer();
	    LeftSideBar.CheckAboutBtn();
	}
	@Test(priority = 4)
	public void CheckLogoutBtn() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();

	    LeftSideBar.CheckLeftSideBarContainer();
	    LeftSideBar.CheckLogoutBtn();
	}
	@Test(priority = 5)
	public void CheckResetAppStateBtn() throws IOException {
	    LeftSideBar_Comp LeftSideBar = new LeftSideBar_Comp();
	    LeftSideBar.CheckBurgerMenubtn();

	    LeftSideBar.CheckLeftSideBarContainer();
	    LeftSideBar.CheckResetAppStateBtn();
	}
	
	@AfterMethod
	public void CloseBrowser() throws Exception {
		closeDriver(null);
		
	}
	
}
