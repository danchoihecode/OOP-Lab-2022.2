package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
	private int numberOfItem = 0;

	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore[numberOfItem] = disc;
		numberOfItem++;
		System.out.println("The disc has been added to the store");
	}

	public void removeDVD(DigitalVideoDisc disc) {
		for (int i = 0; i < numberOfItem; i++) {
			if (itemsInStore[i] == disc) {
				for (int j = i; j < numberOfItem - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}
				numberOfItem--;
				itemsInStore[numberOfItem] = null;
				System.out.println("The disc has been removed from the store");
				break;
			}
		}

	}

}
