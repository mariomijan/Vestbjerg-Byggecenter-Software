package GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import CTRL.CustomerCtrl;
import CTRL.OrderCtrl;
import MODEL.Customer;
import MODEL.Order;
import MODEL.PartOrder;

public class OrderTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4509641040419698995L;
	private List<Order> orders;
	private OrderCtrl oCtrl = new OrderCtrl();
	private String[] columnNames =
	{ "ID", "Total", "Total after discount", "Details" };
	private String searchKeyword = "";
	private CustomerCtrl cCtrl = new CustomerCtrl();

	public OrderTableModel()
	{
		addTableModelListener(new TableModelListener()
		{

			@Override
			public void tableChanged(TableModelEvent e)
			{
				refreshOrderList();
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
		return orders.size();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return columnIndex == 3;
	}

	@Override
	public Object getValueAt(int rowindex, int columnindex)
	{

		Order order = orders.get(rowindex);

		switch (columnindex)
		{
			default:
				return null;
			case 0:
				return order.getId();
			case 1:
			{
				double totalPrice = 0;
				for (PartOrder po : order.getPartorders())
				{
					totalPrice += po.getPartTotal();
				}
				return totalPrice;
			}

			case 2:
			{
				Customer customer = cCtrl.findCustomer(order.getCustomerPhone());
				double customerDiscount = 0;
				if(customer != null)
				{
					customerDiscount += customer.getDiscount();
				}
				double totalPrice = 0;
				for (PartOrder po : order.getPartorders())
				{
					totalPrice += calcTotalAfterDiscount(po.getPartTotal(), po.getDiscount()+ customerDiscount);
				}
				return totalPrice;
			}
			case 3:
				return "Details...";
		}
	}

	public void refreshOrderList()
	{
		orders = oCtrl.findAllOrders();
		for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();)
		{
			Order order = (Order) iterator.next();
			if (!Integer.toString(order.getId()).startsWith(searchKeyword))
			{
				iterator.remove();
			}
		}
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

	public double calcTotalAfterDiscount(double total, double discount)
	{
		return total - ((total / 100.0) * discount);
	}

	public int getOrderIDFromRow(int row)
	{
		return (int) getValueAt(row, 0);
	}

}
