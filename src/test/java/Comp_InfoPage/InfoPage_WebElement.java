package Comp_InfoPage;
import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class InfoPage_WebElement extends FindingElements{
	
	
	public WebElement GetCheckoutInfoContainer() {return findElementByID("checkout_info_container");}
	public WebElement GetFirstNameField() {return findElementByID("first-name");}
	public WebElement GetLastNameField() {return findElementByID("last-name");}
	public WebElement GetZipField() {return findElementByID("postal-code");}
	public WebElement GetErrorMessageContainer() {return findElementByClassName("error-message-container");}
	public WebElement GetCancelBtn() {return findElementByID("cancel");}
	public WebElement GetContiueBtn() {return findElementByID("continue");}
	
	
	
	

}