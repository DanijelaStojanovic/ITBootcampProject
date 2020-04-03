package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.Dress;
import objects.ShoppingCart;

public class TestShoppingCart {
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
	}

	@Test(priority = 1) // Test Method for checking total number of items added to the cart
	public void testCartItemsNmbr() {
		String current = ShoppingCart.getCartItemsNmbr(driver);
		String expected = "2 Products";
		boolean ok = current.contains(expected);
		Assert.assertTrue(ok);
	}

	@Test(priority = 2) // Method for checking name of product added to the cart
	public void testProductName() {
		String current = ShoppingCart.getProductName(driver);
		String expected = "Printed Summer Dress";
		Assert.assertEquals(current, expected);
	}

	@Test(priority = 3) // Method for checking SKU(Stock Keeping Unit) of product added to the cart
	public void testProductSKU() {
		String current = ShoppingCart.getProductSKU(driver);
		String expected = "demo_5";
		boolean ok = current.contains(expected);
		Assert.assertTrue(ok);
	}

	@Test(priority = 4) // Method for checking color and size of product added to the cart
	public void testProductColorSize() {
		String current = ShoppingCart.getProductColorSize(driver);
		String expected = "Color : Blue, Size : M";
		boolean ok = current.contains(expected);
		Assert.assertTrue(ok);
	}

	@Test(priority = 5) // Method for checking quantity of product added to the cart
	public void testProductQuantity() {
		String current = ShoppingCart.getProductQuantity(driver);
		String expected = "2";
		boolean ok = current.contains(expected);
		Assert.assertTrue(ok);
	}

	@Test(priority = 6) // Test method for button Proceed to checkout
	public void testCheckoutBtn() {
		ShoppingCart.chooseCheckout(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
		Assert.assertEquals(current, expected);
	}
	@AfterClass
	public void closeChrome() {
		driver.close();
	}
}