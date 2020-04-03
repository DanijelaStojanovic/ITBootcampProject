package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.LogIn;
import objects.Registration;
import utils.ExcelUtils;

public class LogInTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Home.openPage(driver);
		Home.clickSignIn(driver);
		driver.manage().window().maximize();

	}

	// Test method for checking if users are logged in successfully, from excel file
	@Test
	public void testLogInFromExcelFile() {

		for (int i = 1; i < 2; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LogIn.navigateToLogin(driver);

			ExcelUtils.findExcelSheet();

			LogIn.inputEmail(driver, ExcelUtils.getDataAt(i, 3));
			LogIn.inputPassword(driver, ExcelUtils.getDataAt(i, 4));
			LogIn.clickSignInBtn(driver);
			
			String current = driver.findElement(By.xpath(Registration.ACCOUNT_CHECK)).getText();
			String expected = ExcelUtils.getDataAt(i, 1) + " " + ExcelUtils.getDataAt(i, 2);

			boolean ok = current.contains(expected);

			Assert.assertTrue(ok);
			Home.clickSignOut(driver);
		}
		ExcelUtils.closeExcel();

	}
	@AfterClass
	public void closeChrome() {
		driver.close();
	}
}
