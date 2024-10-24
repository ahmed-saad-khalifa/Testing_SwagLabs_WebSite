package Comp_Homepage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Home_page_Comp extends Homepage_WebElement{
	public void CheckIfProductTitleIsShownOfSecondaryHeader() {
		logger.debug("Check Product Title is Appear");
		checkIfHomePageIsOpened();
		WebElement productTitle = getNamePage();
		CheckNotNull(productTitle, "Products");
		checkElementIsDisplayed(productTitle);
		checkIfContainsText(productTitle.getText(), "Products");
	}
	public void CheckSortButtonIsShown() {
		// Home page is opened
		checkIfHomePageIsOpened();

		CheckIfItemsContainerIsShown();

		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();

		// Check Product Name appears -- assertion text

		WebElement sortDropdown = getsortDropdown();
		CheckNotNull(sortDropdown, "Product Sort");
		checkElementIsDisplayed(sortDropdown);

	}
	public void CheckSortBtnIsClickable() {
		// Home page is opened
		checkIfHomePageIsOpened();

		CheckIfItemsContainerIsShown();

		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();
		// sort button is displayed
		CheckSortButtonIsShown();

		WebElement sortDropdown = getsortDropdown();
		checkElementIsEnabled(sortDropdown, "Sort");
		sortDropdown.click();
	}
	public void CheckIfRandomDropDownWork() {
		// Home page is opened
		checkIfHomePageIsOpened();

		CheckIfItemsContainerIsShown();

		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();
		// sort button is displayed
		CheckSortButtonIsShown();
		// sort button is clickable
		CheckSortBtnIsClickable();

		// Locate For All DropDown Options
		List<WebElement> DropDown = driver.findElements(By.tagName("option"));

		// Get Size For DropDown Options
		int Options = DropDown.size();
		Assert.assertTrue(Options > 0, "No sort options found");
		System.out.println("The Size Of DropDown Is: " + Options);

		// Select DropDown Using Random
		Random random = new Random();
		int RandomIndex = random.nextInt(Options);

		// Knowing what I selected
		System.out.println("The Number Of Button Click Is = " + RandomIndex);
		WebElement selectedOption = DropDown.get(RandomIndex);
		String selectedText = selectedOption.getText();
		System.out.println("The selected option" + selectedText);

		// Then Clicked On It
		selectedOption.click();

		//	 //Get All Information About User Login
		//	Set<Cookie> cookies = driver.manage().getCookies();
		//	System.out.println(cookies);

		// Get All Products
		List<WebElement> AllProducts = driver.findElements(By.xpath("//div[@class=\"inventory_item\"]"));
		System.out.println("Number Of Products" + AllProducts.size());

		// Get All The Text For Product
		System.out.println(AllProducts.getFirst().getText());
		// Ensure there are products to check
		if (AllProducts.isEmpty()) {
			System.out.println("No products found.");

		}

		// Check The Products Arranged Success When Selected One Option
		if (selectedText.contains("Z to A")) {
			Assert.assertTrue(AllProducts.getFirst().getText().contains("Test"));
			System.out.println("Selected Z to A");

		} else if (selectedText.contains("A to Z")) {
			Assert.assertTrue(AllProducts.getFirst().getText().contains("Sauce"));
			System.out.println("Selected A to Z");

		} else if (selectedText.contains("Price (low to high)")) {
			Assert.assertTrue(AllProducts.getFirst().getText().contains("$7.99"));
			System.out.println("Selected low to high");

		} else if (selectedText.contains("Price (high to low)")) {
			Assert.assertTrue(AllProducts.getFirst().getText().contains("$49.99"));
			System.out.println("Selected high to low");

		} else {
			System.out.println("False");
		}
	}

	/////////////////////////

	// Check HomePage Opened

	public void checkIfHomePageIsOpened() {
		logger.debug("Check HomePage is Opened");
		WebElement homePage = getHomePage();
		CheckNotNull(homePage, "Home Page");
		CheckIsDisplayed(homePage,"Home Page");
		CheckContains(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}

	public void CheckIfItemsContainerIsShown() throws IOException {
		logger.debug("Check The Items Container");
		checkIfHomePageIsOpened();
		WebElement ItemContainer = getItemsContainer();
		CheckNotNull(ItemContainer, "items Container");

	}
	public void CheckIfInventoryCardIsShown() throws IOException {

		// Home page is opened
		checkIfHomePageIsOpened();
		// check item card shown
		CheckIfItemsContainerIsShown();

		CheckIfProductTitleIsShownOfSecondaryHeader();
		logger.debug("Check Inventory Card Item is Shown");
		WebElement inventoryItem = getInventoryItem();
		CheckNotNull(inventoryItem, "Inventory Item");

	}

	// Check if the inventory list items (titles, images, descriptions, prices) are
	// present
	public void checkIfInventoryItemsPresent() {
		logger.debug("Check Inventory Card Item Details ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();

		// Check Titles
		List<WebElement> titles = driver.findElements(By.cssSelector(".inventory_item_title"));
		CheckNotNullForList(titles, "Product Titles");
		for (WebElement title : titles) {
			Actions action = new Actions(driver);
			action.moveToElement(title).build().perform();
			CheckIsDisplayed(title);
		}

		// Check Images
		List<WebElement> images = driver.findElements(By.cssSelector(".inventory_item_img"));
		CheckNotNullForList(images, "Product Images");
		for (WebElement image : images) {
			CheckIsDisplayed(image);
		}

		// Check Descriptions
		List<WebElement> descriptions = driver.findElements(By.cssSelector(".inventory_item_desc"));
		CheckNotNullForList(descriptions, "Product Descriptions");
		for (WebElement description : descriptions) {
			CheckIsDisplayed(description);
		}

		// Check Prices
		List<WebElement> prices = driver.findElements(By.cssSelector(".inventory_item_price"));
		CheckNotNullForList(prices, "Product Prices");
		for (WebElement price : prices) {
			CheckIsDisplayed(price);
		}
	}
	public void CheckSixItemsAreDisplayed() {

		// Locate the items by their common class (inventory_item)
		List<WebElement> items = driver.findElements(By.className("inventory_item"));

		// Verify there are exactly 6 items
		int numberOfItems = items.size();
		System.out.println("Number of items displayed: " + numberOfItems);
		assertEquals(6, numberOfItems);

		for (WebElement item : items) {
			// Check the price
			WebElement priceElement = item.findElement(By.className("inventory_item_price"));
			assertNotNull(priceElement);
			String priceText = priceElement.getText();
			System.out.println("Price: " + priceText);
			assertTrue(priceText.matches("\\$\\d+\\.\\d+")); //

			// Check the picture
			//			WebElement pictureElement = item.findElement(By.tagName("img"));
			String pictureElement = item.findElement(By.xpath("//img[@class=\"inventory_item_img\"]"))
					.getAttribute("src");
			assertNotNull(pictureElement);
			System.out.println(pictureElement);
			//			String pictureSrc = pictureElement.getAttribute("src");
			System.out.println("Picture Source: " + pictureElement);
			assertFalse(pictureElement.contains("inventory"));

			// Check the "Add to Cart" button
			WebElement addToCartBtn = item.findElement(By.className("btn_primary"));
			assertNotNull(addToCartBtn);
			String addToCartText = addToCartBtn.getText();
			System.out.println("Add to Cart Button Text: " + addToCartText);
			assertTrue(addToCartBtn.getText().contains("Add to cart")); // Check if button text contains "Add to cart"

			// Check the product details (title)
			WebElement detailsElement = item.findElement(By.className("inventory_item_name"));
			assertNotNull(detailsElement);
			String detailsText = detailsElement.getText();
			System.out.println("Product Details: " + detailsText);
			assertFalse(detailsText.isEmpty()); // Ensure details are not empty

			// Check the product description (title)
			WebElement descriptionElement = item.findElement(By.className("inventory_item_description"));
			assertNotNull(descriptionElement);
			String descriptionText = descriptionElement.getText();
			System.out.println("Product Description: " + descriptionText);
			assertFalse(descriptionText.isEmpty());
		}
	}

	public void ClickALLProductsAddedToCartBtnWebsiteAndAppearBadge() throws InterruptedException {
		logger.debug("Adding all items to the cart and verifying badge updates.");
		// get the list of items
		List<WebElement> items = getInventoryItemList();
		CheckNotNullForList(items, "Item List");

		int numberOfItems = items.size();
		System.out.println("The number of items is " + numberOfItems);
		checkIfActualEqualsExpected(String.valueOf(numberOfItems), "6");

		for (int i = 0; i < numberOfItems; i++) {
			WebElement item = items.get(i);

			WebElement addToCartButton = item.findElement(By.tagName("button"));

			// add the item to the cart
			addToCartButton.click();
			Thread.sleep(500);

			WebElement numberBadge = getCartBadge();
			CheckNotNull(numberBadge, "Cart Badge");

			String numberBadgeText = numberBadge.getText();
			System.out.println("Number of items in the cart: " + numberBadgeText);

			// verify that the number of items in the cart is updated correctly
			checkIfActualEqualsExpected(numberBadgeText, numberBadgeText);

			Thread.sleep(500);
		}

		System.out.println("All items have been added to the cart and the badge is updated correctly.");

	}

	public void ClickremoveAllItemsAndVerifyBadgeUpdateItemsRemovedInBadge() throws InterruptedException {
		logger.debug("Removing all items from the cart and verifying badge updates.");

		// get the list of items
		List<WebElement> items = getInventoryItemList();
		CheckNotNullForList(items, "Item List");

		int numberOfItems = items.size();
		System.out.println("The number of items in the cart is " + numberOfItems);
		checkIfActualEqualsExpected(String.valueOf(numberOfItems), "6");

		// add all items to the cart
		ClickALLProductsAddedToCartBtnWebsiteAndAppearBadge();

		for (int i = 0; i < numberOfItems; i++) {
			WebElement item = items.get(i);

			WebElement removeBtn = item.findElement(By.tagName("button"));
			String buttonText = removeBtn.getText();
			System.out.println("Button Text: " + buttonText);
			checkIfActualEqualsExpected(buttonText, buttonText);

			// remove the item from the cart
			removeBtn.click();
			Thread.sleep(500);
			List<WebElement> badgeElements = driver.findElements(By.className("shopping_cart_badge")); // Modify this
			// selector if
			// necessary
			if (!badgeElements.isEmpty()) {
				// The badge is still visible, verify its value
				WebElement numberBadge = badgeElements.get(0);
				CheckNotNull(numberBadge, "Cart Badge");

				// Verify that the badge updates correctly
				String numberBadgeText = numberBadge.getText();
				int expectedBadgeNumber = numberOfItems - (i + 1);
				System.out.println("Number of items in the cart after removal: " + numberBadgeText);

				// Verify that the number of items in the cart is updated
				checkIfActualEqualsExpected(numberBadgeText, String.valueOf(expectedBadgeNumber));
			} else {
				// Badge is no longer present, all items are removed
				if (i == numberOfItems - 1) {
					System.out.println("All items have been removed, and the badge is no longer visible.");
				} else {
					System.out.println("The badge disappeared prematurely.");
					checkIfActualEqualsExpected("Badge disappeared", "Premature disappearance detected.");
				}
			}
			Thread.sleep(500);

		}
		System.out.println("All items have been removed from the cart and the badge is updated ");
	}
	//CHECK ADD TO CART & REMOVE BUTTON /////////////////////
	// Check Add to Cart buttons are present and functional
	public void checkAddToCartButtonsOfAllItemsIsDisplayedAndClickable() {
		logger.debug("Check ALL Add To Cart Button Is Displayed & Clickable ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();
		List<WebElement> addToCartButtons = getAllAddtoCartBtn();
		CheckNotNullForList(addToCartButtons, "Add to Cart Buttons");

		for (WebElement addToCartButton : addToCartButtons) {
			checkElementIsDisplayed(addToCartButton);
			checkElementIsEnabled(addToCartButton, "Add to cart");
			addToCartButton.click();
		}
	}

	// Check Remove buttons are present and functional
	public void checkRemoveButtonsOfAllItemsIsDisplayedAndClickable() {
		logger.debug("Check ALL Remove Button Is Displayed & Clickable ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();

		// Ensure the "Add to Cart" buttons are functional and clickable
		List<WebElement> addToCartButtons = getAllAddtoCartBtn();
		CheckNotNullForList(addToCartButtons, "Add to Cart Buttons");

		for (WebElement addToCartButton : addToCartButtons) {
			checkElementIsDisplayed(addToCartButton);
			checkElementIsEnabled(addToCartButton, "Add to Cart");

			// Click the "Add to Cart" button
			addToCartButton.click();

			// Now verify that the "Remove" button appears in place of "Add to Cart"
			List<WebElement> removeButtons = getAllRemoveBtn();
			CheckNotNullForList(removeButtons, "Remove Buttons");

			// Ensure the "Remove" button is displayed and clickable
			WebElement removeButton = removeButtons.get(0); // Assuming the corresponding "Remove" button is now present
			checkElementIsDisplayed(removeButton);
			checkElementIsEnabled(removeButton, "Remove");

			// Click the "Remove" button to revert the item to "Add to Cart" state
			removeButton.click();
		}
	}

	// Check redirect add to cart btn after clicking on remove button
	public void checkreAddToCartButtonsAfterRemoveBtnClickAllItems() {
		logger.debug("Check All Add to cart Buttons Is Displayed after Click on Remove Button ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();
		checkRemoveButtonsOfAllItemsIsDisplayedAndClickable();

		// Ensure the "Add to Cart" buttons are functional and clickable
		List<WebElement> addToCartButtons = getAllAddtoCartBtn();
		CheckNotNullForList(addToCartButtons, "Add to Cart Buttons");
		for (WebElement addToCartButton : addToCartButtons) {

			// Ensure the "Add to Cart" button reappears after clicking "Remove"
			List<WebElement> reAddToCartButtons = getAllAddtoCartBtn();
			CheckNotNullForList(reAddToCartButtons, "Re-added Add to Cart Buttons");
			WebElement reAddToCartButton = reAddToCartButtons.get(0);
			checkElementIsDisplayed(reAddToCartButton);
			checkElementIsEnabled(reAddToCartButton, "Add to Cart");
		}

	}

	public void ClickOnAddToCartBtnOfOneItem() {

		logger.debug("Check add to cart Button Is Displayed & Clickable of One Item ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();
		// Find the Add to Cart button for the first item
		WebElement addToCartButton = getAddtoCartBtn();
		assertNotNull(addToCartButton);
		Assert.assertTrue(addToCartButton.isEnabled(), "Add To Cart button is not clickable.");

		String textAddToCart = addToCartButton.getText();
		System.out.println(textAddToCart);
		assertTrue(addToCartButton.getText().contains(textAddToCart));

		assertTrue(addToCartButton.isEnabled());
		addToCartButton.click();

	}

	public void ClickOnRemoveBtnOfOneItem() {
		logger.debug("Check Remove Button Is Displayed & Clickable of One Item ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();

		ClickOnAddToCartBtnOfOneItem();
		WebElement removeBtn = getRemoveBtn();
		CheckNotNull(removeBtn, "Remove Button");
		String textRemoveBtn = removeBtn.getText();

		System.out.println(textRemoveBtn);
		assertTrue(removeBtn.getText().contains("Remove"));
		assertTrue(removeBtn.isEnabled());
		removeBtn.click();

	}

	public void CheckTextAndColorForAddToCart() {

		//			ClickOnAddToCartBtnOfOneItem();
		//			ClickOnRemoveBtnOfOneItem();
		logger.debug("Check Add To Cart Button Text & Color One Item ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();
		// Fetch the "Add to Cart" button element
		WebElement addToCartBtn = getAddtoCartBtn();

		// Check that the button is not null
		assertNotNull(addToCartBtn);

		// Fetch the text of the button and verify it contains "Add to Cart"
		String textAddToCartBtn = addToCartBtn.getText();
		System.out.println("Button Text: " + textAddToCartBtn);
		assertTrue(addToCartBtn.getText().contains("Add to cart"));

		// Fetch the color of the button
		String buttonColor = addToCartBtn.getCssValue("color");
		System.out.println("Button Color: " + buttonColor);

	}

	public void CheckTextAndColorForRemoveBtn() {
		logger.debug("Check Remove Button Text & Color One Item ");
		checkIfHomePageIsOpened();
		CheckIfItemsContainerIsShown();
		CheckIfInventoryCardIsShown();
		checkIfInventoryItemsPresent();

		ClickOnAddToCartBtnOfOneItem();
		WebElement RemoveBtn = getRemoveBtn();
		assertNotNull(RemoveBtn);

		String textRemoveBtn = RemoveBtn.getText();
		System.out.println(textRemoveBtn);
		assertTrue(RemoveBtn.getText().contains("Remove"));

		String Color = RemoveBtn.getCssValue("color");
		System.out.println(Color);

	}
	public void CheckTheNumberBadgeAddedToCartIconIsAppearOneItem() {

		ClickOnAddToCartBtnOfOneItem();

		// Verify that the cart badge is displayed
		WebElement numberBadge = driver.findElement(By.className("shopping_cart_badge"));
		CheckNotNull(numberBadge, "Badge Number");

		String numberBadgeText = numberBadge.getText();
		System.out.println(numberBadgeText);
		assertTrue(numberBadge.getText().contains("1"));
	}

	public void CheckIfTheCounterNumberDisappearForOneItemRemoved() throws InterruptedException  {


		// Click on "Remove" button to remove the item
		ClickOnRemoveBtnOfOneItem();

		// Try to get the cart badge element
		WebElement numberCounter = getCartBadge();

		// Check if the badge element is not null
		CheckNotNull(numberCounter, "Cart Badge");

		// Get the badge text
		String badgeText = numberCounter.getText();
		System.out.println("Badge Text: " + badgeText);

		// Assert that the badge text is empty or indicates zero
		Assert.assertTrue(badgeText.isEmpty() || badgeText.equals("0"),
				"The cart badge should be empty or show zero when the last item is removed.");

		// Additional log for clarity
		if (badgeText.isEmpty() || badgeText.equals("0")) {
			System.out.println("Cart badge is empty, as expected.");
		} else {
			System.out.println("Cart badge is not empty when it should be: " + badgeText);
		}

		// Wait for a moment before the next operation
		Thread.sleep(500);

	}

































	public void ClickOnAddToCartButton() throws IOException {
		WebElement AddToCartButton = getAddToCartBtn();
		assertNotNull(AddToCartButton);

		String textAddToCartButton = AddToCartButton.getText();
		System.out.println(textAddToCartButton);
		assertTrue(AddToCartButton.getText().contains("Add to cart"));

		assertTrue(AddToCartButton.isEnabled());
		AddToCartButton.click();
	}

	public void CheckTextAndColorForRemoveButton() throws IOException {
		WebElement removeButton = getRemoveBtn();
		assertNotNull(removeButton);

		// Check Text Inside The Remove Button
		String textRemoveButton = removeButton.getText();
		System.out.println(textRemoveButton);
		assertTrue(removeButton.getText().contains("Remove"));

		// Check Color For Remove Button
		String Color = removeButton.getCssValue("color");
		assertEquals(removeButton.getCssValue("color"), "rgba(226, 35, 26, 1)");
		System.out.println(Color);
	}

	public void CheckTheNumberBadgedAddedToCartIcon() throws IOException {
		WebElement numberBadget = getCartBadge();
		assertNotNull(numberBadget);

		String numberBadgetText = numberBadget.getText();
		System.out.println(numberBadgetText);
		assertTrue(numberBadget.getText().contains("1"));
	}
	public void CheckTheCounterNumberDisappear() throws IOException {
		WebElement NumberCounter = getCartBadge();
		assertNull(NumberCounter);
	}
}
