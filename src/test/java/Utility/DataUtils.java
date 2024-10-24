package Utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;

import Comp_Loginpage.Loginpage_WebElements;

public class DataUtils {
	
	
	
	public static String login_data_json_path = "./Resources/";
	
	public static String getExcelData(String excelFilePath, String excelFilename, String sheetName, int rowNum, int colNum) {
		XSSFWorkbook workBook;
		XSSFSheet sheet;
		String cellData;

		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFilename);
			workBook = new XSSFWorkbook(file);
			sheet = workBook.getSheet(sheetName);

			// Get the data from the specified cell
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();


			workBook.close();
			return cellData;

		} catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
			return null;
		}
	}
	public static String getAllExcelData(String excelFilePath, String excelFilename, String sheetName) {
		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFilename);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Iterate through all the rows in the Excel sheet
			Iterator<Row> rowIterator = sheet.iterator();


			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// Fetch username and password from the current row
				String userName = row.getCell(0).getStringCellValue();  // ---> Column 0 (Username)
				String Password = row.getCell(1).getStringCellValue();  // ---> Column 1 (Password)




				System.out.println("Username: " + userName + ", Password: " + Password);

				Loginpage_WebElements webELement =new  Loginpage_WebElements();
				WebElement userNameElement= webELement.getFirstNameField();
				WebElement PasswordElement = webELement.getPasswordField();
				WebElement loginButton = webELement.getloginbutton();

				userNameElement.clear();
				userNameElement.sendKeys(userName);
				PasswordElement.clear();
				PasswordElement.sendKeys(Password);
				loginButton.click();
				SettingUpWebdriver.getDriver().navigate().back();

			}


			workbook.close();


		} catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
		}
		

		return null;
	}
	public static String getJsonValue(String jsonFilename, String field) {
	    try {
	        // Reading the JSON file using FileReader
	        FileReader reader = new FileReader(login_data_json_path + jsonFilename + ".json");

	        // Parsing the JSON file content into a generic Object
	        Object jsonData = new Gson().fromJson(reader, Object.class);

	        // Using JsonPath to extract the value of the specified field from the JSON object
	        return JsonPath.read(jsonData, "$." + field);
	    } catch (Exception e) {
	        // In case of an exception, return an empty string
	        return "";
	    }
	}


}
