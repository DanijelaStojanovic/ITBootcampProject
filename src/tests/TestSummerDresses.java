package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import objects.Home;
import objects.SummerDresses;

public class TestSummerDresses {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void openSummerDressesPage() {
		SummerDresses.openSumDressPage(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(current, expected);
	}

	@Test // Test method for navigation to SummerDresses page
	public void navigateSumDressesPage() {
		SummerDresses.navigateToSumDressPage(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(current, expected);
	}

	@Test // test method for choosing the first dress
	public void testChooseDress() {
		SummerDresses.chooseDress(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_product=5&controller=product";
		Assert.assertEquals(current, expected);
	}
	@AfterClass
	public void closeChrome() {
		driver.close();
	}
}
