package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmptyCartResultPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/p[contains(text(),\"Your shopping cart is empty!\")]")
	private WebElement lbnEmptyCart;

	public EmptyCartResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getLbnEmptyCart() {
		try {
			BasePage.implicitWait("//*[@id=\"content\"]/p[contains(text(),\"Your shopping cart is empty!\")]");
			return lbnEmptyCart.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public By getPageLoadLocator() {
		// TODO Auto-generated method stub
		return null;
	}

}
