package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShot extends SettingUpWebdriver {
	public static void captureScreenshot(WebDriver driver, String testClassName, String testMethodName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Define Path of directory based on class and method name
		String directoryPath = "./Screenshot" + testClassName;

		File targetDirectory = new File(directoryPath);
		if (!targetDirectory.exists()) {
			targetDirectory.mkdirs();
		}
		File targetFile = new File(directoryPath, testClassName + "_" + testMethodName + ".png");
		try {
			FileUtils.copyFile(scrFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void captureElementSreenshot(WebElement element, String testClassName, String testMethodName) {
		File scrFile = element.getScreenshotAs(OutputType.FILE);
		String directoryPath = "./Screenshot";
		File targetDirectory = new File(directoryPath);

		if (!targetDirectory.exists()) {
			targetDirectory.mkdirs();
		}
		File targetFile = new File(directoryPath, testClassName + "_" + testMethodName + ".png");
		try {
			FileUtils.copyFile(scrFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}