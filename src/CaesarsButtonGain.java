import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.awt.event.*;

public abstract class CaesarsButtonGain implements ActionListener {

	private JButton[] buttons; // CALCULATE, CLEAR, CHECKOUT, EXIT

	private JLabel[] costTypes; // labels for the words "SUBTOTAL", "DELIVERY FEE", etc.
	private JLabel[] costs; // labels for the costs, subtotal, delivery etc.
	protected double[] totals; // 0-3: Size, Toppings, Bev. | 4-6: Subtotal, delivery, HST, Grand Total.

	protected boolean isCalculated; // boolean variable to tell if totals are calculated to the most recent change

	protected Color caesarsOrange; // colour as close as I could find to the official colour

	protected NumberFormat currency; // use for canadian currency

	protected ImageIcon icon; // the small icon used multiple times

	protected CaesarsButtonGain() {

		createComponents();

	} // end of constructor

	public void createComponents() { // method to create the components

		currency = NumberFormat.getCurrencyInstance(Locale.CANADA);

		buttons = new JButton[4];

		String[] buttonWords = { "CALCULATE", "CLEAR", "CHECKOUT", "EXIT" };

		costTypes = new JLabel[4];

		String[] costTypeWords = { "SUBTOTAL:", "DELIVERY FEE:", "HST:", "GRAND TOTAL:" };

		costs = new JLabel[4];

		totals = new double[7];

		icon = new ImageIcon("LittleCaesarsIcon.png");

		caesarsOrange = new Color(255, 103, 29);

		for (int b = 0; b < 4; b++) { // for loop to create components

			buttons[b] = new JButton(buttonWords[b]);
			buttons[b].setFont(new Font("Arial", Font.BOLD, 15));
			buttons[b].addActionListener(this);
			buttons[b].setBounds(410, 350 + (b * 40), 150, 30);
			buttons[b].setBackground(caesarsOrange);
			buttons[b].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

			costs[b] = new JLabel(currency.format(totals[b + 3]));
			costs[b].setFont(new Font("Times New Roman", Font.BOLD, 14));
			costs[b].setHorizontalAlignment(JLabel.CENTER);
			costs[b].setBounds(335, 350 + (b * 40), 70, 30);
			costs[b].setBackground(Color.white);
			costs[b].setOpaque(true);
			costs[b].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

			costTypes[b] = new JLabel(costTypeWords[b]);
			costTypes[b].setFont(new Font("Arial", Font.BOLD, 11));
			costTypes[b].setHorizontalAlignment(JLabel.CENTER);
			costTypes[b].setBounds(235, 350 + (b * 40), 95, 30);
			costTypes[b].setBackground(caesarsOrange);
			costTypes[b].setOpaque(true);
			costTypes[b].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		} // end of for

	} // end of createComponents

	public void addComponents(JPanel p) { // method to add components to the main panel

		for (int b = 0; b < 4; b++) {

			p.add(buttons[b]);

			p.add(costs[b]);

			p.add(costTypes[b]);

		} // end of for

	} // end of addComponents

	public void actionPerformed(ActionEvent a) {

		if (a.getSource() instanceof JButton) {

			if (a.getSource().equals(buttons[0])) // user presses calculate
				calculateButtonPressed();

			else if (a.getSource().equals(buttons[1])) // user presses clear
				clearButtonPressed();

			else if (a.getSource().equals(buttons[2])) // user presses checkout
				checkoutButtonPressed();

			else if (a.getSource().equals(buttons[3]))// user presses exit
				exitButtonPressed();

		}

	} // end of actionPerformed

	public void calculateButtonPressed() {

		totals[3] = (totals[0] + totals[1] + totals[2]); // calculate subtotal
		costs[0].setText(currency.format(totals[3])); // display the subtotal

		if (totals[3] >= 15.00) {// if user qualifies for free delivery

			costs[1].setText("FREE!"); // display free delivery
			costs[1].setBackground(caesarsOrange); // celebratory colour change

		}

		else {// else, the user does not qualify for free delivery

			totals[4] = 3.00; // set the delivery fee
			costs[1].setText(currency.format(totals[4])); // display delivery fee

		}

		totals[5] = 0.13 * totals[3]; // calculate HST
		costs[2].setText(currency.format(totals[5])); // display the HST

		totals[6] = (totals[3] + totals[4] + totals[5]); // calculate the grand total
		costs[3].setText(currency.format(totals[6])); // display the grand total

		isCalculated = true;

	} // end of calculateButton

	public void clearButtonPressed() {

		for (int i = 0; i < 7; i++) // set all the totals to 0
			totals[i] = 0;

		for (int j = 0; j < 4; j++) // clear all the texts from the boxes
			costs[j].setText(currency.format(totals[j + 3]));

		costs[1].setBackground(Color.white); // reset delivery fee background color

		isCalculated = false;

	} // end of clearButton

	public abstract void checkoutButtonPressed();// abstract checkoutButton

	public void exitButtonPressed() { // method for the exit button

		// confirm exit choice
		if (JOptionPane.showConfirmDialog(null,
				"Are you sure you wish to exit the\nLittle Caesar's Online Order System?",
				"Little Caesar's Online Order System", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				icon) == 0) {

			String[] goodbye = { "GOODBYE!" };

			// display message then exit
			JOptionPane.showOptionDialog(null,
					"Thank you for choosing Little Caesar's!\nWe hope to see you again soon!",
					"Little Caesar's Online Order System", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, icon,
					goodbye, goodbye[0]);
			System.exit(0);

		} // end of if

	} // end of exitButton

} // end of CaesarsButtonGain class
