package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import CTRL.CustomerCtrl;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class CustomerPanel extends JPanel
{

	private static final long serialVersionUID = 1338250645115205420L;
	private CustomerCtrl cCtrl = new CustomerCtrl();
	private JTable customerTable;
	private CustomerTableModel tableModel;
	private JTextField txtSearch;

	/**
	 * Create the panel.
	 */
	public CustomerPanel()
	{

		setLayout(new BorderLayout(0, 0));

		customerTable = new JTable();
		tableModel = new CustomerTableModel();
		customerTable.setModel(tableModel);
		customerTable.setFillsViewportHeight(true);
		JScrollPane tableScrollPane = new JScrollPane(customerTable);
		add(tableScrollPane, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		add(buttonPane, BorderLayout.SOUTH);

		JButton btnCreateCustomer = new JButton("Create Customer");
		buttonPane.add(btnCreateCustomer);

		JButton btnDeleteCustomer = new JButton("Delete Customer");
		buttonPane.add(btnDeleteCustomer);

		JPanel searchPane = new JPanel();
		FlowLayout fl_searchPane = (FlowLayout) searchPane.getLayout();
		fl_searchPane.setAlignment(FlowLayout.RIGHT);
		add(searchPane, BorderLayout.NORTH);

		JLabel lblSearchCustomer = new JLabel("Search Customer:");
		searchPane.add(lblSearchCustomer);

		txtSearch = new JTextField();
		searchPane.add(txtSearch);
		txtSearch.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (txtSearch.getText().equalsIgnoreCase("Search Customer..."))
				{
					txtSearch.setText("");

				}
			}
		});
		txtSearch.setColumns(12);

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

		btnCreateCustomer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				createCustomer();
			}
		});
		btnDeleteCustomer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				deleteCustomer();
			}

		});
	}

	private void createCustomer()
	{
		CreateCustomerDialog ccDialog = new CreateCustomerDialog();
		ccDialog.showDialog(); // Blocks until Dialog is closed.
		tableModel.fireTableDataChanged(); // notifies the TableModel that
	}

	private void deleteCustomer()
	{
		int choice = JOptionPane.showConfirmDialog(CustomerPanel.this, "Are you sure you wish to delete this customer?", "", JOptionPane.YES_NO_OPTION);
		switch (choice)
		{
			case JOptionPane.YES_OPTION:
				for (int row : customerTable.getSelectedRows())
				{
					int convertedRow = customerTable.convertRowIndexToModel(row);
					cCtrl.removeCustomer(cCtrl.findCustomer(tableModel.getCustomerPhoneFromRow(convertedRow)));
				}
				tableModel.fireTableDataChanged(); // notifies the TableModel
													// that
													// the table has changed.
				break;
			default:
				break;
		}
	}
}