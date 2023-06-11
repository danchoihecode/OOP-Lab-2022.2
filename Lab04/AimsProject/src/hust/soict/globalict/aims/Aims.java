package hust.soict.globalict.aims;

import java.util.Scanner;
import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;

public class Aims {

	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner inp = new Scanner(System.in);

	public static void showMenu() {
		int op;
		do {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");

			op = inp.nextInt();
			inp.nextLine();
			switch (op) {
			case 0:
				System.out.println("Thank you for visiting !");
				inp.close();
				System.exit(0);
			case 1:
				storeMenu();
				break;
			case 2:
				updateStoreMenu();
				break;
			case 3:
				cartMenu();
			default:
				showMenu();
				break;
			}
		} while (op != 0);

	}

	public static void updateStoreMenu() {

		int op;
		do {
			System.out.println("Update store: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add a media");
			System.out.println("2. Remove a media");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");

			op = inp.nextInt();
			inp.nextLine();
			String key;
			Media media;
			switch (op) {
			case 0:
				showMenu();
				break;
			case 1:
				addMediaMenu();
				break;
			case 2:
				key = scanTitle();
				media = store.findByTitle(key);
				if (media == null) {
					updateStoreMenu();
				} else {
					store.removeMedia(media);
				}
				break;
			default:
				updateStoreMenu();
				break;
			}
		} while (op != 0);
	}

	public static void addMediaMenu() {
		int op;
		do {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add DVD");
			System.out.println("2. Add CD");
			System.out.println("3. Add Book");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");

			op = inp.nextInt();

			inp.nextLine();
			switch (op) {
			case 0:
				updateStoreMenu();
				break;
			case 1:
				addDVD();
				break;
			case 2:
				addCD();
				break;
			case 3:
				addBook();
				break;
			default:
				addMediaMenu();
				break;
			}
		} while (op != 0);

	}

	public static void addDVD() {

		System.out.println("Title :");
		String title = inp.nextLine();
		System.out.println("Category :");
		String category = inp.nextLine();
		System.out.println("Cost :");
		float cost = inp.nextFloat();
		System.out.println("Length :");
		int length = inp.nextInt();
		inp.nextLine();
		System.out.println("Director :");
		String director = inp.nextLine();

		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
		store.addMedia(dvd);

	}

	public static void addBook() {

		System.out.println("Title :");
		String title = inp.nextLine();
		System.out.println("Category :");
		String category = inp.nextLine();
		System.out.println("Cost :");
		float cost = inp.nextFloat();
		inp.nextLine();

		Book book = new Book(title, category, cost);
		System.out.println("List of authors (terminated by '.') :");
		String input = "";

		while (true) {

			input = inp.nextLine();
			if (input.equals("."))
				break;
			book.addAuthor(input);
		}
		store.addMedia(book);

	}

	public static void addCD() {

		System.out.println("Title :");
		String title = inp.nextLine();
		System.out.println("Category :");
		String category = inp.nextLine();
		System.out.println("Cost :");
		float cost = inp.nextFloat();
		inp.nextLine();
		System.out.println("Director :");
		String director = inp.nextLine();
		System.out.println("Artist :");
		String artist = inp.nextLine();

		CompactDisc cd = new CompactDisc(title, category, cost, 0, director, artist);
		System.out.println("List of tracks (terminated by '.', in the form title-length) :");
		String input = "";

		while (true) {

			input = inp.nextLine();
			if (input.equals("."))
				break;
			String[] str = input.split("-");
			Track track = new Track(str[0], Integer.parseInt(str[1]));
			cd.addTrack(track);

		}
		store.addMedia(cd);

	}

