package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import CTRL.CustomerCtrl;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateCustomerDialog extends JDialog
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1977098798141788247L;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtDiscount;
	private NumberFormat nf = new CommaFixNumberFormat();
	private CustomerCtrl cCtrl = new CustomerCtrl();

	public CreateCustomerDialog()
	{

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Create Customer");
		setModal(true);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]
		{ 50, 0, 0, 85, 160, 50, 0 };
		gbl_contentPane.rowHeights = new int[]
		{ 30, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0 };
		gbl_contentPane.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gbl_contentPane);

		JLabel lblCreateCustomer = new JLabel("Create Customer");
		lblCreateCustomer.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCreateCustomer = new GridBagConstraints();
		gbc_lblCreateCustomer.fill = GridBagConstraints.VERTICAL;
		gbc_lblCreateCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_lblCreateCustomer.gridwidth = 6;
		gbc_lblCreateCustomer.gridx = 0;
		gbc_lblCreateCustomer.gridy = 1;
		getContentPane().add(lblCreateCustomer, gbc_lblCreateCustomer);

		JLabel lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.VERTICAL;
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		getContentPane().add(lblName, gbc_lblName);

		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.BOTH;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.gridwidth = 3;
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 3;
		getContentPane().add(txtName, gbc_txtName);
		txtName.setColumns(10);

		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 4;
		getContentPane().add(lblAddress, gbc_lblAddress);

		txtAddress = new JTextField();
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.fill = GridBagConstraints.BOTH;
		gbc_txtAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress.gridwidth = 3;
		gbc_txtAddress.gridx = 2;
		gbc_txtAddress.gridy = 4;
		getContentPane().add(txtAddress, gbc_txtAddress);
		txtAddress.setColumns(10);

		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 5;
		getContentPane().add(lblPhone, gbc_lblPhone);

		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.BOTH;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone.gridwidth = 3;
		gbc_txtPhone.gridx = 2;
		gbc_txtPhone.gridy = 5;
		getContentPane().add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.fill = GridBagConstraints.VERTICAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		getContentPane().add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 6;
		getContentPane().add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblDiscount = new JLabel("Discount: ");
		lblDiscount.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.anchor = GridBagConstraints.WEST;
		gbc_lblDiscount.fill = GridBagConstraints.VERTICAL;
		gbc_lblDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscount.gridx = 1;
		gbc_lblDiscount.gridy = 7;
		getContentPane().add(lblDiscount, gbc_lblDiscount);

		txtDiscount = new JTextField();
		GridBagConstraints gbc_txtDiscount = new GridBagConstraints();
		gbc_txtDiscount.fill = GridBagConstraints.BOTH;
		gbc_txtDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiscount.gridwidth = 3;
		gbc_txtDiscount.gridx = 2;
		gbc_txtDiscount.gridy = 7;
		getContentPane().add(txtDiscount, gbc_txtDiscount);
		txtDiscount.setColumns(10);

		JButton btnSaveAndClose = new JButton("Save and Close");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.anchor = GridBagConstraints.WEST;
		gbc_btnSave.fill = GridBagConstraints.VERTICAL;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 9;
		getContentPane().add(btnSaveAndClose, gbc_btnSave);

		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 9;
		getContentPane().add(btnCancel, gbc_btnNewButton);

		btnSaveAndClose.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				saveCustomer();
			}
		});
		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}

	/**
	 * Validates all text fields, and flags whether the new customer should be
	 * saved.
	 */
	private void saveCustomer()
	{
		try
		{
			if (txtName.getText().isEmpty() || txtAddress.getText().isEmpty() || txtPhone.getText().isEmpty() || txtEmail.getText().isEmpty() || txtDiscount.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please fill out all fields ");
			} else
			{

				cCtrl.addCustomer(cCtrl.createCustomer(//
						txtName.getText(), //
						txtAddress.getText(), //
						txtPhone.getText(), //
						txtEmail.getText(), //
						nf.parse(txtDiscount.getText()).doubleValue()));
				JOptionPane.showMessageDialog(this, "Customer is created");
				dispose();
			}
		} catch (ParseException e)
		{
			JOptionPane.showMessageDialog(this, "The Discount has to be a number");
		}
	}

	public void showDialog()
	{
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}