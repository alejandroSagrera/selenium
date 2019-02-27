package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]//button")
	private WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]//input")
	private WebElement inputSearch;

	@FindBy(how = How.XPATH, using = "//*[@type=\"button\"]/span[contains(text(),\"Add to Cart\")][1]")
	private WebElement inputAddToCart;

	public AddToCartResultPage clickAddToCart() {
		try {
			BasePage.implicitWait("//*[@type=\"button\"]/span[contains(text(),\"Add to Cart\")][1]");
			inputAddToCart.click();
			return new AddToCartResultPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public EmptyCartPage addToCartShopping() {
		try {
			BasePage.implicitWait("//*[@type=\"button\"]/span[contains(text(),\"Add to Cart\")][1]");
			inputAddToCart.click();
			WidgetPage wp = new WidgetPage(driver);
			wp.shoppingCartClick();
			return new EmptyCartPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public LoginPage clickLoginLink() {
		try {
			WidgetPage wp = new WidgetPage(driver);
			wp.loginAction();
			return new LoginPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public RegisterPage clickRegisterLink() {
		try {
			WidgetPage wp = new WidgetPage(driver);
			wp.registerAction();
			return new RegisterPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void searchProduct(String product) {
		try {
			BasePage.implicitWait("//*[@id=\"search\"]//input");
			inputSearch.sendKeys(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public SearchResultPage clickSearchButton() {
		try {
			BasePage.implicitWait("//*[@id=\"search\"]//button");
			btnSearch.click();
			return PageFactory.initElements(driver, SearchResultPage.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.id("slideshow0");
	}

	public HomePage(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException("No es la web inicial");
		}
	}

}
