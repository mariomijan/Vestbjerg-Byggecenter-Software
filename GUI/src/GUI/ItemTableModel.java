package GUI;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import CTRL.ItemCtrl;
import MODEL.Item;

public class ItemTableModel extends AbstractTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4258350672422219967L;
	private List<Item> items;
	private ItemCtrl iCtrl = new ItemCtrl();
	private String[] columnNames =
	{ "ID", "Name", "Description", "Price", "Quantity", "Minimum", "Maximum" };
	private String searchKeyword = "";
	private NumberFormat nf = new CommaFixNumberFormat();

	public ItemTableModel()
	{

		addTableModelListener(new TableModelListener()
		{

			@Override
			public void tableChanged(TableModelEvent e)
			{
				refreshItemList();
			}
		});
		fireTableDataChanged();

	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return items.size();
	}

	@Override
	public Object getValueAt(int rowindex, int columnindex)
	{

		Item item = items.get(rowindex);

		switch (columnindex)
		{
			default:
				return null;
			case 0:
				return item.getId();
			case 1:
				return item.getName();
			case 2:
				return item.getDescription();
			case 3:
				return item.getPrice();
			case 4:
				return item.getQuantity();
			case 5:
				return item.getMinimum();
			case 6:
				return item.getMaximum();
		}

	}

	public void refreshItemList()
	{
		items = iCtrl.findAllItems().stream().filter(i -> i.getName().toLowerCase().startsWith(searchKeyword.toLowerCase())).collect(Collectors.toList());

	}

	@Override
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	public void setSearchKeyword(String keyword)
	{
		searchKeyword = keyword;
		fireTableDataChanged();
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		Item i = items.get(rowIndex);
		String name = i.getName();
		String description = i.getDescription();
		double price = i.getPrice();
		int quantity = i.getQuantity();
		int minimum = i.getMinimum();
		int maximum = i.getMaximum();
		try
		{
			String input = (String) aValue;
			switch (columnIndex)
			{
				case 1:
					name = input;
					break;
				case 2:
					description = input;
					break;
				case 3:
					price = nf.parse(input).doubleValue();
					break;
				case 4:
					quantity = nf.parse(input).intValue();
					break;
				case 5:
					minimum = nf.parse(input).intValue();
					break;
				case 6:
					maximum = nf.parse(input).intValue();
					break;
				default:
					return;
			}
			iCtrl.updateItem(i, name, description, price, quantity, minimum, maximum);
			fireTableDataChanged();
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		if (columnIndex == 0)
		{
			return false;
		}
		return true;
	}

	public String getItemFromRow(int row)
	{
		return (String) getValueAt(row, 1);
	}
}
