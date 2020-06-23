package com.selenium.intermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InputFormFilling {

	@Test
	public void inputForm() {

		// Create driver
		System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/input-form-demo.html";
		driver.get(url);

		// 'First Name' locator
		WebElement firstName = driver.findElement(By.name("first_name"));
		firstName.sendKeys("David");

		// 'Last Name' locator
		WebElement lastName = driver.findElement(By.name("last_name"));
		lastName.sendKeys("John");

		// 'Email Address' locator
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("david.john@mail.com");

		// 'Phone Number' locator
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("9876543210");

		// 'Address' locator
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("Brooklyn");

		// 'City' locator
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("New York");

		// 'State' locator
		WebElement state = driver.findElement(By.name("state"));
		Select dropdown = new Select(state);
		dropdown.selectByVisibleText("New York");

		// 'Zip Code' locator
		WebElement zip = driver.findElement(By.name("zip"));
		zip.sendKeys("00000");

		// 'Website' locator
		WebElement website = driver.findElement(By.name("website"));
		website.sendKeys("https://www.google.com");

		// 'Do you have hosting' locator
		WebElement hosting = driver
				.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[10]/div/div[1]/label/input"));
		hosting.click();

		// 'Description' locator
		WebElement description = driver.findElement(By.name("comment"));
		description.sendKeys("Selenium Automation Framework");

		// 'Submit' button locator
		WebElement submit = driver.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[13]/div/button"));
		submit.click();

		sleep(3000);

		// Closes the browser
		driver.close();

		System.out.println("Form filling successful.");

	}

	public void sleep(int s) {

		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
