package entregaFinal;

import org.junit.runner.RunWith;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import entregaFinal.BaseTest;
import Utilities.ExcelConfig;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class RegisterTest extends BaseTest {

	@Test(dataProvider = "testDataRegister")
	public void testRegisterOk(String firstName, String lastName, String email, String telephone, String adress,
			String city, String postCode, String selectCountry, String selectZone, String passw, String confirmPassw) {
		RegisterPage registerPage = homePage.clickRegisterLink();
		registerPage.completeRegisterForm(firstName, lastName, email, telephone, adress, city, postCode, selectCountry,
				selectZone, passw, confirmPassw);
		RegisterResultPage registerResult = registerPage.clicContinuar();
		AssertJUnit.assertEquals("Your Account Has Been Created!", registerResult.getLbnAccount());
	}

	@DataProvider
	public Object[][] testDataRegister() {
		try {
			ExcelConfig ex = new ExcelConfig("src/registerData.xlsx");
			Object data[][] = ex.readExcel();
			return data;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
