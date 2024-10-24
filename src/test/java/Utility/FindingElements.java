package Utility;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FindingElements extends TestingMethod{


	public WebElement findElementByClassName(String classname){
		WebElement element = driver.findElement(By.className(classname));
		return element;
	}

	public WebElement findElementByID(String ID){
		WebElement element =driver.findElement(By.id(ID));
		return element;
	}
	// Method to find an element by Xpath
	public WebElement findElementByXPATH(String XPATH){
		WebElement element = driver.findElement(By.xpath(XPATH));
		return element;
	}


	// Method to find an element by tag name
	public WebElement findElementByTagName(String tagName) {
		WebElement webElement = driver.findElement(By.tagName(tagName));
		return webElement;
	}

	// Method to find an element by CSS selector
	public WebElement findElementByCssSelector(String cssSelector) {
		WebElement webElement = driver.findElement(By.cssSelector(cssSelector));
		return webElement;
	}

	// Method to find an element by name attribute
	public WebElement findElementByName(String name) {
		WebElement webElement = driver.findElement(By.name(name));
		return webElement;
	}

	public List<WebElement>findingElementByClassNameInList(String ClassName) {List<WebElement>webElement =driver.findElements(By.className(ClassName));
	return webElement ;}

	public List<WebElement>findingElementByIDInList(String ID) {List<WebElement>webElement =driver.findElements(By.id(ID));
	return webElement ;}



	public void implicit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}


	public void explicitWithOptions() {
		//    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//    wait.until(d -> Element.isDisplayed());

		WebElement element = driver.findElement(By.id("id"));
		Wait<WebDriver> wait =

				new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(ElementNotInteractableException.class);

		wait.until(
				d -> {
					element.sendKeys("Displayed");
					return true;
				});
	}


}
