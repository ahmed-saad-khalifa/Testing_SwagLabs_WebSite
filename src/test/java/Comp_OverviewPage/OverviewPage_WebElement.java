package Comp_OverviewPage;
import java.util.List;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class OverviewPage_WebElement extends FindingElements {
	
	
	public WebElement GetCheckoutSummaryContainer() {return findElementByID("checkout_summary_container");}
	public List<WebElement>GetCartItems() {return findingElementByClassNameInList("cart_item");}
	public WebElement GetSummaryInfo() {return findElementByClassName("summary_info");}
	public WebElement GetFinishButton() {return findElementByID("finish");}
	public WebElement GetCancelButton() {return findElementByID("cancel");}
	public WebElement GetCartBadgeNumber() {return findElementByClassName("shopping_cart_badge");}
	

}