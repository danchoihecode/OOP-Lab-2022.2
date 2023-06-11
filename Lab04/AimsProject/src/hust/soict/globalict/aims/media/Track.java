package hust.soict.globalict.aims.media;

public class Track implements Playable {

	private String title;
	private int length;

	public Track(String title, int length) {

		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override

	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("The track " + this.getTitle() + " can not be played !");
		} else {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track media = (Track) obj;
			return this.title == null ? media.title == null && this.length == media.length
					: this.title.equals(media.title) && this.length == media.length;
		} else
			return false;
	}
	
	@Override
	public String toString() {
		return "Track - " + getTitle() + " - " + getLength();
	}

}
