package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	@FindBy(how = How.ID, using = "input-email")
	private WebElement inputMail;

	@FindBy(how = How.ID, using = "input-password")
	private WebElement inputPassw;

	@FindBy(how = How.XPATH, using = "//*[@type=\"submit\"]")
	private WebElement btnLogin;

	public void logInputs(String mail, String passw) {
		inputMail.sendKeys(mail);
		inputPassw.sendKeys(passw);
	}

	public LoginResultPage clickLogin() {
		try {
			BasePage.implicitWait("//*[@type=\"submit\"]");
			btnLogin.click();
			return new LoginResultPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public LoginWrongResultPage clickLoginWrongData() {
		try {
			BasePage.implicitWait("//*[@type=\"submit\"]");
			btnLogin.click();
			return new LoginWrongResultPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public LoginPage(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException("No es la web de login");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.xpath("//*[@class=\"well\"]//h2[contains(text(),\"Returning Customer\")]");
	}

}
