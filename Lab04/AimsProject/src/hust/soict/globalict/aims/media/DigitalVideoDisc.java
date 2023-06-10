package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {

		super(title, category, cost, length, director);

	}

	@Override
	
	public String toString() {
		return "DVD - " + super.toString();
	}

	@Override
	
	public void play() {

		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

}
