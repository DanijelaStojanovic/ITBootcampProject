package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import objects.Home;

public class HomeTest {

	private static WebDriver driver;

	@BeforeSuite
	public void welcome() {
		System.out.println("Welcome to testing website automationpractice.com using Selenium WebDriver and TestNG");
	}

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test (priority = 1)// Test method for home page opening
	public void openHomePage() {
		Home.openPage(driver);
		driver.manage().window().maximize();
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php";
		Assert.assertEquals(current, expected);
	}

	@Test (priority = 2)// Test method for navigation to home page
	public void navigateHomePage() {
		Home.navigateToPage(driver);
		driver.manage().window().maximize();
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php";
		Assert.assertEquals(current, expected);
	}

	@Test (priority = 3)// Test method for navigation to page SummerDresses from button Woman
	public void testSumDresfromWomen() {
		Home.hoverWoman(driver);
		Home.clickSumDressWoman(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(current, expected);
	}

	@Test (priority = 4)// Test method for navigation to page SummerDresses from button Dresses
	public void testSumDresfromDresses() {
		Home.hoverDresses(driver);
		Home.clickSumDressDresses(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(current, expected);
	}

	@Test (priority = 5)// Test method for comparing if both paths lead to the same SummerDresses page
	public void compareSumDres() {
		Home.hoverWoman(driver);
		Home.clickSumDressWoman(driver);
		String currentURL1 = driver.getCurrentUrl();
		Home.navigateToPage(driver);
		Home.hoverDresses(driver);
		Home.clickSumDressDresses(driver);
		String currentURL2 = driver.getCurrentUrl();
		Assert.assertEquals(currentURL1, currentURL2);
	}

	@AfterClass
	public void closeChrome() {
		driver.close();
	}

	@AfterSuite
	public void goodbye() {
		System.out.println("Thank you for testing with us!");

	}
}