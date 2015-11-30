package jits.core.shipping;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Test;

public class Chalkboard {

	@Test
	public void test() {

		JTextField name = new JTextField(10);
		JTextField address = new JTextField(10);
		JTextField city = new JTextField(10);
		JTextField zip = new JTextField(10);
		JTextField state = new JTextField(10);

		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Name:"));
		myPanel.add(name);
		myPanel.add(new JLabel("Address:"));
		myPanel.add(address);
		myPanel.add(new JLabel("City:"));
		myPanel.add(city);
		myPanel.add(new JLabel("State:"));
		myPanel.add(state);
		myPanel.add(new JLabel("Zip:"));
		myPanel.add(zip);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter X and Y Values",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			System.out.println(name.getText() + " | " + address.getText() + " | " + city.getText() + " | " + zip.getText());
		}
	}
}
