package hust.soict.globalict.aims.screen;

import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
	private JLabel titleLabel, categoryLabel, costLabel, lengthLabel, directorLabel;
	private JTextField titleTextField, categoryTextField, costTextField, lengthTextField, directorTextField;
	private JButton okButton;
	private Store store;
	private Cart cart;

	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;

		titleLabel = new JLabel("Title:");
		categoryLabel = new JLabel("Category:");
		costLabel = new JLabel("Cost:");
		lengthLabel = new JLabel("Length:");
		directorLabel = new JLabel("Director:");

		titleTextField = new JTextField(20);
		categoryTextField = new JTextField(20);
		costTextField = new JTextField(20);
		lengthTextField = new JTextField(20);
		directorTextField = new JTextField(20);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titleTextField.getText();
				String category = categoryTextField.getText();
				float cost = Float.parseFloat(costTextField.getText());
				int length = Integer.parseInt(lengthTextField.getText());
				String director = directorTextField.getText();

				DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
				store.addMedia(dvd);
				setVisible(false);
				new StoreScreen(store, cart);

			}
		});

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6, 2));
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
		mainPanel.add(new JLabel());
		mainPanel.add(okButton);

		setTitle("Add DVD to Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setVisible(true);
	}
}
