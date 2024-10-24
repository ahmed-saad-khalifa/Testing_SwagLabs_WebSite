package Comp_Loginpage;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import Utility.ConfigerLoader;
import Utility.DataUtils;
import Utility.WaitingMethod;
import Comp_Homepage.Home_page_Comp;
import Comp_Homepage.Homepage_WebElement;

public class Login_page_Comp extends Loginpage_WebElements{
	String[] validUsernames = {
			"standard_user",
			"locked_out_user",
			"problem_user",
			"performance_glitch_user",
			"error_user",
			"visual_user"
	};
	String validPassword = "secret_sauce";
	String invalidUsername = "invalid_user";
	String invalidPassword = "invalid_password";
	String screenshotFolder = "screenshots/";



	public void CheckIfLoginPageOpened() throws IOException {
		logger.debug("Check if Login Page Opened");

		//CHECK URL
		String URL = driver.getCurrentUrl();
		Checkequals(URL, "https://www.saucedemo.com/");  
		System.out.println("the Url of the Website is : " +URL);
		//CHECK TITLE
		String TITLE = driver.getTitle();
		Checkequals(TITLE, "Swag Labs");  
		System.out.println("the Title of the Website is : " +TITLE);
		//CHECK CONTANIER
		WebElement Contianer = getContainer();
		CheckNotNull(Contianer,"Contianer is not found " );
		System.out.println(Contianer.getLocation());
		//CHECK FIELDS CONTANIER
		WebElement FieldsContianer = getFieldsContanier();
		CheckNotNull(FieldsContianer,"FieldsContianer is not found");
	} 


	public void CheckLoginButton () throws IOException {
		logger.debug(" Check If Login Btn is Enable");

		WebElement LoginButton = getloginbutton ();
		CheckIfButtonIsEnable (LoginButton,"LoginBtn");
	}
	public void getcredentialboxContainer () throws IOException {
		logger.debug(" Check If The credentialboxContainer is Appeares");
		WebElement Credentialbox = getcredentialbox();
		CheckNotNull(Credentialbox,"credentialboxContainer is not found");
		
	}
	public void CheckIfUserLoginWithValidData() throws IOException {
		logger.debug("Check If User Entered With Valid Data");

		WebElement UserNameField = getFirstNameField();
		CheckNotNull(UserNameField,"UserName Field is not found");
		UserNameField.sendKeys("standard_user");


		WebElement PasswordField = getPasswordField();
		CheckNotNull(PasswordField,"Password Field is not found");
		PasswordField.sendKeys("secret_sauce");


		WebElement LoginButton = getloginbutton ();
		LoginButton.click();
		Checkequals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

	}

	public void CheckInvalidData() throws IOException {
		logger.debug("Check If User Entered With InValid Data");

		WebElement UserNameField = getFirstNameField();
		CheckNotNull(UserNameField,"UserName Field is not found");
		UserNameField.sendKeys("aaaaaaaaa");


		WebElement PasswordField = getPasswordField();
		CheckNotNull(PasswordField,"Password Field is not found");
		PasswordField.sendKeys("aa1234");


		WebElement LoginButton = getloginbutton ();
		LoginButton.click();
		Checkequals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");


	}

	public void CheckLockedOutUsers() throws IOException {
		for (String username : validUsernames) {
			// Enter username and password
			WebElement usernameField = getFirstNameField();
			WebElement passwordField = getPasswordField();
			WebElement loginButton = getloginbutton();

			usernameField.clear(); // Clear previous input
			usernameField.sendKeys(username);
			passwordField.clear();
			passwordField.sendKeys(validPassword);

			// Click login button
			loginButton.click();

			// Check for the presence of an error message
			try {
				WebElement errorMessage = getErrorMessage();
				String errorText = errorMessage.getText();

				// If the error message contains "locked out", print the username
				if (errorText.toLowerCase().contains("locked out")) {
					System.out.println("User '" + username + "' is locked out.");
				}
			} catch (Exception e) {

			}

			// After each login attempt, return to the login page
			driver.navigate().to("https://www.saucedemo.com/");
		}
	}

