package hust.soict.globalict.aims.media;

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

	public void play() {

		if (this.getLength() <= 0) {
			System.out.println("The DVD " + this.getTitle() + " can not be played !");
		} else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());

		}
	}

}
