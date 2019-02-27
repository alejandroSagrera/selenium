package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginResultPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2[contains(text(),\"My Account\")]")
	private WebElement lbnAccount;

	@FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]//a[contains(text(),\"Logout\")]")
	private WebElement linkLogout;

	public String getLbnAccount() {
		BasePage.implicitWait("//*[@id=\"content\"]/h2[contains(text(),\"My Account\")]");
		return lbnAccount.getText();
	}

	public LogOutResultPage clickLogOut() {
		try {
			WidgetPage wp = new WidgetPage(driver);
			wp.accountAction();
			BasePage.implicitWait("//*[@id=\"top-links\"]//a[contains(text(),\"Logout\")]");
			linkLogout.click();
			return new LogOutResultPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public LoginResultPage(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException("No es la web de usuario logueado");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.xpath("//*[@id=\"content\"]/h2[contains(text(),\"My Account\")]");
	}

}
