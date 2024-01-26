import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public abstract class CaesarsCheckBoxesGain extends CaesarsComboBoxGain implements ActionListener {

	private JPanel checkBoxPanel; // panel to house to check boxes

	private JCheckBox[] toppings; // each topping check box

	private JLabel lblFreeToppings, lblToppingsCost; // labels that display the free toppings message, and the cost

	private double numOfToppings; // counter for number of selected toppings so the first 3 are free

	protected CaesarsCheckBoxesGain() {

		super();

		createComponents();

	} // end of constructor

	public void createComponents() { // overridden method to create new components, use super method

		super.createComponents();

		checkBoxPanel = new JPanel(); // create panel

		toppings = new JCheckBox[8]; // create the array of check boxes

		String[] toppingNames = { "Pepperoni", "Bacon", "Mushrooms", "Green Peppers", "Ham", "Onions", "Hot Peppers",
				"Extra Cheese" }; // toppings of each check box

		for (int r = 0; r < 8; r++) { // create the checkboxes using the names

			toppings[r] = new JCheckBox(toppingNames[r]); // create the checkbox with matching name
			toppings[r].setBackground(caesarsOrange);
			toppings[r].addActionListener(this);
			checkBoxPanel.add(toppings[r]); // and the checkBoxes to the panel

		} // end of for

		// create and fill labels
		lblFreeToppings = new JLabel("Your first THREE (3) toppings are FREE!");

		lblToppingsCost = new JLabel("Cost of Toppings: " + currency.format(totals[1]));

	} // end of createComponents

	public void addComponents(JPanel p) { // overridden method to add new components, use super method

		super.addComponents(p);

		GridLayout grid = new GridLayout(4, 2); // make a grid layout

		checkBoxPanel.setLayout(grid);
		checkBoxPanel.setBackground(caesarsOrange);
		checkBoxPanel.setBorder(BorderFactory.createTitledBorder("Choose Your Toppings"));
		checkBoxPanel.setBounds(150, 145, 250, 130);

		p.add(checkBoxPanel);

		p.add(lblToppingsCost);
		lblToppingsCost.setBounds(200, 305, 150, 25);
		lblToppingsCost.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblToppingsCost.setHorizontalAlignment(JLabel.CENTER);
		lblToppingsCost.setOpaque(true);
		lblToppingsCost.setBackground(Color.white);
		lblToppingsCost.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		p.add(lblFreeToppings);
		lblFreeToppings.setBounds(150, 278, 250, 25);
		lblFreeToppings.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 12));
		lblFreeToppings.setHorizontalAlignment(JLabel.CENTER);

	}

	public void actionPerformed(ActionEvent a) {

		super.actionPerformed(a);

		if (a.getSource() instanceof JCheckBox) {

			checkBoxes(a);

			if (numOfToppings > 3) {// each extra topping costs $1.00

				totals[1] = numOfToppings - 3;

			} // end of if

			else { // free toppings!

				totals[1] = 0;

			} // end of else

			isCalculated = false;

		} // end of outer if

		lblToppingsCost.setText("Cost of Toppings: " + currency.format(totals[1])); // display the cost of toppings

	} // end of actionPerformed method

	public void clearButtonPressed() { // overridden method to also clear the checkboxes, use super method

		super.clearButtonPressed();

		for (int i = 0; i < 8; i++) {

			toppings[i].setSelected(false); // unselect each check box

		} // end of for

		numOfToppings = 0; // reset num of toppings to zero

	} // end of clearButtonPressed

	public void checkBoxes(ActionEvent a) { // method to perform the checks and actions of each check box

		for (int i = 0; i < 8; i++) { // for loop to check the checkboxes

			if (a.getSource().equals(toppings[i])) {

				if (toppings[i].isSelected())
					numOfToppings++; // increase if checked

				else
					numOfToppings--; // decrease if unchecked

			} // end of outer if

		} // end of for

	} // end of checkBoxes

} // end of CaesarsCheckBoxesGain
