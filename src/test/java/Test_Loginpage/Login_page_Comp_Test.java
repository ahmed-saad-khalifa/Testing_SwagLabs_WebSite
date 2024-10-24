package Test_Loginpage;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comp_Loginpage.Login_page_Comp;
import Utility.ScreenRecord;


public class Login_page_Comp_Test extends Login_page_Comp{


	@BeforeMethod
	public void OpenBrowser(ITestResult result) throws Exception {

		SetUpTheDriverheadless(result);
	}


	@Test(priority = 1)
	public void CheckIfLoginPageOpened() {

		CheckIfLoginPageOpened();


	}
	@Test(priority = 2)
	public void CheckIfUserLogedinWithValidData () throws IOException  {

		CheckIfUserLoginWithValidData();

	}
	@Test
	public void  TestExcelFileAnotherWay() throws IOException {
		ExcelFileAnotherWay();
	}

	@Test
	public void  TestExcelALLFileAnotherWay()throws IOException {
		ExcelFileAnotherWayForAllData();
	}
	@Test
	public void  TestLoginWithValidDataByJson() throws IOException, InterruptedException{
		CheckLoginWithValidDataByJason();

	}
	@Test
	public void  TestLoginWithFakeData() throws IOException, InterruptedException{
		CheckLoginWithJavaFaker();

	}
	@Test
	public void CheckIfLoginPageOpened_Withheadless() throws IOException {
		Login_page_Comp loginPageComp = new Login_page_Comp();
		loginPageComp.CheckIfLoginPageOpened();
	}





	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
		closeDriver(result); 
		ScreenRecord.stopRecording();
		Thread.sleep(2000);
		driver.quit();

	}

}
