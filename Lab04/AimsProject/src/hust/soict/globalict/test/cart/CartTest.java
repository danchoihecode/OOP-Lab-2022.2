package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();

		// Add items to the cart
		CompactDisc cd = new CompactDisc("The Lion King", "Animation", 24.95f, 0, "Roger Allers", "John Smith");
		Track track1 = new Track("Jungle",30);
		Track track2 = new Track("Snow",20);
		cd.addTrack(track1);
		cd.addTrack(track2);
		anOrder.addMedia(cd);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		anOrder.addMedia(dvd2);

		Book book = new Book("Tuoi tre", "Ky nang song", 20.5f);
		anOrder.addMedia(book);

		// Test the sort methods
		anOrder.sortByCost();

		// Test the search methods
//		anOrder.searchById(2);
//		anOrder.searchByTitle("The Lion");

		// Illustration for polymorphism
//		List<Media> mediae = new ArrayList<Media>();
//
//		Media cd = new CompactDisc("The Lion King", "Animation", 19.95f, 20, "Roger Allers", "John Smith");
//		Media dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
//		Media book = new Book("Tuoi tre", "Ky nang song", 20.5f);
//		
//		mediae.add(cd);
//		mediae.add(dvd);
//		mediae.add(book);
//		
//		for (Media m:mediae) {
//			System.out.println(m.toString());
//		}
		
		

	}
}
