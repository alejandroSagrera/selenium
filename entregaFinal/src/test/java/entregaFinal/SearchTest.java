package entregaFinal;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelConfig;
import org.junit.runner.RunWith;
import org.testng.AssertJUnit;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class SearchTest extends BaseTest {

	@Test(dataProvider = "testdataProducts")
	public void test(String product, String price) {
		homePage.searchProduct(product);
		SearchResultPage searchPage = homePage.clickSearchButton();
		AssertJUnit.assertEquals("Product Label Name is not the expected: " + product, searchPage.getProductName(),
				product);
		AssertJUnit.assertEquals("Product Price is not the expected: " + price, searchPage.getProductPrice(), price);

	}

	@DataProvider
	public Object[][] testdataProducts() {
		ExcelConfig ex = new ExcelConfig("src/productList.xlsx");
		Object data[][] = ex.readExcel();
		return data;
	}
}
