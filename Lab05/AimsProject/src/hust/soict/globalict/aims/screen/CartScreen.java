package hust.soict.globalict.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

	private Cart cart;
	private StoreScreen storeScreen;

	public CartScreen(Cart cart, StoreScreen storeScreen) {
		super();

		this.cart = cart;
		this.storeScreen = storeScreen;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);

		this.setTitle("Cart");
		this.setVisible(true);
		setSize(1024, 768);

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {

					FXMLLoader loader = new FXMLLoader(
							getClass().getResource("/hust/soict/globalict/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart, CartScreen.this, storeScreen);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

	}

}
