package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDresses {
	
	public static final String URL_SUMMER_DRESSES = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static final String DRESS = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 "
			+ "first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']"
			+ "//a[@class='product-name'][contains(text(),'Printed Summer Dress')]";

	// Method for opening SummerDresses page
	public static void openSumDressPage(WebDriver wd) {
		wd.get(URL_SUMMER_DRESSES);
	}

	// Method for navigation to page Summer dresses
	public static void navigateToSumDressPage(WebDriver wd) {
		wd.navigate().to(URL_SUMMER_DRESSES);
	}

	// Method to choose first dress
	public static void chooseDress(WebDriver wd) {
		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DRESS)));
		wd.findElement(By.xpath(DRESS)).click();
	}

	
}
