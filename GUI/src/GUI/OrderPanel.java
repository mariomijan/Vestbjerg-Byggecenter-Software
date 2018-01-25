package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class OrderPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4963133430897377263L;
	private JTable orderTable;
	private JTextField txtSearch;
	private OrderTableModel tableModel;
	
	/**
	 * Create the panel.
	 */
	public OrderPanel()
	{
		setLayout(new BorderLayout(0, 0));

		tableModel = new OrderTableModel();

		orderTable = new JTable();
		orderTable.setFillsViewportHeight(true);
		orderTable.setModel(tableModel);

		new ButtonColumn(orderTable, new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				OrderDetailsDialog odDialog = new OrderDetailsDialog();
				int row = orderTable.convertRowIndexToModel(orderTable.getSelectedRow());
				odDialog.showDialog((int) tableModel.getValueAt(row, 0));
			}
		}, 3);

		JScrollPane tableScrollPane = new JScrollPane(orderTable);
		add(tableScrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(buttonPanel, BorderLayout.SOUTH);

		JButton btnCreateOrder = new JButton("Create Order");
		btnCreateOrder.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				CreateOrderDialog coDialog = new CreateOrderDialog();
				coDialog.showDialog();
				tableModel.fireTableDataChanged();
			}
		});
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPanel.add(btnCreateOrder);

		JPanel searchPane = new JPanel();
		FlowLayout fl_searchPane = (FlowLayout) searchPane.getLayout();
		fl_searchPane.setAlignment(FlowLayout.RIGHT);
		add(searchPane, BorderLayout.NORTH);

		JLabel lblSearchOrderId = new JLabel("Search Order ID:");
		searchPane.add(lblSearchOrderId);

		txtSearch = new JTextField("");
		searchPane.add(txtSearch);

		txtSearch.addMouseListener(new MouseAdapter()
		{
			@Override

			public void mouseClicked(MouseEvent arg0)
			{
				if (txtSearch.getText().equalsIgnoreCase("Search Order ID..."))
				{
					txtSearch.setText("");
				}
			}
		});
		
		txtSearch.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void removeUpdate(DocumentEvent arg0)
			{
				tableModel.setSearchKeyword(txtSearch.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent arg0)
			{
				tableModel.setSearchKeyword(txtSearch.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent arg0)
			{
				tableModel.setSearchKeyword(txtSearch.getText());
			}
		});

		txtSearch.setToolTipText("Search Order..");
		txtSearch.setColumns(12);

	}
}
