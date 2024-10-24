package Utility;
import java.util.List;

import org.openqa.selenium.WebElement;

public class TestingMethod extends WaitingMethod{
	//assert.NotNull
	public void CheckNotNull(WebElement webelement,String elementName) {
		if(webelement==(null)) {
			String ErrorMessage=String.format( "Expected "+elementName+ " to be found But it is not existed");
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);
		}
	}



	//assert.null
	public void CheckNull(WebElement webelement,String elementName) {
		if(webelement!=(null)) {
			String ErrorMessage=String.format( "Expected "+elementName+ " to be null But it existed");
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);
		}
	}

	//assert.equals
	public static void Checkequals(String expected,String actual) {
		if(!expected.equals(actual)) {
			String ErrorMessage=String.format( "Expected "+expected +" but found "+actual);	
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);}

	}


	//assert.not.equals
	public static void CheckNotequals(String expected,String actual) {
		if(expected.equals(actual)) {
			String ErrorMessage=String.format( "Expected "+expected +" but found "+actual);	
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);

		}

	}
	//assert.Contain
	public void CheckContains(String Sentence,String word) {
		if(!(Sentence.contains(word))) {
			String ErrorMessage=String.format( Sentence+" not contains "+word);	
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);

		}}
	//assert.isEnable
	public void CheckIfButtonIsEnable(WebElement webelement,String elementName) {
		if(!webelement.isEnabled()) {
			String ErrorMessage=String.format( "Expected "+elementName+ " to be Enable");
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);
		}
	}

	//assert.isDisplayed
	public void CheckIsDisplayed(WebElement webelement,String elementName) {
		if(!webelement.isDisplayed()) {
			String ErrorMessage=String.format( "Expected "+elementName+ " to be found But it is not displayed");
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);
		}
	}

	//assert not Null for list
	public void CheckNotNullForList(List<WebElement>webelements,String elementName) {
		if(webelements==(null)) {
			String ErrorMessage=String.format( "Expected "+elementName+ " to be found But it is not existed");
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);
		}
	}
	//assert not Null for list
	public void CheckNullForList(List<WebElement>webelements,String elementName) {
		if(webelements!=(null)) {
			String ErrorMessage=String.format( "Expected "+elementName+ " to be found But it is not existed");
			System.out.println(ErrorMessage);
			throw new AssertionError(ErrorMessage);
		}
	}



}


