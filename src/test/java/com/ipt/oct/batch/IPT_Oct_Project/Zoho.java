package com.ipt.oct.batch.IPT_Oct_Project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Zoho {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipse-workspace\\Zoho_Project\\Driver\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zoho.com/login.html");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.NANOSECONDS);
		
		WebElement signup = driver.findElement(By.xpath("//a[text()='Sign Up Now']"));
		signup.click();
		
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("vijayakumar");
		
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("passwords");
		
		WebElement button = driver.findElement(By.xpath("//span[@id='signup-termservice']"));
		button.click();
		
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\vijay\\eclipse-workspace\\Mini_Projects\\Screenshots\\pic.png");
		FileHandler.copy(source, to);
			
		driver.close();
	}

}
