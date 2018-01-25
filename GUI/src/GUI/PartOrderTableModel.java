package GUI;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import MODEL.Order;
import MODEL.PartOrder;

public class PartOrderTableModel extends AbstractTableModel
{

	private static final long serialVersionUID = -782351046934861232L;
	private List<PartOrder> ppo;
	private String[] columnNames =
	{ "Item name", "Quantity", "Discount", "Price", "Discount price" };

	public PartOrderTableModel(Order order)
	{
		addTableModelListener(new TableModelListener()
		{
			@Override
			public void tableChanged(TableModelEvent e)
			{
				ppo = order.getPartorders();
			}
		});
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column)
	{

		return columnNames[column];
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return ppo.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		PartOrder po = ppo.get(rowIndex);
		if (po != null)
		{
			switch (columnIndex)
			{
				case 0:
					return po.getItemName();
				case 1:
					return po.getQuantity();
				case 2:
					return po.getDiscount();
				case 3:
					return po.getPartTotal();
				case 4:
					return po.getPartTotal() - (po.getPartTotal() / 100.0 * po.getDiscount());
				default:
					return null;
			}
		}
		return null;
	}

}
