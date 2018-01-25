package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CTRL.OrderCtrl;
import MODEL.Order;

public class AddCustomerDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1724860316173111996L;
	private JTextField txtCustomerPhone;
	private Order order;
	private OrderCtrl oCtrl = new OrderCtrl();

	/**
	 * Create the dialog.
	 */
	public AddCustomerDialog()
	{
		setTitle("Add Customer to order");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		txtCustomerPhone = new JTextField();
		txtCustomerPhone.setEditable(false);
		txtCustomerPhone.setText("Customer Phone");
		txtCustomerPhone.setColumns(10);
		buttonPane.add(txtCustomerPhone);

		JButton btnAddCustomer = new JButton("Save");
		buttonPane.add(btnAddCustomer);

		JButton btnCancel = new JButton("Cancel");
		buttonPane.add(btnCancel);

		JTable customerTable = new JTable();
		customerTable.setFillsViewportHeight(true);

		OrderCustomerTableModel tableModel = new OrderCustomerTableModel();
		customerTable.setModel(tableModel);

		JScrollPane tableScrollPane = new JScrollPane(customerTable);
		getContentPane().add(tableScrollPane, BorderLayout.CENTER);

		JPanel searchPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) searchPane.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(searchPane, BorderLayout.NORTH);

		JLabel lblSearch = new JLabel("Search Phone:");
		searchPane.add(lblSearch);
		JTextField txtSearch = new JTextField();
		searchPane.add(txtSearch);
		txtSearch.setColumns(10);

		btnAddCustomer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
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
		customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				int row = customerTable.convertRowIndexToModel(customerTable.getSelectedRow());
				txtCustomerPhone.setText(customerTable.getValueAt(row, 2).toString());
			}
		});
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

	public void showDialog(Order order)
	{
		this.order = order;
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void saveCustomer()
	{
		if (txtCustomerPhone.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please select a customer");

		} else
		{
			oCtrl.addCustomer(txtCustomerPhone.getText(), order);
			JOptionPane.showMessageDialog(this, "Customer was successfully added to the order ");
			dispose();
		}

	}

}
