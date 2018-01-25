package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import CTRL.ItemCtrl;

public class ItemPanel extends JPanel
{
	private static final long serialVersionUID = -2532672312771839974L;

	private JTable itemTable;
	private ItemTableModel itemTableModel = new ItemTableModel();
	private JScrollPane tableScrollPane;

	private ItemCtrl iCtrl = new ItemCtrl();
	private JTextField txtSearch;
	protected String keyword = "";

	/**
	 * Create the panel.
	 */
	public ItemPanel()
	{
		setLayout(new BorderLayout(0, 0));

		itemTable = new JTable();
		itemTable.setFillsViewportHeight(true);
		itemTable.setModel(itemTableModel);

		tableScrollPane = new JScrollPane(itemTable);
		add(tableScrollPane, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		add(buttonPane, BorderLayout.SOUTH);

		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				deleteItem();
			}
		});

		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				createItem();
			}
		});
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPane.add(btnCreateItem);
		buttonPane.add(btnDeleteItem);

		JPanel searchPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) searchPane.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(searchPane, BorderLayout.NORTH);

		JLabel lblSearchItem = new JLabel("Search item:");
		searchPane.add(lblSearchItem);

		txtSearch = new JTextField("Search Item...");
		txtSearch.setColumns(10);
		searchPane.add(txtSearch);
		txtSearch.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if (txtSearch.getText().equalsIgnoreCase("Search Item..."))
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
				itemTableModel.setSearchKeyword(txtSearch.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent arg0)
			{
				itemTableModel.setSearchKeyword(txtSearch.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent arg0)
			{
				itemTableModel.setSearchKeyword(txtSearch.getText());
			}
		});

		itemTableModel.fireTableDataChanged();

	}

	private void createItem()
	{
		CreateItemDialog createItem = new CreateItemDialog();
		createItem.showDialog();
		itemTableModel.fireTableDataChanged();
	}

	private void deleteItem()
	{
		int choice = JOptionPane.showConfirmDialog(ItemPanel.this, "Are you sure you wish to delete this item?", "", JOptionPane.YES_NO_OPTION);
		switch (choice)
		{
			case JOptionPane.YES_OPTION:
				for (int row : itemTable.getSelectedRows())
				{
					int convertedRow = itemTable.convertRowIndexToModel(row);
					iCtrl.removeItem(iCtrl.findItem(itemTableModel.getItemFromRow(convertedRow)));
				}
				itemTableModel.fireTableDataChanged(); // notifies the
														// TableModel that the
														// table has changed.
				break;
			default:
				break;
		}
	}
}
