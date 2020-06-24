package com.selenium.intermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class BootstrapDual {

	static WebDriver driver;

	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		String url = "https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html";
		driver.get(url);

	}

	public void switchButtonRight() {

		WebElement switchRight = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-right']"));
		switchRight.click();

	}

	public void switchButtonLeft() {

		WebElement switchLeft = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-left']"));
		switchLeft.click();

	}

	public void singleOption() {

		WebElement option1 = driver.findElement(By.xpath("//li[text()='bootstrap-duallist ']"));
		option1.click();
		sleep(2000);
		switchButtonRight();

		WebElement option2 = driver.findElement(By.xpath("//li[text()='Cras justo odio']"));
		option2.click();
		sleep(2000);
		switchButtonLeft();
		
		driver.navigate().refresh();

	}

	public void selectAll() {
		
		WebElement selectButton = driver.findElement(By.xpath("//*[@id='listhead']/div[2]/div/a"));
		selectButton.click();
		sleep(2000);
		switchButtonRight();
		
	}
	
	
	@Test(enabled = false)
	public void sleep(int s) {

		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
