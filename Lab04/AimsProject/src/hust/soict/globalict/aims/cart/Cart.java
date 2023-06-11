package hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;

	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(MAX_NUMBERS_ORDERED);

	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else if (itemsOrdered.contains(media)){
			System.out.println("The media is already in the cart");
		} else {
			itemsOrdered.add(media);
			System.out.println("The media has been added to the cart");
		}
	}

	public void removeMedia(Media media) {
		int idx = itemsOrdered.indexOf(media);
		if (idx != -1) {
			itemsOrdered.remove(idx);
			System.out.println("The media has been removed from the cart");
		} else {
			System.out.println("The media is not in the cart");
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
		Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
		printCart();
	}
	
	public void sortByCost() {
		Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
		printCart();
	}
	
	public void emptyCart() {
		itemsOrdered.clear();
	}

	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
}
