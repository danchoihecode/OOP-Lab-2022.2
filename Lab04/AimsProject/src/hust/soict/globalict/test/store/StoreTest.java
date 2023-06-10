package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		// Create a new store
		Store aStore = new Store();

		// Add items to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		aStore.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		aStore.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f, 0, null);
		aStore.addMedia(dvd3);

		// Remove an item
		aStore.removeMedia(dvd1);
	}
}
