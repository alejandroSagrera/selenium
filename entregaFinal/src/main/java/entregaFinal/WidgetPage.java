package entregaFinal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WidgetPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]//a[@title=\"My Account\"]")
	private WebElement accountLink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]//a[contains(text(),\"Login\")]")
	private WebElement loginLink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]//a[contains(text(),\"Register\")]")
	private WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li/a/span[contains(text(),\"Shopping Cart\")]")
	private WebElement shoppingLink;  

	public WidgetPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public By getPageLoadLocator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loginAction() {
		try {
			accountAction();
			BasePage.implicitWait("//*[@id=\"top-links\"]//a[contains(text(),\"Login\")]");
			loginLink.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void shoppingCartClick() {
		try {
			//BasePage.implicitWait("//*[@id=\"top-links\"]/ul/li/a/span[contains(text(),\"Shopping Cart\")]");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			shoppingLink.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void registerAction() {
		try {
			accountAction();
			BasePage.implicitWait("//*[@id=\"top-links\"]//a[contains(text(),\"Register\")]");
			registerLink.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void accountAction() {
		try {
			BasePage.implicitWait("//*[@id=\"top-links\"]//a[@title=\"My Account\"]");
			accountLink.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
