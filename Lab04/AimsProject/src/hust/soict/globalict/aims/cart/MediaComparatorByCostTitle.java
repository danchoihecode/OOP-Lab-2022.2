package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media m1, Media m2) {

		int costComparison = Float.compare(m2.getCost(), m1.getCost());
		if (costComparison != 0) {

			return costComparison;
		} else {
			return m1.getTitle().compareTo(m2.getTitle());
		}
	}

}
