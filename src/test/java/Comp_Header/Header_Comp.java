package Comp_Header;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Header_Comp  extends HeaderWebElement{
	public void CheckBurgerMenubtn() throws IOException {
		// check menu button
		WebElement container = getMenuButtonContainer();
		assertNotNull(container);

		driver.findElement(By.id("react-burger-menu-btn")).click();
		assertNotNull(driver.findElement(By.className("bm-menu-wrap")));
	}



	public void CheckHeaderTitle() throws IOException {
		String ProductTitle = getProductTitleContainer().getText();
		System.out.println(ProductTitle);

		assertEquals(ProductTitle, "Products");
	}



	public void CheckCartButton() throws IOException {
		WebElement container = getCartButtonContainer();
		assertNotNull(container);

		// check cart page opened
		driver.findElement(By.className("shopping_cart_link")).click();

		String url = driver.getCurrentUrl();
		assertEquals(url, "https://www.saucedemo.com/cart.html");
	}






}
