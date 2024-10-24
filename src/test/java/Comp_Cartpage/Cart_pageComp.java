package Comp_Cartpage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.WaitingMethod;
import Comp_Homepage.Home_page_Comp;
public class Cart_pageComp extends Cartpage_WebElement {





	public void CheckCartPageOPened() {
		//Check URL
		String url=driver.getCurrentUrl();
		assertEquals(url,"https://www.saucedemo.com/cart.html");

		//Check the container
		WebElement Container= getCartPageContainer();
		assertNotNull(Container);
	}



	public void CheckQuantityTiltle() {
		String Quantity=getQuantityLabel().getText();
		System.out.println(Quantity);
		assertEquals(Quantity,"QTY");
	}


	public void CheckDescriptionTitle() {
		String Description=getDescriptionSubLabel().getText();
		System.out.println(Description);
		assertEquals(Description,"Description");}


	public void CheckProductInfo() {
		WebElement Item=getCartButton();
		String ProductDetails=Item.getText();
		System.out.println(ProductDetails);

	}

	public void ClickRemoveBtn() {
		WebElement Remove=getCartButton();
		Remove.click();


	}



	public void CheckCartItems() {
		WebElement Container= getCartPageContainer();
		List<WebElement>Items=Container.findElements(By.className("cart_item"));
		int i=6;

		for(WebElement Item:Items ) {

			i--;

			//Get Product Details
			String ProductDetails=Item.getText();
			System.out.println(ProductDetails);

			//Click on Remove button
			WebElement Remove=getCartButton();
			Remove.click();
			WaitingMethod wait=new WaitingMethod();
			wait.explicitlyWaitForVisibility(getCartButtonNumber());

			//Cart number decrease
			String CartNumber=getCartButtonNumber().getText();
			System.out.println(CartNumber);
			assertEquals(String.valueOf(i),CartNumber);


		}
	}


	public void ClickContinueShoppingButton() {
		getContinueShoppingButton().click();
		String URL=driver.getCurrentUrl();
		assertEquals(URL,"https://www.saucedemo.com/inventory.html");
	}


	public void ClickCheckoutButton() {
		logger.debug("Check Checkout Button");
		String color=getCheckOutButton().getCssValue("Background");
		System.out.println(color);
		getCheckOutButton().click();
		String URL=driver.getCurrentUrl();
		assertEquals(URL,"https://www.saucedemo.com/checkout-step-one.html");

	}

}