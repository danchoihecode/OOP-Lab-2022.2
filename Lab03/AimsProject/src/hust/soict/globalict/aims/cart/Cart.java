package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		for (DigitalVideoDisc i : dvdList) {
			if (i == null)
				break;
			addDigitalVideoDisc(i);
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemOrdered[j] = itemOrdered[j + 1];
				}
				qtyOrdered--;
				itemOrdered[qtyOrdered] = null;
				System.out.println("The disc has been removed");
				break;
			}
		}

	}

	public void printCart() {
		System.out.println("*********************************CART*********************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**********************************************************************");
	}

	public void searchById(int id) {
		boolean found = false;
		System.out.println("Search by ID result:");
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i].getId() == id) {
				found = true;
				System.out.println(itemOrdered[i].toString());
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
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i].isMatch(title)) {
				found = true;
				System.out.println(itemOrdered[i].toString());
			}
		}
		if (!found) {
			System.out.println("No match is found !");
		}
	}
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemOrdered[i].getCost();
		}
		return sum;
	}
}
