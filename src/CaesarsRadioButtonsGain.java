import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.event.*;
import java.awt.*;

public class CaesarsRadioButtonsGain extends CaesarsCheckBoxesGain implements ActionListener {

	private JPanel radioButtonPanel; // panel to house radio buttons

	private JRadioButton[] sizes; // each size radio button
	private JButton[] paymentTypes; // buttons for the use to select a payment method
	private ButtonGroup bg; // button group to connect radio buttons

	private boolean sizeSelected, paymentSelected; // makes sure user has a size and payment method selected

	private JLabel lblSizeCost, lblPaymentSelect; // label to display cost of selected size

	public CaesarsRadioButtonsGain() {

		super();

		createComponents();

	} // end of constructor

	public void createComponents() { // overridden method to create new components, use super method

		super.createComponents();

		radioButtonPanel = new JPanel();

		sizes = new JRadioButton[5]; // initialize radio button array
		paymentTypes = new JButton[4]; // initialize button array

		lblSizeCost = new JLabel("Cost of Selected Size: " + currency.format(totals[0]));

		lblPaymentSelect = new JLabel("Select Method of Payment");

		bg = new ButtonGroup();

		String[] pizzaSizes = { "Small", "Medium", "Large", "Party", "Panzerotti" }; // each pizza size & style
		String[] paymentNames = { "CASH AT DOOR", "INTERAC", "MASTERCARD", "VISA" }; // payment methods

		for (int t = 0; t < 5; t++) { // create each radio button

			sizes[t] = new JRadioButton(pizzaSizes[t]);
			sizes[t].setBackground(caesarsOrange);
			sizes[t].addActionListener(this);
			bg.add(sizes[t]); // add the radio buttons to button group
			radioButtonPanel.add(sizes[t]); // add each radio button to the panel

		} // end of for

		for (int q = 0; q < 4; q++) { // create the buttons which select the payment type

			paymentTypes[q] = new JButton(paymentNames[q]);

		} // end of for

	} // end of createComponents

	public void addComponents(JPanel p) { // overridden method to add new components, use super method

		super.addComponents(p);

		GridLayout column = new GridLayout(5, 1); // make the grid layout of a column (4x1)

		radioButtonPanel.setLayout(column);
		radioButtonPanel.setBackground(caesarsOrange);
		radioButtonPanel.setBorder(BorderFactory.createTitledBorder("Select A Size"));
		radioButtonPanel.setBounds(15, 145, 120, 148);

		p.add(radioButtonPanel); // add rb panel to main panel

		for (int q = 0; q < 4; q++) { // adds and sets each payment type button

			p.add(paymentTypes[q]);
			paymentTypes[q].setBackground(caesarsOrange);
			paymentTypes[q].setFont(new Font("Arial", Font.BOLD, 11));
			paymentTypes[q].addActionListener(this);
			paymentTypes[q].setBounds(100, 390 + (q * 44), 100, 32);
			paymentTypes[q].setBackground(Color.white);
			paymentTypes[q].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		} // end of for

		p.add(lblSizeCost); // add and set the label that displays cost of selected size
		lblSizeCost.setBounds(7, 305, 153, 25);
		lblSizeCost.setOpaque(true);
		lblSizeCost.setBackground(Color.white);
		lblSizeCost.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSizeCost.setHorizontalAlignment(JLabel.CENTER);
		lblSizeCost.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		p.add(lblPaymentSelect); // add and set label that says to choose a payment method
		lblPaymentSelect.setBounds(15, 350, 185, 30);
		lblPaymentSelect.setOpaque(true);
		lblPaymentSelect.setFont(new Font("Arial", Font.BOLD, 13));
		lblPaymentSelect.setBackground(caesarsOrange);
		lblPaymentSelect.setHorizontalAlignment(JLabel.CENTER);
		lblPaymentSelect.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

	} // end of addComponents

	public void actionPerformed(ActionEvent a) {

		super.actionPerformed(a);

		if (a.getSource() instanceof JRadioButton) { // if a radio button is pressed

			radioButtonPressed(a);

		} // end of if
		if (a.getSource() instanceof JButton) { // payment type buttons

			for (int i = 0; i < 4; i++) { // check each payment type button

				if (a.getSource().equals(paymentTypes[i])) { // check the source

					for (int b = 0; b < 4; b++) // for loop to reset all buttons to white when one is pressed
						paymentTypes[b].setBackground(Color.white); // perform as stated above

					paymentTypes[i].setBackground(caesarsOrange); // change the background to show selected payment
					paymentSelected = true; // payment type is selected

				} // end of if

			} // end of for

		} // end of outer if

		lblSizeCost.setText("Cost of Selected Size: " + currency.format(totals[0])); // display cost of selected size

	} // end of actionPerformed

	public void radioButtonPressed(ActionEvent a) { // method to perform checks for radio buttons

		sizeSelected = true;

		double[] sizeCosts = { 7.99, 8.99, 9.99, 10.99, 6.99 };

		for (int i = 0; i < 5; i++) {

			if (a.getSource().equals(sizes[i])) {

				isCalculated = false;
				totals[0] = sizeCosts[i];

			}

		}

	} // end of radioButtonPressed

	public void clearButtonPressed() { // overridden method to also clear new button group, use super method

		super.clearButtonPressed();

		bg.clearSelection(); // clear the button group selection

		// reset size, payment, and calculated variables
		sizeSelected = false;
		paymentSelected = false;
		isCalculated = false;

		for (int i = 0; i < 4; i++)
			paymentTypes[i].setBackground(Color.white);

	} // end of clearButtonPressed

	public void checkoutButtonPressed() { // implement abstract method to check out

		if (sizeSelected && paymentSelected && isCalculated) { // user selected size, payment, AND calculated

			// confirm order
			if (JOptionPane.showConfirmDialog(null,
					"Your order total is: " + currency.format(totals[6]) + "\nWould you like to place your order?",
					"Order Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon) == 0) {

				String[] option = { "YUM!" };

				// if order is correct, display thank you then exit
				JOptionPane.showOptionDialog(null,
						"Thank you for ordering Little Caesar's!\nYour pizza will be delivered in 30 minutes,\nor it's FREE!",
						"Thank You!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, option, option[0]);
				System.exit(0);

			} // end of inner if

		} // end of outer if

		else { // user has not selected a size, payment, AND calculated

			if (!sizeSelected) // check size first
				JOptionPane.showMessageDialog(null, "Your order could not be completed!\nPlease select a Pizza Size!",
						"Critical Error!", JOptionPane.ERROR_MESSAGE);

			else if (!paymentSelected) // check payment
				JOptionPane.showMessageDialog(null,
						"Your order could not be completed!\nPlease select a Payment Method!", "Critical Error!",
						JOptionPane.ERROR_MESSAGE);

			else // check calculated
				JOptionPane.showMessageDialog(null,
						"Your order could not be completed!\nPlease Calculate your order total!", "Critical Error!",
						JOptionPane.ERROR_MESSAGE);

		} // end of else

	} // end of checkoutButton method

} // end of CaesarsRadioButtonGain
