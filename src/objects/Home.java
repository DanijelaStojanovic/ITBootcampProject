package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	public static final String HOME_URL = "http://automationpractice.com/index.php";
	public static final String WOMAN = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	public static final String DRESSES = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]";
	public static final String WOMAN_SUMMER_DRESSES = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";
	public static final String DRESSES_SUMMER_DRESSES = "//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
	public static final String LOG_OUT = "//a[@class='logout']";
	public static final String SIGN_IN = "//a[@class='login']";
	
	// Method for opening HomePage
	public static void openPage(WebDriver wd) {
		wd.get(HOME_URL);
	}

	// Method for navigation to HomePage from other page
	public static void navigateToPage(WebDriver wd) {
		wd.navigate().to(HOME_URL);
	}

	// Method for hover woman button
	public static void hoverWoman(WebDriver webdriver) {
		Actions action = new Actions(webdriver);
		WebElement webel = webdriver.findElement(By.xpath(WOMAN));
		action.moveToElement(webel).perform();
	}

	// Method for selecting the Summerdresses button from Woman
	public static void clickSumDressWoman(WebDriver webdriver) {

		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WOMAN_SUMMER_DRESSES)));
		webdriver.findElement(By.xpath(WOMAN_SUMMER_DRESSES)).click();
	}

	// Method for hover the Dresses button
	public static void hoverDresses(WebDriver webdriver) {
		Actions action = new Actions(webdriver);
		WebElement webel = webdriver.findElement(By.xpath(DRESSES));
		action.moveToElement(webel).perform();
	}

	// Method for selecting the Summerdresses button from Dresses
	public static void clickSumDressDresses(WebDriver webdriver) {
		WebDriverWait wait = new WebDriverWait(webdriver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DRESSES_SUMMER_DRESSES)));
		webdriver.findElement(By.xpath(DRESSES_SUMMER_DRESSES)).click();
	}
	//Method for selecting signOut button
	public static void clickSignOut(WebDriver webdriver) {
		webdriver.findElement(By.xpath(LOG_OUT)).click();
	}
	//Method for selecting signIn button
		public static void clickSignIn(WebDriver webdriver) {
			webdriver.findElement(By.xpath(SIGN_IN)).click();
		}
	}

