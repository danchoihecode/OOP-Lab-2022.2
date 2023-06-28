package hust.soict.globalict.aims.screen;

import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends JFrame {
	private JLabel titleLabel, categoryLabel, costLabel, lengthLabel, directorLabel, artistLabel;
	private JTextField titleTextField, categoryTextField, costTextField, lengthTextField, directorTextField,
			artistTextField;
	private JButton okButton;
	private Store store;
	private Cart cart;

	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;

		titleLabel = new JLabel("Title:");
		categoryLabel = new JLabel("Category:");
		costLabel = new JLabel("Cost:");
		lengthLabel = new JLabel("Length:");
		directorLabel = new JLabel("Director:");
		artistLabel = new JLabel("Artist:");

		titleTextField = new JTextField(20);
		categoryTextField = new JTextField(20);
		costTextField = new JTextField(20);
		lengthTextField = new JTextField(20);
		directorTextField = new JTextField(20);
		artistTextField = new JTextField(20);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titleTextField.getText();
				String category = categoryTextField.getText();
				float cost = Float.parseFloat(costTextField.getText());
				int length = Integer.parseInt(lengthTextField.getText());
				String director = directorTextField.getText();
				String artist = artistTextField.getText();

				CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
				store.addMedia(cd);
				setVisible(false);
				new StoreScreen(store, cart);
			}
		});

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(7, 2));
		mainPanel.add(titleLabel);
		mainPanel.add(titleTextField);
		mainPanel.add(categoryLabel);
		mainPanel.add(categoryTextField);
		mainPanel.add(costLabel);
		mainPanel.add(costTextField);
		mainPanel.add(lengthLabel);
		mainPanel.add(lengthTextField);
		mainPanel.add(directorLabel);
		mainPanel.add(directorTextField);
		mainPanel.add(artistLabel);
		mainPanel.add(artistTextField);
		mainPanel.add(new JLabel()); // Empty label for spacing
		mainPanel.add(okButton);

		setTitle("Add Compact Disc to Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setVisible(true);
	}
}
