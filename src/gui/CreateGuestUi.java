package gui;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ctrl.BookingCtrl;
import javafx.scene.input.KeyCode;
import model.Booking;
import model.Guest;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class CreateGuestUi extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4433344709435466535L;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPhoneNo;
	private JTextField txtCountry;
	private JTextField txtCity;
	private JTextField txtPostalCode;
	private BookingCtrl bCtrl;

	public CreateGuestUi(Booking bReturn) {
		bCtrl = new BookingCtrl();

		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 216, 216, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 29, 29, 28, 29, 29, 20, 29, 28, 29, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Create Guest");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);

		txtName = new JTextField();
		txtName.setName("txtName");
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.BOTH;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_6 = new GridBagConstraints();
		gbc_checkBox_6.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_6.gridx = 2;
		gbc_checkBox_6.gridy = 1;
		add(checkBox_6, gbc_checkBox_6);

		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.BOTH;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 2;
		add(lblLastName, gbc_lblLastName);

		txtLastName = new JTextField();
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.fill = GridBagConstraints.BOTH;
		gbc_txtLastName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastName.gridx = 1;
		gbc_txtLastName.gridy = 2;
		add(txtLastName, gbc_txtLastName);
		txtLastName.setColumns(10);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_5 = new GridBagConstraints();
		gbc_checkBox_5.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_5.gridx = 2;
		gbc_checkBox_5.gridy = 2;
		add(checkBox_5, gbc_checkBox_5);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 3;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_3.gridx = 2;
		gbc_checkBox_3.gridy = 3;
		add(checkBox_3, gbc_checkBox_3);

		JLabel lblPhoneNo = new JLabel("PhoneNo");
		GridBagConstraints gbc_lblPhoneNo = new GridBagConstraints();
		gbc_lblPhoneNo.fill = GridBagConstraints.BOTH;
		gbc_lblPhoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNo.gridx = 0;
		gbc_lblPhoneNo.gridy = 4;
		add(lblPhoneNo, gbc_lblPhoneNo);

		txtPhoneNo = new JTextField();
		GridBagConstraints gbc_txtPhoneNo = new GridBagConstraints();
		gbc_txtPhoneNo.fill = GridBagConstraints.BOTH;
		gbc_txtPhoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhoneNo.gridx = 1;
		gbc_txtPhoneNo.gridy = 4;
		add(txtPhoneNo, gbc_txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_2.gridx = 2;
		gbc_checkBox_2.gridy = 4;
		add(checkBox_2, gbc_checkBox_2);

		JLabel lblCountry = new JLabel("Country");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.fill = GridBagConstraints.BOTH;
		gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountry.gridx = 0;
		gbc_lblCountry.gridy = 5;
		add(lblCountry, gbc_lblCountry);

		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		GridBagConstraints gbc_txtCountry = new GridBagConstraints();
		gbc_txtCountry.fill = GridBagConstraints.BOTH;
		gbc_txtCountry.insets = new Insets(0, 0, 5, 5);
		gbc_txtCountry.gridx = 1;
		gbc_txtCountry.gridy = 5;
		add(txtCountry, gbc_txtCountry);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_1.gridx = 2;
		gbc_checkBox_1.gridy = 5;
		add(checkBox_1, gbc_checkBox_1);

		JLabel lblCity = new JLabel("City");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.fill = GridBagConstraints.BOTH;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 6;
		add(lblCity, gbc_lblCity);

		txtCity = new JTextField();
		txtCity.setColumns(10);
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.fill = GridBagConstraints.BOTH;
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.gridx = 1;
		gbc_txtCity.gridy = 6;
		add(txtCity, gbc_txtCity);

		JButton btnNext = new JButton("Next ->");
		btnNext.addActionListener(e -> {
			clickNext();
		});

		JButton btn = new JButton("Cancel");
		btn.addActionListener(e -> {

		});

		JCheckBox checkBox_4 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_4 = new GridBagConstraints();
		gbc_checkBox_4.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_4.gridx = 2;
		gbc_checkBox_4.gridy = 6;
		add(checkBox_4, gbc_checkBox_4);

		JLabel lblPostalCode = new JLabel("PostalCode");
		GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
		gbc_lblPostalCode.fill = GridBagConstraints.BOTH;
		gbc_lblPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode.gridx = 0;
		gbc_lblPostalCode.gridy = 7;
		add(lblPostalCode, gbc_lblPostalCode);

		txtPostalCode = new JTextField();
		GridBagConstraints gbc_txtPostalCode = new GridBagConstraints();
		gbc_txtPostalCode.fill = GridBagConstraints.BOTH;
		gbc_txtPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtPostalCode.gridx = 1;
		gbc_txtPostalCode.gridy = 7;
		add(txtPostalCode, gbc_txtPostalCode);
		txtPostalCode.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox.gridx = 2;
		gbc_checkBox.gridy = 7;
		add(checkBox, gbc_checkBox);
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.fill = GridBagConstraints.BOTH;
		gbc_btn.insets = new Insets(0, 0, 0, 5);
		gbc_btn.gridx = 0;
		gbc_btn.gridy = 8;
		add(btn, gbc_btn);
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.fill = GridBagConstraints.BOTH;
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 8;
		add(btnNext, gbc_btnNext);

		if (bReturn != null) {
			fillTextFileds(bReturn);
		}
	
		testVerifie();
		
	}

	//  	bCtrl.checkGuestValues(txtName.getText(), txtLastName.getText(), txtEmail.getText(),
	//		txtPhoneNo.getText(),txtCity.getText(), txtCountry.getText(), txtPostalCode.getText());
	  
	private void clickNext() {
		Booking b = bCtrl.createBooking();
		Guest g = bCtrl.createGuest(txtName.getText(), txtLastName.getText(), txtEmail.getText(), txtPhoneNo.getText(),
				txtCity.getText(), txtCountry.getText(), txtPostalCode.getText());
		b.setG(g);
		this.removeAll();
		this.add(new ChooseRoom(b));
		this.revalidate();
		this.repaint();

	}

	private void fillTextFileds(Booking b) {
		Guest g = b.getG();
		txtName.setText(g.getName());
		txtLastName.setText(g.getLastname());
		txtEmail.setText(g.getEmail());
		txtPhoneNo.setText(g.getPhoneNo());
		txtCity.setText(g.getGuestOrigin().getCity());
		txtCountry.setText(g.getGuestOrigin().getCountry());
		txtPostalCode.setText(g.getGuestOrigin().getPostalCode());
	}

	private void testVerifie(){
		txtName.setInputVerifier(new InputVerifier(){

			@Override
			public boolean verify(JComponent input) {
				// TODO Auto-generated method stub
				String name = input.getName();
				if(name.equals("txtName")){
					
					return true;
				}
				else {
				System.out.println("false");
				return false;
				}
			}
			
		});
	}


}
