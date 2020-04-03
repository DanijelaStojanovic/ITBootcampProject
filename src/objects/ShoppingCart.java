package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

	public static final String URL_SHOPPING_CART = "http://automationpractice.com/index.php?controller=order";
	public static final String CHECK_OUT_BTN = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
	public static final String CART_ITEMS_NMBR = "//span[@class='heading-counter']";

	public static final String PRODUCT_NAME = "//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
	public static final String PRODUCT_SKU = "//small[@class='cart_ref']";
	public static final String PRODUCT_COLOR_SIZE = "//td[@class='cart_description']//a[contains(text(),'Color : Blue, Size : M')]";
	public static final String PRODUCT_QUANTITY = "//input[@name='quantity_5_24_0_0']";

	// Method for getting total number of items added to the cart
	public static String getCartItemsNmbr(WebDriver wd) {
		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_ITEMS_NMBR)));
		String nmbrOfItems = wd.findElement(By.xpath(CART_ITEMS_NMBR)).getText();
		return nmbrOfItems;
	}

	// Method for getting name of product added to the cart
	public static String getProductName(WebDriver wd) {
		String productName = wd.findElement(By.xpath(PRODUCT_NAME)).getText();
		return productName;
	}

	// Method for getting unique model(SKU - Stock Keeping Unit) of product added to
	// the cart
	public static String getProductSKU(WebDriver wd) {
		String productSKU = wd.findElement(By.xpath(PRODUCT_SKU)).getText();
		return productSKU;
	}

	// Method for getting color and size of products added to the cart
	public static String getProductColorSize(WebDriver wd) {
		String productColorSize = wd.findElement(By.xpath(PRODUCT_COLOR_SIZE)).getText();
		return productColorSize;
	}

	// Method for getting quantity of products added to the cart
	public static String getProductQuantity(WebDriver wd) {
		String productQuantity = wd.findElement(By.xpath(PRODUCT_QUANTITY)).getAttribute("value");
		return productQuantity;
	}

	// Method to click Proceed to checkout button
	public static void chooseCheckout(WebDriver wd) {
		wd.findElement(By.xpath(CHECK_OUT_BTN)).click();
	}

}
