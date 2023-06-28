package hust.soict.globalict.aims.cart;

import java.util.Collections;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;

	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();;

	public String addMedia(Media media) {

		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {

			return "The cart is almost full";
		} else if (itemsOrdered.contains(media)) {
			return "The media is already in the cart";
		} else {
			itemsOrdered.add(media);
			return "The media has been added to the cart";
		}
	}

	public String removeMedia(Media media) {
		int idx = itemsOrdered.indexOf(media);
		if (idx != -1) {
			itemsOrdered.remove(idx);
			return "The media has been removed from the cart";
		} else {
			return "The media is not in the cart";
		}
	}

	public void printCart() {
		System.out.println("*********************************CART*********************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**********************************************************************");
	}

	public void searchById(int id) {
		boolean found = false;
		System.out.println("Search by ID result:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				found = true;
				System.out.println(itemsOrdered.get(i).toString());
				break;
			}
		}
		if (!found) {
			System.out.println("No match is found !");
		}
	}

	public void searchByTitle(String title) {
		boolean found = false;
		System.out.println("Search by title result: ");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(title)) {
				found = true;
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		if (!found) {
			System.out.println("No match is found !");
		}
	}

	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		printCart();
	}

	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		printCart();
	}

	public String emptyCart() {
		itemsOrdered.clear();
		return "An order is created. Thank you for purchasing !";
	}

	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

}
