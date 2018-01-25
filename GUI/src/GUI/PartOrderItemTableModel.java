package GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import CTRL.ItemCtrl;
import MODEL.Item;

public class PartOrderItemTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -782351046934861232L;
	private ItemCtrl iCtrl = new ItemCtrl();
	private List<Item> items;
	private String[] columnNames =
	{ "ID", "Item name", "Price", "Description", "Quantity" };
	private String searchKeyword = "";

	public PartOrderItemTableModel()
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
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	public void refreshItemList()
	{
		items = iCtrl.findAllItems();
		for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();)
		{
			Item item = iterator.next();
			if (!item.getName().toLowerCase().contains(searchKeyword.toLowerCase()))
			{
				iterator.remove();
			}
		}
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
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Item i = items.get(rowIndex);
		switch (columnIndex)
		{
			case 0:
				return i.getId();
			case 1:
				return i.getName();
			case 2:
				return i.getPrice();
			case 3:
				return i.getDescription();
			case 4:
				return i.getQuantity();
			default:
				return null;
		}
	}

	public void setSearchKeyword(String keyword)
	{
		searchKeyword = keyword;
		fireTableDataChanged();
	}

}
