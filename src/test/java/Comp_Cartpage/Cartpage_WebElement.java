package Comp_Cartpage;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class Cartpage_WebElement extends FindingElements {


	public WebElement getCartPageContainer() {return findElementByID("cart_contents_container");}
	public WebElement getCartPageProduct() {return findElementByClassName("cart_item");}
	public WebElement getYourCartSubTitle() {return findElementByClassName("title");}
	public WebElement getQuantityLabel() {return findElementByClassName("cart_quantity_label");}
	public WebElement getDescriptionSubLabel() {return findElementByClassName("cart_desc_label");}
	public WebElement getRemoveButton() {return findElementByClassName("cart_button");}
	public WebElement getCheckOutButton() {return findElementByID("checkout");}
	public WebElement getContinueShoppingButton() {return findElementByID("continue-shopping");}
	public WebElement getCartButton() {return findElementByClassName("shopping_cart_link");}
	public WebElement getCartButtonNumber() {return findElementByClassName("shopping_cart_badge");}
	
	
	
	
	
}
