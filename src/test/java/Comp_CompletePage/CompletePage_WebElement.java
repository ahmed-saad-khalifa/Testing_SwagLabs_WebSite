package Comp_CompletePage;
import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class CompletePage_WebElement extends FindingElements{
	public WebElement GEtCheckoutCompleteTitle() {return findElementByClassName("title");}
	public WebElement GetCheckoutCompleteContainer() {return findElementByID("checkout_complete_container");}
	public  WebElement GetImage() {return findElementByClassName("pony_express");}
	public WebElement GetCompleteText() {return findElementByClassName("complete-text");}
	public WebElement GetBackHomeBtn() {return findElementByID("back-to-products");}

}