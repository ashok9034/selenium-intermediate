package com.selenium.intermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AjaxFormSubmit {

	@Test
	public void ajaxForm() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html";
		driver.get(url);

		// 'Name' locator
		WebElement name = driver.findElement(By.id("title"));
		name.sendKeys("David John");

		// 'Comment' locator
		WebElement comment = driver.findElement(By.id("description"));
		comment.sendKeys("Selenium Automation Framework");

		// 'Submit' locator
		WebElement submit = driver.findElement(By.id("btn-submit"));
		submit.click();

		sleep(3000);

		// Assertion of success message
		WebElement successMsg = driver.findElement(By.id("submit-control"));
		String actualMsg = successMsg.getText();
		String expectedMsg = "Form submited Successfully!";
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Assertion is successful.\nDisplayed message: " + "\"" + actualMsg + "\"");

		// Closes the browser
		driver.close();

	}

	public void sleep(int s) {

		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
