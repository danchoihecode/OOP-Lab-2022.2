package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();

		// Add items to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		anOrder.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		anOrder.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f, 0, null);
		anOrder.addMedia(dvd3);

		// Test the print method
		anOrder.printCart();

		// Test the search methods
		anOrder.searchById(2);
		anOrder.searchByTitle("The Lion");

	}
}
