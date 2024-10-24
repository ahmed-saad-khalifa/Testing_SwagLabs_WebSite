package Comp_Loginpage;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class Loginpage_WebElements extends FindingElements{


	 
	public WebElement getContainer() throws IOException {return findElementByClassName("login_container");}
	
	public WebElement getFieldsContanier() throws IOException {return findElementByID("login_button_container"); }            
	
	public WebElement getFirstNameField() throws IOException {return findElementByID("user-name");}
	
	public WebElement getPasswordField () throws IOException {return findElementByID("password"); }
	
	public WebElement getcredentialbox () throws IOException {return findElementByID("login_credentials");}

    public WebElement getloginbutton () throws IOException {return findElementByID("login-button"); }

    public WebElement getErrorMessage () throws IOException {return findElementByXPATH("//h3[@data-test='error']");}   
    
    
    }

