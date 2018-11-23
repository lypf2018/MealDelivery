package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class insertIntoCartTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/login.jsp");
		Assert.assertEquals("Login Page", driver.getTitle());
	}
	
	@Test
	// test insert the dish already exist
	public void insertExist() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("fengyz318@gmail.com");
		inputPasswd.sendKeys("fyzfyz");
		submit.click();
		Thread.sleep(3000);
		Assert.assertEquals("Menu", driver.getTitle());
		WebElement detailPage = driver.findElement(By.id("1"));
		detailPage.click();
		Thread.sleep(3000);
		Assert.assertEquals("Dish Detail", driver.getTitle());
		WebElement add = driver.findElement(By.id("add"));
		add.click();
		Thread.sleep(3000);
		Assert.assertEquals("Dish Detail", driver.getTitle());
	}

	@Test
	// test insert the dish not exist
	public void insertNotExist() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputPasswd = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("fengyz318@gmail.com");
		inputPasswd.sendKeys("fyzfyz");
		submit.click();
		Thread.sleep(3000);
		Assert.assertEquals("Menu", driver.getTitle());
		WebElement detailPage = driver.findElement(By.id("5"));
		detailPage.click();
		Thread.sleep(3000);
		Assert.assertEquals("Dish Detail", driver.getTitle());
		WebElement add = driver.findElement(By.id("add"));
		add.click();
		Thread.sleep(3000);
		Assert.assertEquals("Dish Detail", driver.getTitle());
	}
	@After
	public void closePage(){
	driver.quit();
	}
}
