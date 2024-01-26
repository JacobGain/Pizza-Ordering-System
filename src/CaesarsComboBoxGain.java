import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public abstract class CaesarsComboBoxGain extends CaesarsButtonGain implements ActionListener {

	private JPanel comboBoxPanel; // panel to house the combo boxes

	private JComboBox<Integer> cmbCoke, cmbPepsi, cmbSprite, cmbFanta, cmbWater; // combo boxes, array didn't work

	private JLabel lblBevCost; // label to display the cost of selected drinks

	private double[] costEachDrink; // array to hold the individual drink prices

	protected CaesarsComboBoxGain() {

		super();

		createComponents();

	} // end of constructor

	public void createComponents() { // overridden method to create new components, use super method

		super.createComponents();

		comboBoxPanel = new JPanel();

		Integer[] numOfBevs = { 0, 1, 2, 3, 4, 5, 6 };

		cmbCoke = new JComboBox<>(numOfBevs);
		cmbCoke.setBackground(Color.white);

		cmbPepsi = new JComboBox<>(numOfBevs);
		cmbPepsi.setBackground(Color.white);

		cmbSprite = new JComboBox<>(numOfBevs);
		cmbSprite.setBackground(Color.white);

		cmbFanta = new JComboBox<>(numOfBevs);
		cmbFanta.setBackground(Color.white);

		cmbWater = new JComboBox<>(numOfBevs);
		cmbWater.setBackground(Color.white);

		lblBevCost = new JLabel("Cost of Beverages: " + currency.format(totals[2]));

		// labels to show name of each beverage
		JLabel[] bevs = new JLabel[5];

		// array for each beverage name and price display
		String[] bevNames = { "Coke ($1.50)", "Pepsi ($1.50)", "Sprite ($1.25)", "Fanta ($1.25)", "Water ($1.00)" };

		for (int h = 0; h < 5; h++) { // create the labels which show beverage names

			// Tried this in the createComponents method, it caused a NullPointerException
			bevs[h] = new JLabel(bevNames[h]);
			bevs[h].setFont(new Font("Arial", Font.BOLD, 11));
			bevs[h].setHorizontalAlignment(JLabel.LEFT);
			comboBoxPanel.add(bevs[h]);
			bevs[h].setBounds(5, 16 + (h * 25), 100, 25);

			costEachDrink = new double[5];

		} // end of for to create labels

	} // end of createComponents

	public void addComponents(JPanel p) { // overridden method to add new components, use super method

		super.addComponents(p);

		comboBoxPanel.add(cmbCoke);
		cmbCoke.setBounds(80, 19, 50, 20);
		cmbCoke.addActionListener(this);

		comboBoxPanel.add(cmbPepsi);
		cmbPepsi.setBounds(80, 44, 50, 20);
		cmbPepsi.addActionListener(this);

		comboBoxPanel.add(cmbSprite);
		cmbSprite.setBounds(80, 69, 50, 20);
		cmbSprite.addActionListener(this);

		comboBoxPanel.add(cmbFanta);
		cmbFanta.setBounds(80, 94, 50, 20);
		cmbFanta.addActionListener(this);

		comboBoxPanel.add(cmbWater);
		cmbWater.setBounds(80, 119, 50, 20);
		cmbWater.addActionListener(this);

		comboBoxPanel.setLayout(null);
		comboBoxPanel.setBackground(caesarsOrange);
		comboBoxPanel.setBorder(BorderFactory.createTitledBorder("Add Beverages"));
		comboBoxPanel.setBounds(425, 145, 150, 148);

		p.add(comboBoxPanel);

		p.add(lblBevCost);
		lblBevCost.setBounds(425, 305, 150, 25);
		lblBevCost.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBevCost.setHorizontalAlignment(JLabel.CENTER);
		lblBevCost.setOpaque(true);
		lblBevCost.setBackground(Color.white);
		lblBevCost.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

	} // end of addComponents method

	public void actionPerformed(ActionEvent a) { // override actionPerformed to add the combo box, use super method

		super.actionPerformed(a);

		if (a.getSource() instanceof JComboBox) {

			isCalculated = false;

			if (a.getSource().equals(cmbCoke)) // if Coke combo box is assigned a value
				cokeComboBox();

			else if (a.getSource().equals(cmbPepsi)) // if Pepsi combo box is assigned a value
				pepsiComboBox();

			else if (a.getSource().equals(cmbSprite)) // if Sprite combo box is assigned a value
				spriteComboBox();

			else if (a.getSource().equals(cmbFanta)) // if Fanta combo box is assigned a value
				fantaComboBox();

			else // if water combo box is assigned a value
				waterComboBox();
		}

		// calculate the total drink cost
		totals[2] = costEachDrink[0] + costEachDrink[1] + costEachDrink[2] + costEachDrink[3] + costEachDrink[4];

		lblBevCost.setText("Cost of Beverages: " + currency.format(totals[2]));

	} // end of actionPerformed

	public void clearButtonPressed() { // overridden method to also clear the combo boxes, use super method

		super.clearButtonPressed();

		cmbCoke.setSelectedIndex(0);

		cmbPepsi.setSelectedIndex(0);

		cmbSprite.setSelectedIndex(0);

		cmbFanta.setSelectedIndex(0);

		cmbWater.setSelectedIndex(0);

	} // end of clearButtonPressed

	public void cokeComboBox() { // performs actions for the coke combo box

		costEachDrink[0] = (cmbCoke.getSelectedIndex() * 1.50);

	} // end of cokeComboBox

	public void pepsiComboBox() { // performs actions for the coke combo box

		costEachDrink[1] = (cmbPepsi.getSelectedIndex() * 1.50);

	} // end of pepsiComboBox

	public void spriteComboBox() { // performs actions for the sprite combo box

		costEachDrink[2] = (cmbSprite.getSelectedIndex() * 1.25);

	} // end of spriteComboBox

	public void fantaComboBox() { // performs actions for the fanta combo box

		costEachDrink[3] = (cmbFanta.getSelectedIndex() * 1.25);

	} // end of fantaComboBox

	protected void waterComboBox() { // performs actions for the water combo box

		costEachDrink[4] = (cmbWater.getSelectedIndex() * 1.00);

	} // end of waterComboBox

} // end of CaesarsComboBoxGain class
