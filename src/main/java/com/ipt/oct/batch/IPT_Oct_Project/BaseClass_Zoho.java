package com.ipt.oct.batch.IPT_Oct_Project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Zoho {
	
	public static WebDriver driver = null;

	public static WebDriver browserLaunch(String value) {

		if (value.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();	

		}else if (value.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}else if (value.equalsIgnoreCase("gecko")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		return driver;
	}
	
	public static void launchUrl (String Value) {
		driver.getCurrentUrl();
	}

	public static void userInputElement(WebElement element, String Value) {
		element.sendKeys(Value);	

	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void screenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\vijay\\eclipse-workspace\\Mini_Projects\\Screenshots\\pic.png");
		FileHandler.copy(source, to);
}
	
	public static void implicityWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
	public static void closeWindow() {
		driver.close();
	}
}