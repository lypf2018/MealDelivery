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

public class RegisterTest {

	WebDriver driver;

	@Before
	public void openRegisterPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/MealDelivery/register.jsp");
		Assert.assertEquals("Register", driver.getTitle());
	}

	@Test
	public void testRegisterValidCustomer() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("11");
		inputPasswd.sendKeys("11");
		retryPassword.sendKeys("11");
		firstName.sendKeys("11");
		lastName.sendKeys("11");
		street.sendKeys("11");
		city.sendKeys("11");
		state.sendKeys("11");
		zipCode.sendKeys("11");
		phone.sendKeys("11");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Login Page", driver.getTitle());
	}

	@Test
	public void testRegisterEmptyEmail() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Email must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyPassword() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Password must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyRetryPassword() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Retry-password must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterRetryPasswordNotMatch() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("unknow");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Retry-Password doesn't match", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyFirstName() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("First name must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyLastName() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Last name must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyStreet() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Street must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyCity() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("City must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyState() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("");
		zipCode.sendKeys("111");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("State must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyZipCode() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("");
		phone.sendKeys("111");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("ZIP code must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterEmptyPhone() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("111");
		inputPasswd.sendKeys("111");
		retryPassword.sendKeys("111");
		firstName.sendKeys("111");
		lastName.sendKeys("111");
		street.sendKeys("111");
		city.sendKeys("111");
		state.sendKeys("111");
		zipCode.sendKeys("111");
		phone.sendKeys("");
		submit.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Phone must be filled out", alert.getText());
		alert.accept();
	}

	@Test
	public void testRegisterExistingEmail() throws InterruptedException{
		WebElement inputEmail = driver.findElement(By.name("email"));
		WebElement inputPasswd = driver.findElement(By.name("password"));
		WebElement retryPassword = driver.findElement(By.name("retry-password"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement street = driver.findElement(By.name("street"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.name("state"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement submit = driver.findElement(By.name("submit"));
		inputEmail.sendKeys("1");
		inputPasswd.sendKeys("1");
		retryPassword.sendKeys("1");
		firstName.sendKeys("1");
		lastName.sendKeys("1");
		street.sendKeys("1");
		city.sendKeys("1");
		state.sendKeys("1");
		zipCode.sendKeys("1");
		phone.sendKeys("1");
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Register", driver.getTitle());
	}

	@After
	public void closePage(){
	driver.quit();
	}


}
