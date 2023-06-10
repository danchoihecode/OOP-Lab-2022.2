package hust.soict.globalict.aims.media;

import java.util.ArrayList;

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

	public int getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}

	@Override

	public String toString() {
		return "CD - " + super.toString();
	}

	@Override

	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks) {
			track.play();
		}

	}

}
