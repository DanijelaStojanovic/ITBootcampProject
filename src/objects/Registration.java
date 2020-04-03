package objects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	public static final String REG_PAGE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static final String E_MAIL = "//input[@id='email_create']";
	public static final String CREATE_BTN = "//button[@id='SubmitCreate']";
	private static final String FIRST_NAME = "//input[@id='customer_firstname']";
	private static final String LAST_NAME = "//input[@id='customer_lastname']";
	private static final String EMAIL = "//input[@id='email']";
	private static final String PASSWORD = "//input[@id='passwd']";
	private static final String ADDRESS1 = "//input[@id='address1']";
	private static final String CITY = "//input[@id='city']";
	private static final String STATE = "//select[@id='id_state']";
	private static final String ZIP = "//input[@id='postcode']";
	private static final String COUNTRY = "//select[@id='id_country']";
	private static final String PHONE = "//input[@id='phone_mobile']";
	private static final String REGISTRATION_BTN = "//span[contains(text(),'Register')]";
	private static final String ALIAS_ADDRESS = "//input[@id='alias']";
	public static final String REG_URL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0#account-creation";
	public static final String ACCOUNT_CHECK = "//a[@class='account']";

	//Method to navigate to Registration page
	public static void navigateToRegister(WebDriver wd) {
		wd.navigate().to(REG_PAGE_URL);
	}
	// Method to find e-mail input field
	public static WebElement getEmail(WebDriver wd) {
		return wd.findElement(By.xpath(E_MAIL));
	}

	// Method to click on e-mail input field
	public static void clickEmail(WebDriver wd) {
		getEmail(wd).click();
	}

	// Method to get value from email field
	public static String getEmailValue(WebDriver wd) {
		String emailValue = getEmail(wd).getAttribute("value");
		return emailValue;
	}

	// Method to set email
	public static void inputEmail(WebDriver wd) {
		WebElement elem = getEmail(wd);
		elem.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(50);
		elem.sendKeys("lelaaa" + randomInt + "@gmail.com");

	}

	// Method to click on Create an account button
	public static void clickCreateAccount(WebDriver wd) {
		wd.findElement(By.xpath(CREATE_BTN)).click();
	}

	// Method for input to field First name
	public static void inputFirstName(WebDriver wd, String firstname) {
		WebElement elem = wd.findElement(By.xpath(FIRST_NAME));
		elem.sendKeys(firstname);
	}

	// Method for input to field Last name
	public static void inputLastName(WebDriver wd, String lastname) {
		WebElement elem = wd.findElement(By.xpath(LAST_NAME));
		elem.sendKeys(lastname);
	}

	// Method for input to field Password
	public static void inputPass(WebDriver wd, String password) {
		WebElement elem = wd.findElement(By.xpath(PASSWORD));
		elem.sendKeys(password);
	}

	// Method for input to field Address
	public static void inputaddress(WebDriver wd, String address) {
		WebElement elem = wd.findElement(By.xpath(ADDRESS1));
		elem.sendKeys(address);
	}

	// Method for input to field City
	public static void inputCity(WebDriver wd, String city) {
		WebElement elem = wd.findElement(By.xpath(CITY));
		elem.sendKeys(city);
	}

	// Method for choosing State from dropdown list
	public static void state(WebDriver wd, String state) {
		Select statefld = new Select(wd.findElement(By.xpath(STATE)));
		statefld.selectByVisibleText(state);

	}

	// Method for input to field Zip code
	public static void inputZipCode(WebDriver wd, String postalcode) {
		WebElement elem = wd.findElement(By.xpath(ZIP));
		elem.sendKeys(postalcode);
	}

	// Method for select field Country
	public static void country(WebDriver wd) {
		wd.findElement(By.xpath(COUNTRY)).click();
	}

	// Method for input to field Mobile phone
	public static void inputMobPhone(WebDriver wd, String mob) {
		WebElement elem = wd.findElement(By.xpath(PHONE));
		elem.sendKeys(mob);
	}

	// Method for input to field Mobile phone
	public static void inputAliasAddress(WebDriver wd, String aliasadress) {
		WebElement elem = wd.findElement(By.xpath(ALIAS_ADDRESS));
		elem.sendKeys(aliasadress);
	}

	// Method for click on Registration button
	public static void clickRegBtn(WebDriver wd) {
		wd.findElement(By.xpath(REGISTRATION_BTN)).click();
	}

}
