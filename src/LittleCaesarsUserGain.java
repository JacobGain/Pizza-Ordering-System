import java.awt.Color;
import javax.swing.*;

public class LittleCaesarsUserGain {

	public static void main(String[] args) {

		String[] options = { "ENTER", "EXIT" }; // options for initial screen

		String[] options2 = { "GOODBYE!" }; // options for end screen

		ImageIcon[] images = { new ImageIcon("LittleCaesarsIcon.png"),
				new ImageIcon("LittleCaesarsLogo.png"),
				new ImageIcon("PaymentOptions.png") }; // images

		// ask if user wants to enter the online order system
		if (JOptionPane.showOptionDialog(null, "Welcome to the Little Caesar's\nOnline Order System!",
				"Little Caesar's Online Order System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, images[0],
				options, options[0]) == 0) {

			JFrame frame = new JFrame("Little Caesar's Online Order System");

			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.LIGHT_GRAY);

			JLabel lblTopImg = new JLabel();
			JLabel lblPayImg = new JLabel();

			lblTopImg.setIcon(images[1]);
			lblTopImg.setBounds(44, 25, 512, 100);

			lblPayImg.setIcon(images[2]);
			lblPayImg.setBounds(15, 390, 100, 162);

			panel.add(lblTopImg);
			panel.add(lblPayImg);

			CaesarsButtonGain lsg = new CaesarsRadioButtonsGain();
			lsg.addComponents(panel);

			frame.setContentPane(panel);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setBounds(350, 50, 600, 600);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		} // end of if
		else { // user selects exit

			// display message then exit
			JOptionPane.showOptionDialog(null,
					"Thank you for choosing Little Caesar's!\nWe hope to see you again soon!",
					"Little Caesar's Online Order System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					images[0], options2, options2[0]);

		} // end of else

	} // end of main method

	public LittleCaesarsUserGain() {

		String[] options = { "ENTER", "EXIT" }; // options for initial screen

		String[] options2 = { "GOODBYE!" }; // options for end screen

		ImageIcon[] images = { new ImageIcon("LittleCaesarsIcon.png"),
				new ImageIcon("LittleCaesarsLogo.png"),
				new ImageIcon("PaymentOptions.png") }; // images

		// ask if user wants to enter the online order system
		if (JOptionPane.showOptionDialog(null, "Welcome to the Little Caesar's\nOnline Order System!",
				"Little Caesar's Online Order System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, images[0],
				options, options[0]) == 0) {

			JFrame frame = new JFrame("Little Caesar's Online Order System");

			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.LIGHT_GRAY);

			JLabel lblTopImg = new JLabel();
			JLabel lblPayImg = new JLabel();

			lblTopImg.setIcon(images[1]);
			lblTopImg.setBounds(44, 25, 512, 100);

			lblPayImg.setIcon(images[2]);
			lblPayImg.setBounds(15, 390, 100, 162);

			panel.add(lblTopImg);
			panel.add(lblPayImg);

			CaesarsButtonGain lsg = new CaesarsRadioButtonsGain();
			lsg.addComponents(panel);

			frame.setContentPane(panel);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setBounds(350, 50, 600, 600);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		} // end of if
		else { // user selects exit

			// display message then exit
			JOptionPane.showOptionDialog(null,
					"Thank you for choosing Little Caesar's!\nWe hope to see you again soon!",
					"Little Caesar's Online Order System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					images[0], options2, options2[0]);

		} // end of else

	} // end of constructor

} // end of LittleCaesarsUserGain
