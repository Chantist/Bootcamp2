package com.jits.kiosk;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jits.core.Address;
import com.jits.transfer.IConfirmation;

class KioskEntry implements ActionListener, ItemListener {
	private int textFieldLength = 15;

	// the frame itself
	private JFrame frame;

	// from Address
	private JLabel fromLabel = new JLabel("From");
	private JTextField fromName = new JTextField(textFieldLength);
	private JTextField fromStreet = new JTextField(textFieldLength);
	private JTextField fromCity = new JTextField(textFieldLength);
	private JTextField fromState = new JTextField(textFieldLength);
	private JTextField fromZip = new JTextField(textFieldLength);

	// to Address
	private JLabel toLabel = new JLabel("To");
	private JTextField toName = new JTextField(textFieldLength);
	private JTextField toStreet = new JTextField(textFieldLength);
	private JTextField toCity = new JTextField(textFieldLength);
	private JTextField toState = new JTextField(textFieldLength);
	private JTextField toZip = new JTextField(textFieldLength);

	// package info
	private JComboBox pkgType = new JComboBox(new String[] { "Box", "Letter" });
	private JComboBox ltrType = new JComboBox(new String[] { "Plain", "Fire-proof", "Weather-proof" });
	private JLabel boxDims = new JLabel("Box dimensions");
	private JTextField height = new JTextField(5);
	private JTextField width = new JTextField(5);
	private JTextField depth = new JTextField(5);
	private JCheckBox insurance = new JCheckBox("Insured");
	private JComboBox deliveryType = new JComboBox(new String[] { "Air", "Ground", "Rail" });

	private JPanel heightPanel;
	private JPanel widthPanel;
	private JPanel depthPanel;

	// button
	private JButton nextButton = new JButton("Submit");

	KioskEntry() {
		this.setUpUI();
	}

