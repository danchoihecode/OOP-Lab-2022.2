package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category, float cost, int length, String director, String artist) {

		super(title, category, cost, length, director);
		this.artist = artist;

	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track is already in the list.");
		} else {
			tracks.add(track);
			System.out.println("The track has been added");
		}

	}

	public void removeTrack(Track track) {
		int idx = tracks.indexOf(track);
		if (idx == -1) {
			System.out.println("The track does not exist in the list.");
		} else {
			tracks.remove(idx);
			System.out.println("The track has been removed");
		}

	}

	@Override
	public int getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Track track : tracks) {
			str.append(track.toString()).append(";");
		}
		return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " - "
				+ getArtist() + ": " + getCost() + " $\n" + str.toString();
	}

	@Override
	public String play() throws PlayerException {

		if (this.getLength() > 0) {
			StringBuilder str = new StringBuilder();
			if (this.getLength() <= 0) {
				str.append("The CD ").append(this.getTitle()).append(" can not be played !");
			} else {
				str.append("Playing CD: ").append(this.getTitle());
				str.append("\nCD length: ").append(this.getLength());

				Iterator<Track> iter = tracks.iterator();
				Track nextTrack;
				while (iter.hasNext()) {
					nextTrack = (Track) iter.next();
					try {
						str.append("\n").append(nextTrack.play());
					} catch (PlayerException e) {
						throw e;
					}
				}
				return str.toString();

			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
		return null;

	}
}
