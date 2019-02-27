package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterResultPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h1")
	private WebElement lbnAccount;

	public String getLbnAccount() {
		BasePage.implicitWait("//*[@id=\"content\"]/h1");
		return lbnAccount.getText();
	}

	public RegisterResultPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public By getPageLoadLocator() {
		// TODO Auto-generated method stub
		return null;
	}

}
