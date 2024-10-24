package Comp_Homepage;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class Homepage_WebElement extends FindingElements {

	public WebElement getItemsContainer() throws IOException {return findElementByClassName("inventory_list");}
	public WebElement getAddToCartBtn() throws IOException {return findElementByID("add-to-cart-sauce-labs-backpack");}
	public WebElement getRemoveBtn() throws IOException {return findElementByID("remove-sauce-labs-backpack");}
	public WebElement getCartBadge() throws IOException {return findElementByClassName("shopping_cart_badge");}
	//Item Image
	public WebElement getProductImg() throws IOException {return findElementByTagName("inventory_item_img");
	}

	//Item Description
	public WebElement getProductDescription()  {return findElementByClassName("inventory_item_description");
	}

	//Item Price
	public WebElement getProductPrice()  {return findElementByClassName("inventory_item_price");
	}

	//Check Footer
	public WebElement getFooter() {return findElementByClassName("footer");
	}

	//Check Add to cart Button
	public WebElement getAddtocartBtn() {return findElementByClassName("btn_primary");
	}
	// show HomePage
    public WebElement getHomePage() {return findElementByID("inventory_container");
    }

    // "Product" title
    public WebElement getNamePage()  {return findElementByCssSelector("span.title");
    }

    // Sort Down
    public WebElement getSortDropdown() {return findElementByClassName("product_sort_container");
    }

    

    // Container Item
    public WebElement getInventoryItem() {return findElementByClassName("inventory_item");
    }

    // Item Name
    public WebElement getProductName() {return findElementByClassName("inventory_item_name");
    }


}


