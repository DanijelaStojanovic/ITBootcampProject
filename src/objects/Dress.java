package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dress {
	public static final String URL_DRESS = "http://automationpractice.com/index.php?id_product=5&controller=product";
	public static final String DRESS = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 "
			+ "first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']"
			+ "//a[@class='product-name'][contains(text(),'Printed Summer Dress')]";
	public static final String QUANTITY = "//input[@id='quantity_wanted']";
	public static final String SIZE = "//select[@id='group_1']";
	public static final String COLOR = "//a[@id='color_14']";
	public static final String ADD_TO_CART = "//span[contains(text(),'Add to cart')]";
	public static final String CART= "//div[@id='layer_cart']//div[@class='clearfix']";
	public static final String CHECKOUT = "//span[contains(text(),'Proceed to checkout')]";

	// Method for opening Dress page
	public static void openDressPage(WebDriver wd) {
		wd.get(URL_DRESS);
	}

	// Method for navigation to Dress page
	public static void navigateToDressPage(WebDriver wd) {
		wd.navigate().to(URL_DRESS);
	}

	// Method to input quantity
	public static void inputQuantity(WebDriver wd) {
		WebElement quantity = wd.findElement(By.xpath(QUANTITY));
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.sendKeys("2");
	}

	// Method to select size
	public static void chooseSize(WebDriver wd) {
		Select size = new Select(wd.findElement(By.xpath(SIZE)));
		size.selectByVisibleText("M");
	}

	public static void chooseColor(WebDriver wd) {
		wd.findElement(By.xpath(COLOR)).click();
	}

	// Method for adding items to the cart
	public static void addToCart(WebDriver wd) {
		wd.findElement(By.xpath(ADD_TO_CART)).click();

	}

	// Method for proceeding to checkout
	public static void proceedToCheckout(WebDriver wd) {
		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKOUT)));
		wd.findElement(By.xpath(CHECKOUT)).click();
	}
}