	public void actionPerformed(ActionEvent evt) {
		Object widget = evt.getSource();
		if (widget == nextButton) {
			Map request = this.buildRequest();
			System.out.println(request);

			// call the request handler, pass in the request map, get
			// confirmation back
			KioskRequestHandler handler = new KioskRequestHandler();
			IConfirmation conf = handler.handleRequest(request);

			// display confirmation ("pending"), get user decision
			int option = JOptionPane.showConfirmDialog(null, conf, "Confirm Delivery", JOptionPane.YES_NO_OPTION);

			// send "go"/"no-go" decision to request handler, get confirmation
			// back
			conf = handler.handleUserDecision((option == JOptionPane.YES_OPTION) ? true : false);
			JOptionPane.showMessageDialog(null, conf, "Results", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private Map<String, Object> buildRequest() {
		// create delivery request from UI
		Map<String, Object> request = new HashMap<String, Object>();

		// store address data as Address value objects
		Address origin = new Address(fromName.getText(), fromStreet.getText(), fromCity.getText(), fromState.getText(),
				fromZip.getText());
		request.put("origin", origin);

		Address destination = new Address(toName.getText(), toStreet.getText(), toCity.getText(), toState.getText(),
				toZip.getText());
		request.put("dest", destination);

		// store package-delivery type (LG|LA|BG|BA)
		String packageCode = ((String) pkgType.getSelectedItem()).substring(0, 1);
		String deliveryCode = ((String) deliveryType.getSelectedItem()).substring(0, 1);
		request.put("type", packageCode + deliveryCode);

		// generate and store an ID
		request.put("id", String.valueOf(System.currentTimeMillis()));

		// store box data if applicable
		if (packageCode.equals("B")) {
			request.put("height", height.getText());
			request.put("width", width.getText());
			request.put("depth", depth.getText());
			request.put("insured", String.valueOf(insurance.isSelected()));
		}
		// store letter data if applicable
		else if (packageCode.equals("L")) {
			String letterTypeUI = (String) ltrType.getSelectedItem();
			String letterType = "plain";
			if (letterTypeUI.equals("Fire-proof")) {
				letterType = "fire";
			} else if (letterTypeUI.equals("Weather-proof")) {
				letterType = "weather";
			}
			request.put("lType", letterType);
		}
		return request;
	}

	// toggles visibility of box-specific and letter-specific data entry
	// components
	public void itemStateChanged(ItemEvent evt) {
		Object widget = evt.getSource();
		if (widget == pkgType) {
			String selectedValue = (String) pkgType.getSelectedItem();

			boolean letterMode = selectedValue.equals("Letter");
			ltrType.setVisible(letterMode);
			heightPanel.setVisible(!letterMode);
			widthPanel.setVisible(!letterMode);
			depthPanel.setVisible(!letterMode);
			boxDims.setVisible(!letterMode);
			insurance.setVisible(!letterMode);
		}
	}

	private void setUpUI() {
		// frame and main panels
		frame = new JFrame("JITS Kiosk");
		frame.getContentPane().setLayout(new GridLayout(2, 2));

		// from address panel
		JPanel fromPanel = new JPanel();
		fromPanel.setLayout(new GridLayout(6, 1));

		fromPanel.add(fromLabel);

		JPanel fromNamePanel = new JPanel();
		fromNamePanel.add(new JLabel("Name"));
		fromNamePanel.add(fromName);
		fromPanel.add(fromNamePanel);

		JPanel fromStreetPanel = new JPanel();
		fromStreetPanel.add(new JLabel("Street"));
		fromStreetPanel.add(fromStreet);
		fromPanel.add(fromStreetPanel);

		JPanel fromCityPanel = new JPanel();
		fromCityPanel.add(new JLabel("City"));
		fromCityPanel.add(fromCity);
		fromPanel.add(fromCityPanel);

		JPanel fromStatePanel = new JPanel();
		fromStatePanel.add(new JLabel("State"));
		fromStatePanel.add(fromState);
		fromPanel.add(fromStatePanel);

		JPanel fromZipPanel = new JPanel();
		fromZipPanel.add(new JLabel("ZIP"));
		fromZipPanel.add(fromZip);
		fromPanel.add(fromZipPanel);

		// to address panel
		JPanel toPanel = new JPanel();
		toPanel.setLayout(new GridLayout(6, 1));

		toPanel.add(toLabel);

		JPanel toNamePanel = new JPanel();
		toNamePanel.add(new JLabel("Name"));
		toNamePanel.add(toName);
		toPanel.add(toNamePanel);

		JPanel toStreetPanel = new JPanel();
		toStreetPanel.add(new JLabel("Street"));
		toStreetPanel.add(toStreet);
		toPanel.add(toStreetPanel);

		JPanel toCityPanel = new JPanel();
		toCityPanel.add(new JLabel("City"));
		toCityPanel.add(toCity);
		toPanel.add(toCityPanel);

		JPanel toStatePanel = new JPanel();
		toStatePanel.add(new JLabel("State"));
		toStatePanel.add(toState);
		toPanel.add(toStatePanel);

		JPanel toZipPanel = new JPanel();
		toZipPanel.add(new JLabel("ZIP"));
		toZipPanel.add(toZip);
		toPanel.add(toZipPanel);

		// package panel
		JPanel packagePanel = new JPanel();
		packagePanel.setLayout(new GridLayout(8, 1));

		ltrType.setVisible(false);
		packagePanel.add(pkgType);
		packagePanel.add(ltrType);

		packagePanel.add(boxDims);

		heightPanel = new JPanel();
		heightPanel.add(new JLabel("Height"));
		heightPanel.add(height);
		packagePanel.add(heightPanel);

		widthPanel = new JPanel();
		widthPanel.add(new JLabel("Width"));
		widthPanel.add(width);
		packagePanel.add(widthPanel);

		depthPanel = new JPanel();
		depthPanel.add(new JLabel("Depth"));
		depthPanel.add(depth);
		packagePanel.add(depthPanel);

		packagePanel.add(insurance);

		packagePanel.add(deliveryType);

		// add major components to frame
		frame.getContentPane().add(fromPanel);
		frame.getContentPane().add(toPanel);
		frame.getContentPane().add(packagePanel);

		nextButton.setFont(new Font("Arial", Font.BOLD, 60));
		frame.getContentPane().add(nextButton);

		// add event listeners
		// submit button
		nextButton.addActionListener(this);

		// package type selector
		pkgType.addItemListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.show();
	}

	public static void main(String[] args) {
		new KioskEntry();
	}
}