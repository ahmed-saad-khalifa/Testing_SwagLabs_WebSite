package Comp_Footer;
import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class Footer_WebElement extends FindingElements{
	
	public WebElement GetFooterContainer() {return findElementByClassName("footer");}
	public WebElement GetTwitterBtn() {return findElementByClassName("social_twitter");}
	public WebElement GetFacebookBtn() {return findElementByClassName("social_facebook");}
	public WebElement GetLinkedInBtn() {return findElementByClassName("social_linkedin");}
	public WebElement GetFooterText() {return findElementByClassName("footer_copy");}
	

}