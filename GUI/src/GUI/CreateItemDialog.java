package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import CTRL.ItemCtrl;

public class CreateItemDialog extends JDialog
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3787817171981190659L;

	private JTextField txtName;
	private JTextField txtDescription;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JTextField txtMinimum;
	private JTextField txtMaximum;
	private NumberFormat nf = new CommaFixNumberFormat();
	private ItemCtrl iCtrl = new ItemCtrl();

	public CreateItemDialog()
	{

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 384);
		setTitle("Create Item");
		setModal(true);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 55, 23, 3, 61, 46, 100, 0 };
		gbl_panel.rowHeights = new int[] { 19, 35, 30, 30, 30, 30, 30, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gbl_panel);

		JLabel lblCreateItem = new JLabel("Create Item");
		lblCreateItem.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCreateItem = new GridBagConstraints();
		gbc_lblCreateItem.anchor = GridBagConstraints.NORTH;
		gbc_lblCreateItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCreateItem.insets = new Insets(0, 0, 5, 0);
		gbc_lblCreateItem.gridwidth = 2;
		gbc_lblCreateItem.gridx = 5;
		gbc_lblCreateItem.gridy = 0;
		getContentPane().add(lblCreateItem, gbc_lblCreateItem);

		JLabel lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridwidth = 2;
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		getContentPane().add(lblName, gbc_lblName);

		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.BOTH;
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.gridwidth = 4;
		gbc_txtName.gridx = 3;
		gbc_txtName.gridy = 1;
		getContentPane().add(txtName, gbc_txtName);
		txtName.setColumns(10);

		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.fill = GridBagConstraints.BOTH;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridwidth = 3;
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 2;
		getContentPane().add(lblDescription, gbc_lblDescription);

		txtDescription = new JTextField();
		GridBagConstraints gbc_txtDescription = new GridBagConstraints();
		gbc_txtDescription.fill = GridBagConstraints.BOTH;
		gbc_txtDescription.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescription.gridwidth = 4;
		gbc_txtDescription.gridx = 3;
		gbc_txtDescription.gridy = 2;
		getContentPane().add(txtDescription, gbc_txtDescription);
		txtDescription.setColumns(10);

		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.fill = GridBagConstraints.BOTH;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 3;
		getContentPane().add(lblPrice, gbc_lblPrice);

		txtPrice = new JTextField();
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.fill = GridBagConstraints.BOTH;
		gbc_txtPrice.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrice.gridwidth = 4;
		gbc_txtPrice.gridx = 3;
		gbc_txtPrice.gridy = 3;
		getContentPane().add(txtPrice, gbc_txtPrice);
		txtPrice.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.fill = GridBagConstraints.BOTH;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 1;
		gbc_lblQuantity.gridy = 4;
		getContentPane().add(lblQuantity, gbc_lblQuantity);

		txtQuantity = new JTextField();
		GridBagConstraints gbc_txtQuantity = new GridBagConstraints();
		gbc_txtQuantity.fill = GridBagConstraints.BOTH;
		gbc_txtQuantity.insets = new Insets(0, 0, 5, 0);
		gbc_txtQuantity.gridwidth = 4;
		gbc_txtQuantity.gridx = 3;
		gbc_txtQuantity.gridy = 4;
		getContentPane().add(txtQuantity, gbc_txtQuantity);
		txtQuantity.setColumns(10);

		JLabel lblMinimum = new JLabel("Minimum : ");
		lblMinimum.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblMinimum = new GridBagConstraints();
		gbc_lblMinimum.fill = GridBagConstraints.BOTH;
		gbc_lblMinimum.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinimum.gridwidth = 3;
		gbc_lblMinimum.gridx = 1;
		gbc_lblMinimum.gridy = 5;
		getContentPane().add(lblMinimum, gbc_lblMinimum);

		txtMinimum = new JTextField();
		GridBagConstraints gbc_txtMinimum = new GridBagConstraints();
		gbc_txtMinimum.fill = GridBagConstraints.BOTH;
		gbc_txtMinimum.insets = new Insets(0, 0, 5, 0);
		gbc_txtMinimum.gridwidth = 4;
		gbc_txtMinimum.gridx = 3;
		gbc_txtMinimum.gridy = 5;
		getContentPane().add(txtMinimum, gbc_txtMinimum);
		txtMinimum.setColumns(10);

		JLabel lblMaximum = new JLabel("Maximum : ");
		lblMaximum.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblMaximum = new GridBagConstraints();
		gbc_lblMaximum.fill = GridBagConstraints.BOTH;
		gbc_lblMaximum.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaximum.gridwidth = 3;
		gbc_lblMaximum.gridx = 1;
		gbc_lblMaximum.gridy = 6;
		getContentPane().add(lblMaximum, gbc_lblMaximum);

		txtMaximum = new JTextField();
		GridBagConstraints gbc_txtMaximum = new GridBagConstraints();
		gbc_txtMaximum.fill = GridBagConstraints.BOTH;
		gbc_txtMaximum.insets = new Insets(0, 0, 5, 0);
		gbc_txtMaximum.gridwidth = 4;
		gbc_txtMaximum.gridx = 3;
		gbc_txtMaximum.gridy = 6;
		getContentPane().add(txtMaximum, gbc_txtMaximum);
		txtMaximum.setColumns(10);

		JButton btnCreateAndSave = new JButton("Create and save");
		btnCreateAndSave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				saveItem();

			}
		});
		GridBagConstraints gbc_btnCreateAndSave = new GridBagConstraints();
		gbc_btnCreateAndSave.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateAndSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateAndSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateAndSave.gridwidth = 4;
		gbc_btnCreateAndSave.gridx = 2;
		gbc_btnCreateAndSave.gridy = 7;
		getContentPane().add(btnCreateAndSave, gbc_btnCreateAndSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				dispose();

			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.NORTH;
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.gridx = 6;
		gbc_btnCancel.gridy = 7;
		getContentPane().add(btnCancel, gbc_btnCancel);

	}

	public void showDialog()
	{
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void saveItem()
	{
		try
		{
			if (txtName.getText().isEmpty() || txtDescription.getText().isEmpty() || txtPrice.getText().isEmpty() || txtQuantity.getText().isEmpty() || txtMinimum.getText().isEmpty() || txtMaximum.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please fill out all fields");

			} else
			{
				iCtrl.addItem(iCtrl.createItem(//
						txtName.getText(), //
						txtDescription.getText(), //
						nf.parse(txtPrice.getText()).doubleValue(), //
						nf.parse(txtQuantity.getText()).intValue(), //
						nf.parse(txtMinimum.getText()).intValue(), //
						nf.parse(txtMaximum.getText()).intValue()));
				JOptionPane.showMessageDialog(this, "Item is created");
				dispose();
			}
		} catch (ParseException numE)
		{
			JOptionPane.showMessageDialog(this, "Wrong format, please use a number");
		}
	}
}
