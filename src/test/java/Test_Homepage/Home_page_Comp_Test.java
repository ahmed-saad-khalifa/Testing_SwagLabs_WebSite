package Test_Homepage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comp_Header.HeaderWebElement;
import Comp_Homepage.Home_page_Comp;
import Comp_Homepage.Homepage_WebElement;
import Comp_Loginpage.Login_page_Comp;
import Utility.FindingElements;

public class Home_page_Comp_Test extends Home_page_Comp {
	@BeforeMethod
	public void OpenBrowser() throws Exception {
		SetUpTheDriver();
		
	}
	
	
	
	
	
	
	@Test
	public void CheckIfNumberBadgetAddedToCartIcon() throws IOException {
		Login_page_Comp loginPageComp = new Login_page_Comp();
	    loginPageComp.CheckIfUserLoginWithValidData();

	    ClickOnAddToCartButton();

	    CheckTheNumberBadgedAddedToCartIcon();
	}

	@Test
	public void CheckIfTextAndColorForRemoveButtonAppear() throws IOException {
		Login_page_Comp loginPageComp = new Login_page_Comp();
	    loginPageComp.CheckIfUserLoginWithValidData();

	    ClickOnAddToCartButton();
	    CheckTheNumberBadgedAddedToCartIcon();

	    CheckTextAndColorForRemoveButton();
	}

	@Test
	public void CheckHomePageOpened() throws InterruptedException, IOException {
		Login_page_Comp loginPageComp = new Login_page_Comp();
	    loginPageComp.CheckIfLoginPageOpened();
	}
	@Test
	public void ClickOnTheRemoveButton() throws IOException {
		Login_page_Comp loginPageComp = new Login_page_Comp();
	    loginPageComp.CheckIfUserLoginWithValidData();

	    ClickOnAddToCartButton();

	    ClickOnTheRemoveButton();

	    CheckTextAndColorForRemoveButton();
	}
	@Test
	public void CheckIfNumberCounterDisappear() throws IOException {
		Login_page_Comp loginPageComp = new Login_page_Comp();
	    loginPageComp.CheckIfUserLoginWithValidData();

	    ClickOnAddToCartButton();

	    ClickOnTheRemoveButton();

	    CheckTheCounterNumberDisappear();
	}
	
	@AfterMethod
	public void CloseBrowser() throws Exception {
		closeDriver(null);
		
	}
	
	
}
