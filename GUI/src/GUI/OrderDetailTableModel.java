package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import CTRL.OrderCtrl;
import MODEL.PartOrder;

public class OrderDetailTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 2516703894106049438L;
	private List<PartOrder> partOrders;
	private String[] columnNames = { "Item Name", "Quantity", "Discount", "Part Total" };
	private OrderCtrl oCtrl = new OrderCtrl();
	private int orderId;

	{
		addTableModelListener(new TableModelListener()
		{
			@Override
			public void tableChanged(TableModelEvent e)
			{
				refreshPartOrderList();
			}
		});
		fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		PartOrder pOrder = partOrders.get(rowIndex);
		switch (columnIndex)
		{
			case 0:
				return pOrder.getItemName();
			case 1:
				return pOrder.getQuantity();
			case 2:
				return pOrder.getDiscount();
			case 3:
				return pOrder.getPartTotal();
			default:
				return null;
		}
	}

	@Override
	public int getRowCount()
	{
		return partOrders.size();
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	private void refreshPartOrderList()
	{
		partOrders = new ArrayList<PartOrder>(oCtrl.findOrder(orderId).getPartorders());
	}

	public void setOrderId(int id)
	{
		orderId = id;
	}
}