package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import CTRL.OrderCtrl;
import MODEL.PartOrder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class CreatePartorderDialog extends JDialog
{

	private static final long serialVersionUID = 7565614783417222300L;
	private JTable partorderTable;
	private JTextField txtDiscount;
	private JTextField txtAmount;
	private JTextField txtItemName;
	private JTextField txtSearch;
	private boolean save;
	private NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
	private OrderCtrl oCtrl = new OrderCtrl();
	private PartOrder partOrder;
	private PartOrderItemTableModel tableModel;

	public CreatePartorderDialog()
	{
		setTitle("Create partorder");
		setBounds(100, 100, 588, 480);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());

		partorderTable = new JTable();
		JScrollPane tablePane = new JScrollPane(partorderTable);
		getContentPane().add(tablePane, BorderLayout.CENTER);

		partorderTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				int row = partorderTable.convertRowIndexToModel(partorderTable.getSelectedRow());
				txtItemName.setText(partorderTable.getValueAt(row, 1).toString());
			}
		});
		partorderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = new PartOrderItemTableModel();
		partorderTable.setModel(tableModel);
		partorderTable.setFillsViewportHeight(true);
		partorderTable.setPreferredScrollableViewportSize(new Dimension(0, 160));

		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[] { 30, 80, 80, 80, 80, 30, 0 };
		gbl_buttonPane.rowHeights = new int[] { 0, 0, 0, 0, 23, 0 };
		gbl_buttonPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_buttonPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		buttonPane.setLayout(gbl_buttonPane);

		JLabel lblItemName = new JLabel("Item name");
		GridBagConstraints gbc_lblItemName = new GridBagConstraints();
		gbc_lblItemName.gridwidth = 2;
		gbc_lblItemName.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName.gridx = 2;
		gbc_lblItemName.gridy = 0;
		buttonPane.add(lblItemName, gbc_lblItemName);

		txtItemName = new JTextField();
		txtItemName.setEditable(false);
		GridBagConstraints gbc_txtItemName = new GridBagConstraints();
		gbc_txtItemName.gridwidth = 2;
		gbc_txtItemName.insets = new Insets(0, 0, 5, 5);
		gbc_txtItemName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtItemName.gridx = 2;
		gbc_txtItemName.gridy = 1;
		buttonPane.add(txtItemName, gbc_txtItemName);
		txtItemName.setColumns(10);

		JLabel lblDiscount = new JLabel("Discount");
		GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.gridwidth = 2;
		gbc_lblDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscount.gridx = 1;
		gbc_lblDiscount.gridy = 2;
		buttonPane.add(lblDiscount, gbc_lblDiscount);

		JLabel lblAmount = new JLabel("Amount");
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.gridwidth = 2;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridx = 3;
		gbc_lblAmount.gridy = 2;
		buttonPane.add(lblAmount, gbc_lblAmount);

		txtDiscount = new JTextField();
		GridBagConstraints gbc_txtDiscount = new GridBagConstraints();
		gbc_txtDiscount.gridwidth = 2;
		gbc_txtDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiscount.gridx = 1;
		gbc_txtDiscount.gridy = 3;
		buttonPane.add(txtDiscount, gbc_txtDiscount);
		txtDiscount.setColumns(10);

		txtAmount = new JTextField();
		GridBagConstraints gbc_txtAmount = new GridBagConstraints();
		gbc_txtAmount.gridwidth = 2;
		gbc_txtAmount.insets = new Insets(0, 0, 5, 5);
		gbc_txtAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAmount.gridx = 3;
		gbc_txtAmount.gridy = 3;
		buttonPane.add(txtAmount, gbc_txtAmount);
		txtAmount.setColumns(10);

		JButton btnSave = new JButton("Save and close");
		btnSave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				savePartOrder();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.anchor = GridBagConstraints.NORTH;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 4;
		buttonPane.add(btnSave, gbc_btnSave);

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
		gbc_btnCancel.gridwidth = 2;
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTH;
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 4;
		buttonPane.add(btnCancel, gbc_btnCancel);

		JPanel serachPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) serachPane.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(serachPane, BorderLayout.NORTH);

		JLabel lblSearch = new JLabel(" Search Items:");
		serachPane.add(lblSearch);

		txtSearch = new JTextField();
		serachPane.add(txtSearch);
		txtSearch.setColumns(10);
		txtSearch.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void removeUpdate(DocumentEvent e)
			{
				tableModel.setSearchKeyword(txtSearch.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e)
			{
				tableModel.setSearchKeyword(txtSearch.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				tableModel.setSearchKeyword(txtSearch.getText());
			}
		});
	}

	public void showDialog()
	{
		save = false;
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public boolean isShouldSave()
	{
		return save;
	}

	public void fillItemName()
	{
		partorderTable.getSelectedRow();
	}

	public void savePartOrder()
	{
		try
		{
			if (txtDiscount.getText().isEmpty() || txtAmount.getText().isEmpty() || txtItemName.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please fill out all fields");
			} else
			{
				partOrder = oCtrl.createPartOrder(txtItemName.getText(), nf.parse(txtAmount.getText()).intValue(), nf.parse(txtDiscount.getText()).doubleValue());
				if (partOrder != null)
				{
					save = true;
					dispose();
				} else
				{
					JOptionPane.showMessageDialog(this, "Unknown Error!");
				}
			}
		} catch (ParseException e)
		{
			JOptionPane.showMessageDialog(this, "Discount and amount has to be a number");
		}
	}

	public PartOrder getPartOrder()
	{
		return partOrder;
	}

}
