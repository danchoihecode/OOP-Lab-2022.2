package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media m1, Media m2) {

		int titleComparison = m1.getTitle().compareTo(m2.getTitle());
		if (titleComparison != 0) {

			return titleComparison;
		} else {

			return Float.compare(m2.getCost(), m1.getCost());
		}
	}

}
