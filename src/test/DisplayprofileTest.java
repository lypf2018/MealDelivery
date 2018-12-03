package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class DisplayprofileTest {
	
	
	WebDriver driver;
	@Test
	public void prodisplaySuccess() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/MealDelivery/login.jsp");
	Thread.sleep(2000);
	WebElement inputEmail = driver.findElement(By.id("email"));
	WebElement inputPasswd = driver.findElement(By.id("password"));
	WebElement submit = driver.findElement(By.name("submit"));
	inputEmail.sendKeys("1");
	inputPasswd.sendKeys("1");
	submit.click();
	Thread.sleep(2000);
	if(driver.getTitle().equalsIgnoreCase("Menu")) {
		WebElement profile = driver.findElement(By.id("profile"));
		profile.click();
		Thread.sleep(2000);
		Assert.assertEquals("Customer Profile", driver.getTitle());
	}
	}


	@Test
	public void prodisplayError() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/ProfileController");
		Thread.sleep(2000);
		Assert.assertEquals("error message", driver.getTitle());
	
	}
	
	@After
	public void closePage(){
	driver.quit();
	}

}



