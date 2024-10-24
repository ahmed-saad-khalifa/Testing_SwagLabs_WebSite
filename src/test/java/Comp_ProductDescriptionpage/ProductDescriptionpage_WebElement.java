package Comp_ProductDescriptionpage;
import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class ProductDescriptionpage_WebElement extends FindingElements{
	
	public WebElement GetProductDetailsContainer() {return findElementByClassName("inventory_details_container");}
	public WebElement GetProductImage() {return findElementByClassName("inventory_details_img_container");}
	public WebElement GetRemoveBtn() {return findElementByClassName("btn_inventory");}

}