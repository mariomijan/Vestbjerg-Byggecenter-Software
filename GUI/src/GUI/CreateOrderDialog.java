package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import CTRL.CustomerCtrl;
import CTRL.OrderCtrl;
import MODEL.Customer;
import MODEL.Order;
import MODEL.PartOrder;

import java.awt.FlowLayout;

public class CreateOrderDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3435415105159305134L;
	private JTable table;
	private OrderCtrl oCtrl = new OrderCtrl();
	private Order order;
	private PartOrderTableModel tableModel;
	private JLabel lblCustomerValue;
	private JLabel lblOrderIDValue;
	private JLabel lblTotalPriceValue;
	private CustomerCtrl cCtrl = new CustomerCtrl();
	private Customer customer;
	private JButton btnSaveClose; 

	public CreateOrderDialog()
	{
		setTitle("Create Order");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSaveClose = new JButton("Save and Close");
		btnSaveClose.setEnabled(false);
		btnSaveClose.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				saveOrder();
			}
		});
		buttonPanel.add(btnSaveClose);

		JButton btnAddPartorder = new JButton("Add Partorder");
		buttonPanel.add(btnAddPartorder);
		btnAddPartorder.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				CreatePartorderDialog cpoDialog = new CreatePartorderDialog();
				cpoDialog.showDialog();
				if (cpoDialog.isShouldSave())
				{
					order.addPartOrder(cpoDialog.getPartOrder());
					lblTotalPriceValue.setText("0");
					totalOrderPrice();
					tableModel.fireTableDataChanged();
					refreshSaveButton();
				}

			}
		});

		JButton btnAttachCustomer = new JButton("Add Customer");
		buttonPanel.add(btnAttachCustomer);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		buttonPanel.add(btnCancel);
		btnAttachCustomer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AddCustomerDialog addCustomer = new AddCustomerDialog();
				addCustomer.showDialog(order);
				customer = cCtrl.findCustomer(order.getCustomerPhone());
				lblCustomerValue.setText(order.getCustomerPhone());
				refreshSaveButton();
			}
		});

		JPanel infoPanel = new JPanel();
		getContentPane().add(infoPanel, BorderLayout.NORTH);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]
		{ 30, 30, 0, 30, 42, 0, 30, 54, 0, 30, 0 };
		gbl_infoPanel.rowHeights = new int[]
		{ 15, 14, 15, 0 };
		gbl_infoPanel.columnWeights = new double[]
		{ 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_infoPanel.rowWeights = new double[]
		{ 1.0, 0.0, 1.0, Double.MIN_VALUE };
		infoPanel.setLayout(gbl_infoPanel);

		JLabel lblCustomer = new JLabel("Customer:");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 1;
		gbc_lblCustomer.gridy = 1;
		infoPanel.add(lblCustomer, gbc_lblCustomer);

		lblCustomerValue = new JLabel("");
		GridBagConstraints gbc_lblCustomerValue = new GridBagConstraints();
		gbc_lblCustomerValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerValue.gridx = 2;
		gbc_lblCustomerValue.gridy = 1;
		infoPanel.add(lblCustomerValue, gbc_lblCustomerValue);

		JLabel lblOrderid = new JLabel("OrderId:");
		GridBagConstraints gbc_lblOrderid = new GridBagConstraints();
		gbc_lblOrderid.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblOrderid.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrderid.gridx = 4;
		gbc_lblOrderid.gridy = 1;
		infoPanel.add(lblOrderid, gbc_lblOrderid);

		lblOrderIDValue = new JLabel("0");
		GridBagConstraints gbc_lblOrderIDValue = new GridBagConstraints();
		gbc_lblOrderIDValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrderIDValue.gridx = 5;
		gbc_lblOrderIDValue.gridy = 1;
		infoPanel.add(lblOrderIDValue, gbc_lblOrderIDValue);

		JLabel lblTotalPrice = new JLabel("Total price:");
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPrice.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTotalPrice.gridx = 7;
		gbc_lblTotalPrice.gridy = 1;
		infoPanel.add(lblTotalPrice, gbc_lblTotalPrice);

		lblTotalPriceValue = new JLabel("0");
		GridBagConstraints gbc_lblTotalPriceValue = new GridBagConstraints();
		gbc_lblTotalPriceValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPriceValue.gridx = 8;
		gbc_lblTotalPriceValue.gridy = 1;
		infoPanel.add(lblTotalPriceValue, gbc_lblTotalPriceValue);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(0, 160));

		JScrollPane tableScrollPane = new JScrollPane(table);
		getContentPane().add(tableScrollPane, BorderLayout.CENTER);
	}

	private void saveOrder()
	{
		switch (JOptionPane.showConfirmDialog(this, "A confirmed order can't be deleted, are you sure you wish to create this order?", "Confirm Order", JOptionPane.YES_NO_OPTION))
		{
			case JOptionPane.YES_OPTION:
				oCtrl.addOrder(order);
				new Pdf(order);
				dispose();
				break;
			default:
				break;
		}
	}

	public void showDialog()
	{
		order = oCtrl.createOrder();
		lblOrderIDValue.setText(Integer.toString(order.getId()));
		tableModel = new PartOrderTableModel(order);
		table.setModel(tableModel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void totalOrderPrice()
	{
		double customerDiscount = 0;
		if(customer != null)
		{
			customerDiscount += customer.getDiscount();
		}
		double totalPrice = 0;
		for (int i = 0; i < order.getPartorders().size(); i++)
		{
			PartOrder pOrder = order.getPartorders().get(i);
			totalPrice += (pOrder.getPartTotal()) - (pOrder.getPartTotal()
					/ 100.0 * (pOrder.getDiscount()+ customerDiscount));

		}
		lblTotalPriceValue.setText(Double.toString(totalPrice));
	}
	
	public void refreshSaveButton()
	{
		boolean status = (customer != null) && !order.getPartorders().isEmpty();
		btnSaveClose.setEnabled(status);
	}

}
