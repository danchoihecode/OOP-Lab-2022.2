package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {

		// Create a new cart
		Cart anOrder = new Cart();

		// Add items to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f, 0, null);

		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		// Print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());

		// Remove an item
		anOrder.removeMedia(dvd1);

	}

}
