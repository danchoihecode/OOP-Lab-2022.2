package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame {

	private Store store;
	private Cart cart;

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JPanel createHeader() {

		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton btnCart = new JButton("View cart");
		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(cart, StoreScreen.this);

			}
		});

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddDigitalVideoDiscToStoreScreen(store, cart);

			}
		});
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddBookToStoreScreen(store, cart);

			}
		});
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddCompactDiscToStoreScreen(store, cart);

			}
		});
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));

		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CartScreen(cart, StoreScreen.this);

			}
		});
		menu.add(viewCart);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {

			MediaStore cell = new MediaStore(mediaInStore.get(i));

			MediaBtnListener mediaListener = new MediaBtnListener(cell.getMedia());
			cell.getAddToCart().addActionListener(mediaListener);
			if (cell.getPlay() != null) {
				cell.getPlay().addActionListener(mediaListener);
			}

			center.add(cell);
		}

		return center;
	}

	private class MediaBtnListener implements ActionListener {

		Media media;

		public MediaBtnListener(Media media) {
			this.media = media;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String btn = e.getActionCommand();
			String display;
			if (btn.equals("Play")) {
				try {
					display = ((Playable) media).play();

				} catch (PlayerException e1) {
					display = e1.getMessage();

				}
			} else {
				display = cart.addMedia(media);

			}

			JDialog dialog = new JDialog(StoreScreen.this, "Notification", true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLayout(new BorderLayout());

			JTextArea textArea = new JTextArea(display);
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);

			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(200, 100));

			dialog.getContentPane().add(scrollPane, BorderLayout.CENTER);

			dialog.pack();
			dialog.setLocationRelativeTo(StoreScreen.this);
			dialog.setVisible(true);

		}

	}

	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);

		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	public static void main(String[] args) {
		Store aStore = new Store();

		// Add some items to the store
		CompactDisc cd = new CompactDisc("The Lion King", "Animation", 19.95f, 50, "Roger Allers", "John Smith");
		Track track1 = new Track("Spring", 30);
		Track track2 = new Track("Autumn", 20);
		cd.addTrack(track1);
		cd.addTrack(track2);
		DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 0, "George Lucas");
		Book book = new Book("Tuoi tre", "Ky nang song", 20.5f);

		aStore.addMedia(cd);
		aStore.addMedia(dvd);
		aStore.addMedia(book);
		// Create a new cart
		Cart anOrder = new Cart();

		new StoreScreen(aStore, anOrder);

	}

}
