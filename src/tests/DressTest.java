package tests;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import objects.Dress;

public class DressTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void openDressPage() {
		Dress.openDressPage(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_product=5&controller=product";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 2) // Test method for navigation to SummerDresses page
	public void navigateToDressPage() {
		Dress.navigateToDressPage(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_product=5&controller=product";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 3) // Test method for input quantity of products
	public void testInputQuantity() {
		Dress.inputQuantity(driver);
		String current = driver.findElement(By.xpath(Dress.QUANTITY)).getAttribute("value");
		String expected = "2";
		Assert.assertEquals(current, expected);

	}

	@Test(priority = 4) // Test method for choosing size of selected dress
	public void testChooseSize() {
		Dress.chooseSize(driver);
		Select size = new Select(driver.findElement(By.xpath(Dress.SIZE)));
		String current = size.getFirstSelectedOption().getAttribute("title");
		String expected = "M";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 5) // Test method for choosing color of selected dress
	public void testChooseColor() {
		Dress.chooseColor(driver);
		String current = driver.getCurrentUrl();
		assertTrue(current.contains("blue"));
	}

	@Test(priority = 6) // Test method for addToCart button
	public void testAddToCart() {
		Dress.addToCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dress.CART)));
		WebElement popup = driver.findElement(By.xpath(Dress.CART));
		Assert.assertTrue(popup.isDisplayed());
	}

	@Test(priority = 7) // Test method for for proceeding to checkout
	public static void testProceedToCheckout() {
		Dress.proceedToCheckout(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?controller=order";
		Assert.assertEquals(current, expected);
	}
	@AfterClass
	public void closeChrome() {
		driver.close();
	}
}
