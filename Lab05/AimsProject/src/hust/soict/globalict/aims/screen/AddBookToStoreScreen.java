package hust.soict.globalict.aims.screen;

import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends JFrame {
	private JLabel titleLabel, categoryLabel, costLabel;
	private JTextField titleTextField, categoryTextField, costTextField;
	private JButton okButton;
	private Store store;
	private Cart cart;

	public AddBookToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		titleLabel = new JLabel("Title:");
		categoryLabel = new JLabel("Category:");
		costLabel = new JLabel("Cost:");

		titleTextField = new JTextField(20);
		categoryTextField = new JTextField(20);
		costTextField = new JTextField(20);

		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titleTextField.getText();
				String category = categoryTextField.getText();
				float cost = Float.parseFloat(costTextField.getText());

				Book book = new Book(title, category, cost);
				store.addMedia(book);
				setVisible(false);
				new StoreScreen(store, cart);
			}
		});

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(4, 2));
		mainPanel.add(titleLabel);
		mainPanel.add(titleTextField);
		mainPanel.add(categoryLabel);
		mainPanel.add(categoryTextField);
		mainPanel.add(costLabel);
		mainPanel.add(costTextField);
		mainPanel.add(new JLabel()); // Empty label for spacing
		mainPanel.add(okButton);

		setTitle("Add Book to Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setVisible(true);
	}
}
