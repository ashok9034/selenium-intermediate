package com.selenium.intermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JQueryDropdown {

	@Test
	public void dropdownWithSearchBox() {

		// Create driver
		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the url
		String url = "https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html";
		driver.get(url);

		// Single dropdown with searchbox
		WebElement dropdown1 = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/span/span[1]/span"));
		dropdown1.click();
		WebElement search = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		search.sendKeys("India");

		sleep(3000);

		WebElement searchRslt = driver.findElement(By.xpath("//*[@id='select2-country-results']/li"));
		searchRslt.click();

		// Multiple selects
		WebElement multiSearch = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li/input"));
		multiSearch.sendKeys("New York");
		WebElement searchResult = driver.findElement(By.xpath("/html/body/span/span/span/ul/li"));
		searchResult.click();
		multiSearch.sendKeys("Ohio");
		WebElement searchResult1 = driver.findElement(By.xpath("/html/body/span/span/span/ul/li"));
		searchResult1.click();
		sleep(3000);

		// Dropdown with disabled values
		WebElement dropdown2 = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div[2]/span/span[1]/span/span[1]"));
		dropdown2.click();
		WebElement search1 = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		search1.sendKeys("American Samoa");

		sleep(3000);

		WebElement searchRslt1 = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li"));
		searchRslt1.click();

		sleep(3000);
		dropdown2.click();

		WebElement disabledOption = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]"));
		Assert.assertTrue(disabledOption.isEnabled());
		System.out.println("Guam option is disabled.\nAssertion is successful.");

		// Selecting category
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='files']"));
		dropdown3.sendKeys("Java");

		sleep(3000);

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