	public static void storeMenu() {
		int op;
		do {
			store.printStore();
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");

			String key;
			Media media;
			op = inp.nextInt();
			inp.nextLine();
			switch (op) {
			case 0:
				showMenu();
				break;
			case 1:
				mediaDetailsMenu();
				break;
			case 2:
				key = scanTitle();
				media = store.findByTitle(key);
				if (media == null) {
					storeMenu();
				} else {
					cart.addMedia(media);
				}
				break;
			case 3:
				key = scanTitle();
				media = store.findByTitle(key);
				if (media == null) {
					storeMenu();
				} else {
					play(media);
				}
				break;
			case 4:
				cartMenu();
				break;
			default:
				storeMenu();
				break;
			}
		} while (op != 0);
	}

	public static void mediaDetailsMenu() {
		String key = scanTitle();
		Media media = store.findByTitle(key);
		if (media == null) {
			storeMenu();
		} else {
			int op;
			do {
				System.out.println("Media information : ");
				System.out.println(media.toString());
				System.out.println("Options: ");
				System.out.println("--------------------------------");
				System.out.println("1. Add to cart");
				System.out.println("2. Play");
				System.out.println("0. Back");
				System.out.println("--------------------------------");
				System.out.println("Please choose a number: 0-1-2");

				op = inp.nextInt();
				inp.nextLine();
				switch (op) {
				case 0:
					storeMenu();
					break;
				case 1:
					cart.addMedia(media);
					break;
				case 2:
					play(media);
					break;
				default:
					mediaDetailsMenu();
					break;
				}
			} while (op != 0);
		}
	}

	public static void cartMenu() {

		int op;
		do {
			cart.printCart();
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");

			String key;
			Media media;
			op = inp.nextInt();
			inp.nextLine();
			switch (op) {
			case 0:
				showMenu();
				break;
			case 1:
				filterMenu();
				break;
			case 2:
				sortMenu();
				break;
			case 3:
				key = scanTitle();
				media = store.findByTitle(key);
				if (media == null) {
					storeMenu();
				} else {
					cart.removeMedia(media);
				}
				break;
			case 4:
				key = scanTitle();
				media = store.findByTitle(key);
				if (media == null) {
					storeMenu();
				} else {
					play(media);
				}
				break;
			case 5:
				System.out.println("An order is created");
				cart.emptyCart();
				break;
			default:
				cartMenu();
				break;
			}
		} while (op != 0);
	}

	public static void filterMenu() {
		int op;
		do {
			System.out.println("Filter media in cart: ");
			System.out.println("--------------------------------");
			System.out.println("1. By ID");
			System.out.println("2. By title");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");

			op = inp.nextInt();
			inp.nextLine();
			String key;
			switch (op) {
			case 0:
				cartMenu();
				break;
			case 1:
				System.out.println("Enter an ID: ");
				int id = inp.nextInt();
				cart.searchById(id);
				break;
			case 2:
				key = scanTitle();
				cart.searchByTitle(key);
				break;
			default:
				filterMenu();
				break;
			}
		} while (op != 0);

	}

	public static void sortMenu() {

		int op;
		do {
			System.out.println("Sort media in cart: ");
			System.out.println("--------------------------------");
			System.out.println("1. By title");
			System.out.println("2. By cost");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");

			op = inp.nextInt();

			inp.nextLine();
			switch (op) {
			case 0:
				cartMenu();
				break;
			case 1:
				cart.sortByTitle();
				break;
			case 2:
				cart.sortByCost();
				break;
			default:
				sortMenu();
				break;
			}
		} while (op != 0);

	}

	public static boolean checkValidity(String key) {

		if (key.startsWith(" ")) {
			return false;
		}

		for (char c : key.toCharArray()) {

			if (!Character.isLetterOrDigit(c) && c != ' ') {
				return false;
			}
		}

		return true;
	}

	public static void play(Media media) {
		if (media instanceof Book) {
			System.out.println("The media is a book, can not play it!");
		} else {
			Playable m = (Playable) media;
			m.play();
		}
	}

	public static String scanTitle() {

		String key;
		do {
			System.out.println("Enter the title of the media: ");
			key = inp.nextLine();
		} while (!checkValidity(key));
		return key;

	}

	public static void main(String[] args) {

		showMenu();

	}

}
