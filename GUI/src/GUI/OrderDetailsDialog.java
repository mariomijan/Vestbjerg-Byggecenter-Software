package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import CTRL.CustomerCtrl;
import CTRL.OrderCtrl;
import java.awt.Component;
import javax.swing.Box;

public class OrderDetailsDialog extends JDialog
{
	private static final long serialVersionUID = -3356557408697457107L;
	private JTable table;
	private JLabel lblCustomerphonevalue;
	private OrderDetailTableModel tableModel;
	private OrderCtrl oCtrl = new OrderCtrl();
	private JLabel lblCustomername;
	private CustomerCtrl cCtrl = new CustomerCtrl();

	/**
	 * Create the dialog.
	 */
	public OrderDetailsDialog()
	{
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(320, 160));
		scrollPane.setViewportView(table);
		tableModel = new OrderDetailTableModel();
		table.setModel(tableModel);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		panel.add(btnClose);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblCustomer = new JLabel("Customer:");
		panel_1.add(lblCustomer);
		
		lblCustomername = new JLabel("CustomerName");
		panel_1.add(lblCustomername);
		
		Component horizontalStrut = Box.createHorizontalStrut(70);
		panel_1.add(horizontalStrut);

		JLabel lblCustomerPhone = new JLabel("Customer Phone:");
		panel_1.add(lblCustomerPhone);

		lblCustomerphonevalue = new JLabel("CustomerPhoneValue");
		panel_1.add(lblCustomerphonevalue);

	}

	public void showDialog(int id)
	{
		tableModel.setOrderId(id);
		String customerPhone = oCtrl.findOrder(id).getCustomerPhone();
		String customerName = cCtrl.findCustomer(customerPhone).getName();
		lblCustomerphonevalue.setText(customerPhone);
		lblCustomername.setText(customerName);
		tableModel.fireTableDataChanged();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Order Details");
	}

}
