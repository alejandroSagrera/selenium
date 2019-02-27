package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

	@FindBy(how = How.ID, using = "input-firstname")
	private WebElement inputFirstName;

	@FindBy(how = How.ID, using = "input-lastname")
	private WebElement inputLastName;

	@FindBy(how = How.ID, using = "input-email")
	private WebElement inputMail;

	@FindBy(how = How.ID, using = "input-telephone")
	private WebElement inputTel;

	@FindBy(how = How.ID, using = "input-address-1")
	private WebElement inputDir;

	@FindBy(how = How.ID, using = "input-city")
	private WebElement inputCit;

	@FindBy(how = How.ID, using = "input-postcode")
	private WebElement inputPostCod;

	@FindBy(how = How.ID, using = "input-country")
	private WebElement selectCountry;

	@FindBy(how = How.ID, using = "input-zone")
	private WebElement selectZone;

	@FindBy(how = How.ID, using = "input-password")
	private WebElement inputPassw;

	@FindBy(how = How.ID, using = "input-confirm")
	private WebElement inputPasswConfirm;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]//input[@name=\"agree\"]")
	private WebElement inputAgree;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]//input[@type=\"submit\"]")
	private WebElement btnContinuar;

	public void completeRegisterForm(String firstName, String lastName, String email, String telephone, String adress,
			String city, String postCode, String selectCountryText, String selectZoneText, String passw,
			String confirmPassw) {
		try {
			inputFirstName.sendKeys(firstName);
			inputLastName.sendKeys(lastName);
			inputMail.sendKeys(email);
			inputTel.sendKeys(telephone);
			inputDir.sendKeys(adress);
			inputCit.sendKeys(city);
			inputPostCod.sendKeys(postCode);
			Select comboPais = new Select(selectCountry);
			comboPais.selectByVisibleText(selectCountryText);
			Select comboZone = new Select(selectZone);
			comboZone.selectByVisibleText(selectZoneText);
			inputPassw.sendKeys(passw);
			inputPasswConfirm.sendKeys(confirmPassw);
			inputAgree.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public RegisterResultPage clicContinuar() {
		BasePage.implicitWait("//*[@id=\"content\"]//input[@type=\"submit\"]");
		btnContinuar.click();
		return new RegisterResultPage(driver);
	}

	public RegisterPage(WebDriver driver) {
		super(driver);
		if (!this.isLoaded()) {
			throw new IllegalStateException("No es la web de registro");
		}
	}

	@Override
	public By getPageLoadLocator() {
		return By.xpath("//*[@id=\"content\"]/h1[contains(text(),\"Register Account\")]");
	}

}
