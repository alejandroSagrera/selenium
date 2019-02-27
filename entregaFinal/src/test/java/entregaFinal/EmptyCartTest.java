package entregaFinal;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class EmptyCartTest extends BaseTest {

	@Test
	public void vaciarElCarroTest() {
		homePage.searchProduct("iPhone");
		SearchResultPage searchPage = homePage.clickSearchButton();
		if (!searchPage.getProductName().isEmpty()) {
			EmptyCartPage emptyCart = homePage.addToCartShopping();
			EmptyCartResultPage emptyCartRestult = emptyCart.clickDeleteItem();
			AssertJUnit.assertEquals("Your shopping cart is empty!", "Your shopping cart is empty!");
			System.out.println(emptyCartRestult.getLbnEmptyCart());
		}
	}
}
