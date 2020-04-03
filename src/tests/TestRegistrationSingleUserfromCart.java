package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Dress;
import objects.Registration;
import objects.ShoppingCart;

public class TestRegistrationSingleUserfromCart {
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(Dress.URL_DRESS);
		Dress.inputQuantity(driver);
		Dress.chooseSize(driver);
		Dress.chooseColor(driver);
		Dress.addToCart(driver);
		Dress.proceedToCheckout(driver);
		ShoppingCart.chooseCheckout(driver);
	}

	@Test(priority = 1) // Test method for input email
	public void testEmailField() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Registration.E_MAIL)));
		driver.findElement(By.xpath(Registration.E_MAIL)).click();
		Registration.inputEmail(driver);
		Registration.getEmail(driver).sendKeys(Keys.TAB);
		
	}

	@Test(priority = 2) // Test method for Create an account button
	public void testCreateAccountBtn() {
		Registration.clickCreateAccount(driver);
		String actual = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3) // Test method for registration of one user directly from shopping cart

	public void SingleUserRegisterTest() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Registration.inputFirstName(driver, "Danijela");
		Registration.inputLastName(driver, "Stojanovic");
		Registration.inputPass(driver, "nekiproizvoljnipass");
		Registration.inputaddress(driver, "Bul. despota stefana 68");
		Registration.inputCity(driver, "Belgrade");
		Registration.state(driver, "Hawaii");
		Registration.inputZipCode(driver,"11108");
		Registration.country(driver);
		Registration.inputMobPhone(driver, "381646980076");
		Registration.inputAliasAddress(driver, "Ljeska 23");
		Registration.clickRegBtn(driver);

		SoftAssert sa = new SoftAssert();
		
		// Testing of two parameters for succesfull login 
		//Check if registered user is signed in and his/her name appears in Account field in Menu
		String current = driver.findElement(By.xpath(Registration.ACCOUNT_CHECK)).getText();
		String expected = "Danijela Stojanovic";
		sa.assertEquals(current, expected);
		//Check if URL is correct
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0";
		sa.assertEquals(currentURL, expectedURL);
		sa.assertAll();
	}
	@AfterClass
	public void closeChrome() {
		driver.close();
	}
}