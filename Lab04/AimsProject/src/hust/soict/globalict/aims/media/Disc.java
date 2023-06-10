package hust.soict.globalict.aims.media;

public class Disc extends Media {

	private int length;
	private String director;

	public Disc(String title, String category, float cost, int length, String director) {

		super(title, category, cost);
		this.length = length;
		this.director = director;

	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	@Override
	public String toString() {
		return getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost()
				+ " $";
	}

}
