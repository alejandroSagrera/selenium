package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddToCartPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]/span")
	private WebElement inputAddToCart;

	@FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]//*[contains(text(),\"Shopping Cart\")]")
	private WebElement btnCart;

	public AddToCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public By getPageLoadLocator() {
		// TODO Auto-generated method stub
		return null;
	}

}
