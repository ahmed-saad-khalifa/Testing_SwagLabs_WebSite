package Comp_Header;
import java.util.List;

import org.openqa.selenium.WebElement;

import  Utility.FindingElements;


public class HeaderWebElement extends FindingElements{


	public WebElement CheckHeaderContainer() { return findElementByID("header_container");}
	public WebElement CheckLogoContainer() { return findElementByClassName("app_logo");}
	public WebElement CheckMenuButtonContainer() {return findElementByID("menu_button_container");}
	public WebElement CheckCartButtonContainer() {return findElementByID("shopping_cart_container");}
	public WebElement CheckProductTitleContainer() {return findElementByClassName("title");}
	public WebElement CheckDropdownListContainer() {return findElementByClassName("select_container");}
	public WebElement GetBackToProductsButton() {return findElementByClassName("left_component");}
	public WebElement GetDropDownContainer() {return findElementByClassName("product_sort_container");}
	public WebElement AtoZ() { return findElementByXPATH("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]");}
	public WebElement ZtoA() { return findElementByXPATH("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]");}
	public WebElement LowToHigh() {return findElementByXPATH("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]");}
	public WebElement HighToLow() {return findElementByXPATH("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");}
	public  List<WebElement> AllProducts(){ return  findingElementByIDInList("inventory_container");}
	public WebElement GetYourCartTitle() {return findElementByClassName("title");}
	public WebElement GetCheckoutTitle() {return findElementByClassName("title");}
	public WebElement GetCheckoutOverviewTiltle() { return findElementByClassName("title");}




}