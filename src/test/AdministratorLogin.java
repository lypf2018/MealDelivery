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

public class AdministratorLogin {

	WebDriver driver;

	@Before
	public void openAdministratorLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/administratorlogin.jsp");
		Assert.assertEquals("Administrator Login Page", driver.getTitle());
	}

	@Test
	public void testAdministratorLoginValidAdministrator() throws InterruptedException {
		WebElement inputEmail = driver.findElement(By.id("username"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Admin Login Confirm Page", driver.getTitle());
	}

	@Test
	public void testAdministratorLoginEmptyUsername() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("username"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("");
		inputPasswd.sendKeys("1");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Username must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testAdministratorLoginEmptyPassword() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("username"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Password must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testAdministratorLoginInvalidAdministrator() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("username"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("unknow");
		inputPasswd.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Administrator Login Page", driver.getTitle());
	}

	@Test
	public void testAdministratorLoginNotMatch() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("username"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("unknow");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Administrator Login Page", driver.getTitle());
	}

	@After
	public void closePage(){
	driver.quit();
	}

}
