package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {
	public static final String E_MAIL = "//input[@id='email']";
	public static final String PASSWORD = "//input[@id='passwd']";
	public static final String SIGN_IN = "//p[@class='submit']//span[1]";

	// Method to navigate to SignIn page
	public static void navigateToLogin(WebDriver wd) {
		wd.navigate().to(Registration.REG_PAGE_URL);
	}

	// Method for entering e-mail address for sign in
	public static void inputEmail(WebDriver wd, String email) {
		WebElement mail = wd.findElement(By.xpath(E_MAIL));
		mail.click();
		mail.sendKeys(email);
	}

	// Method for entering Password for sign in
	public static void inputPassword(WebDriver wd, String password) {
		WebElement pass = wd.findElement(By.xpath(PASSWORD));
		pass.sendKeys(password);
	}

	// Method to click on SignIn button
	public static void clickSignInBtn(WebDriver wd) {
		wd.findElement(By.xpath(SIGN_IN)).click();
	}
}