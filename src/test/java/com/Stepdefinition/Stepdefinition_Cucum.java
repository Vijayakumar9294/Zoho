package com.Stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.Runner.RunneClass_Cucum;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition_Cucum {
	
	public WebDriver driver = RunneClass_Cucum.driver;
	
	@Given("Launch The Browser")
	public void launch_the_browser() {
		
		driver.get("https://www.zoho.com/login.html");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.NANOSECONDS);
	    
	}

	@When("Enter The Login Details")
	public void enter_the_login_details() {
		
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
	    
	}

	@Then("ScreenShot Details")
	public void screen_shot_details() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\vijay\\eclipse-workspace\\Mini_Projects\\Screenshots\\pic.png");
		FileHandler.copy(source, to);
			
		//driver.close();
	   
	}

}
