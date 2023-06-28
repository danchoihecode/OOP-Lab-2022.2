package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

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

	public String play() throws PlayerException {

		if (this.getLength() > 0) {
			StringBuilder str = new StringBuilder();
			if (this.getLength() <= 0) {
				str.append("The track ").append(this.getTitle()).append(" can not be played !");
			} else {
				str.append("Playing track: ").append(this.getTitle());
				str.append("\nTrack length: ").append(this.getLength());
			}
			return str.toString();
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
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
