package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;

	private CartScreen cartScreen;

	private StoreScreen storeScreen;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediacategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private Button btnPlaceOrder;

	@FXML
	private Label labelTotalCost;

	@FXML
	private MenuItem menuViewStore;

	public CartScreenController(Cart cart, CartScreen cartScreen, StoreScreen storeScreen) {

		this.cart = cart;
		this.cartScreen = cartScreen;
		this.storeScreen = storeScreen;
	}

	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		updateTotalCost();

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {

				if (newValue != null) {
					updateButtonBar(newValue);
					updateTotalCost();
				}
			}

		});

	}

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}

	}

	void updateTotalCost() {

		labelTotalCost.setText(Float.toString(cart.totalCost()) + " $");
	}

	@FXML
	void btnPlayPressed(ActionEvent event) {

		Media media = tblMedia.getSelectionModel().getSelectedItem();
		String display;
		try {
			display = ((Playable) media).play();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Playing media");
			alert.setHeaderText(null);
			alert.setContentText(display);
			alert.showAndWait();
		} catch (PlayerException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Playing media failed !");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}

	}

	@FXML
	void btnRemovePressed(ActionEvent event) {

		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);

	}

	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {

		String display = cart.emptyCart();
		updateTotalCost();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Place order");
		alert.setHeaderText(null);
		alert.setContentText(display);
		alert.showAndWait();

	}

	@FXML
	void menuViewStorePressed(ActionEvent event) {

		if (cartScreen != null) {
			cartScreen.setVisible(false);
			storeScreen.setVisible(true);
		}

	}

}
