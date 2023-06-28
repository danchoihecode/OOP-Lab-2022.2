package hust.soict.globalict.aims.media;

import java.util.Comparator;

import hust.soict.globalict.aims.cart.MediaComparatorByCostTitle;
import hust.soict.globalict.aims.cart.MediaComparatorByTitleCost;

public abstract class Media {

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbOfItem = 0;

	public Media(String title, String category, float cost) {
		nbOfItem++;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbOfItem;
	}

	public Media(String title) {
		nbOfItem++;
		this.title = title;
		this.id = nbOfItem;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isMatch(String title) {
		String[] words = title.toLowerCase().split("\\s+");
		for (String word : words) {
			if (this.getTitle().toLowerCase().contains(word)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof Media)
				return this.title.equals(((Media) obj).title);
			else
				return false;
		} catch (NullPointerException e) {
			return false;
		}

	}

}
