package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public Book(String title, String category, float cost) {

		super(title, category, cost);

	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("The author is already in the list");
		} else {
			authors.add(authorName);
			System.out.println("The author has been added");
		}

	}

	public void removeAuthor(String authorName) {
		int idx = authors.indexOf(authorName);
		if (idx == -1) {
			System.out.println("The author is not present in the list");
		} else {
			authors.remove(idx);
			System.out.println("The author has been removed");
		}

	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (String author : authors) {
			str.append(author).append(" - ");
		}
		return "Book - " + getTitle() + " - " + getCategory() + " - " + str.toString() + ": " + getCost() + " $";
	}

}