	public void CheckIfErrorMessage() throws IOException {
		WebElement getUserNameField = getFirstNameField();
		getUserNameField.sendKeys("standard_user",Keys.ENTER);

		WebElement getErrormessage = getErrorMessage();
		CheckNotNull(getErrormessage,"Error Message Container is Not Found");
		String ErrorMessage =getErrormessage.getText();
		System.out.println(ErrorMessage);
		Checkequals(ErrorMessage, "Epic sadface: Username is required");
		CheckContains(ErrorMessage,"Username");

		WebElement Color = findElementByCssSelector("background-color");
		System.out.println(Color);
	}


	public void ExcelFileAnotherWay() throws IOException {

		String excelFilePath = "./Resources/";  
		String excelFilename = "LoginData.xlsx";  
		String sheetName = "loginData";  


		DataUtils ExcelData = new DataUtils();
		String username = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 1, 0);
		System.out.println("Username: " + username);

		WebElement userNameField = getFirstNameField();
		userNameField.sendKeys(username);

		String password = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 1, 1);
		System.out.println("Password: " + password);

		WebElement passwordField = getPasswordField();
		passwordField.sendKeys(password);

		WebElement loginButton = getloginbutton();
		loginButton.click();
	}

	public void ExcelFileAnotherWayForAllData() {

		String excelFilePath = "./Resources/";  
		String excelFilename = "Login_Data.xlsx";  
		String sheetName = "Sheet1";  

		DataUtils ExcelData = new DataUtils();
		ExcelData.getAllExcelData(excelFilePath, excelFilename, sheetName);

	}
	public void LoginWithConfig() throws InterruptedException, IOException {
		logger.debug("Login With Config Data");

		ConfigerLoader config=new ConfigerLoader();

		System.out.println("The Name Is: " +config.getConfigValue("config", "UserName"));

		WebElement UserNameField = getFirstNameField();
		WebElement PasswordField = getPasswordField();
		WebElement loginButton = getloginbutton();

		WaitingMethod wait =new WaitingMethod();


		UserNameField.sendKeys(config.getConfigValue("config", "UserName"));
		PasswordField.sendKeys(config.getConfigValue("config", "Password"));


		// Add code to click the login button here
		loginButton.click();

		Homepage_WebElement home=new Homepage_WebElement();
		wait.explicitlyWaitForVisibility(home.getItemsContainer());
	}
	public void CheckLoginWithValidDataByJason() throws IOException, InterruptedException {
	    logger.debug("Check Login With Valid Data By Json");

	    WebElement UserNameField = getFirstNameField();

	    CheckNotNull(UserNameField,  "User Name Field");

	    UserNameField.sendKeys(DataUtils.getJsonValue( "LoginData",  "UserLogin.UserName"));

	    logger.info("UserName: " + UserNameField.getAttribute( "value"));

	    WebElement PasswordField = getPasswordField();

	    CheckNotNull(PasswordField,  "Password Field");

	    PasswordField.sendKeys(DataUtils.getJsonValue( "LoginData",  "UserLogin.Password"));

	    logger.info("Password: " + PasswordField.getAttribute( "value"));

	    WebElement LoginButton = getloginbutton();
	    CheckNotNull(LoginButton,"Login Button");

	    explicitlyWaitForClickability(LoginButton);

	    LoginButton.click();

	    Home_page_Comp homePageComp = new Home_page_Comp();

	    homePageComp.checkIfHomePageIsOpened();
	}
	
	public void CheckLoginWithJavaFaker() throws IOException {
	    logger.debug("Checking Login With Java Faker");
 
	    Faker faker = new Faker();
 
	    String randomUserName = faker.name().username();
	    String randomPassword = faker.internet().password();
 
	    WebElement UserNameField = getFirstNameField();
	    CheckNotNull(UserNameField, "User Name Field");
	    UserNameField.sendKeys(randomUserName);
	    logger.info("UserName: " + randomUserName);
 
	    WebElement PasswordField = getPasswordField();
	    CheckNotNull(PasswordField, "Password Field");
	    PasswordField.sendKeys(randomPassword);
	    logger.info("Password: " + randomPassword);
 
	    WebElement LoginButton = getloginbutton();
	    explicitlyWaitForClickability(LoginButton);
	    LoginButton.click();
 
	    Checkequals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}



}
