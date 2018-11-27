package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	WebDriver driver;

	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/login.jsp");
		Assert.assertEquals("Login Page", driver.getTitle());
	}

	@Test
	public void testLoginValidCustomer() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Menu", driver.getTitle());
	}

	@Test
	public void testLoginEmptyEmail() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("");
		inputPasswd.sendKeys("unknow");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Email must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testLoginEmptyPassword() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("unknow");
		inputPasswd.sendKeys("");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Password must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testLoginInvalidCustomer() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("unknow");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Register", driver.getTitle());
	}

	@Test
	public void testLoginNotMatch() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("unknow");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Login Page", driver.getTitle());
	}

	@After
	public void closePage(){
	driver.quit();
	}

}
