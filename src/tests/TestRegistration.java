package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import objects.Home;
import objects.Registration;
import utils.ExcelUtils;

public class TestRegistration {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Home.openPage(driver);
		Registration.navigateToRegister(driver);
		driver.manage().window().maximize();

	}

	// Test method to input registration data from provided excel file
	@Test
	public void testRegistrationFromExcelFile() {

		for (int i = 1; i < 2; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Registration.REG_PAGE_URL);

			ExcelUtils.findExcelSheet();

			WebElement email = Registration.getEmail(driver);
			email.click();
			String data = ExcelUtils.getDataAt(i, 3);
			email.sendKeys(data);
			Registration.clickCreateAccount(driver);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Registration.inputFirstName(driver, ExcelUtils.getDataAt(i, 1));
			Registration.inputLastName(driver, ExcelUtils.getDataAt(i, 2));
			Registration.inputPass(driver, ExcelUtils.getDataAt(i, 4));
			Registration.inputaddress(driver, ExcelUtils.getDataAt(i, 5));
			Registration.inputCity(driver, ExcelUtils.getDataAt(i, 6));
			Registration.state(driver, ExcelUtils.getDataAt(i, 7));
			Registration.inputZipCode(driver, ExcelUtils.getDataAt(i, 8));
			Registration.country(driver);
			Registration.inputMobPhone(driver, ExcelUtils.getDataAt(i, 10));
			Registration.inputAliasAddress(driver, ExcelUtils.getDataAt(i, 11));
			Registration.clickRegBtn(driver);

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
