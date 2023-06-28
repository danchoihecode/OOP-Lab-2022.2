package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {

	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {

		if (itemsInStore.contains(media)) {
			System.out.println("The media is already in the store");
		} else {
			itemsInStore.add(media);
			System.out.println("The media has been added to the store");
		}

	}

	public void removeMedia(Media media) {
		int idx = itemsInStore.indexOf(media);
		if (idx != -1) {
			itemsInStore.remove(idx);
			System.out.println("The media has been removed from the store");
		} else {
			System.out.println("The media is not in the store");
		}
	}

	public Media findByTitle(String title) {
		for (Media m : itemsInStore) {
			
			if (m.getTitle().equals(title)) {
				return m;
			}
		}
		System.out.println("Can not find the media with your title !");
		return null;
	}

	public void printStore() {
		System.out.println("*********************************STORE*********************************");
		System.out.println("Items in store:");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
		}
		System.out.println("**********************************************************************");
	}

	public ArrayList<Media> getItemsInStore() {
		
		return itemsInStore;
	}

}
