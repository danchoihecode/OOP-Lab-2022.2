package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {

		super(title, category, cost, length, director);

	}

	public DigitalVideoDisc(String title) {
		super(title);
	}

	@Override

	public String toString() {
		return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": "
				+ getCost() + " $";
	}

	@Override

	public String play() throws PlayerException {

		if (this.getLength() > 0) {
			StringBuilder str = new StringBuilder();
			if (this.getLength() <= 0) {
				str.append("The DVD ").append(this.getTitle()).append(" can not be played !");
			} else {
				str.append("Playing DVD: ").append(this.getTitle());
				str.append("\nDVD length: ").append(this.getLength());
			}
			return str.toString();
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}

}
