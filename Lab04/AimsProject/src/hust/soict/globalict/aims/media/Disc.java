package hust.soict.globalict.aims.media;

public class Disc extends Media {

	private int length;
	private String director;

	public Disc(String title, String category, float cost, int length, String director) {

		super(title, category, cost);
		this.length = length;
		this.director = director;

	}

	public Disc(String title) {
		super(title);
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

}
