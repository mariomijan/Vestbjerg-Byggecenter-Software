package GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import CTRL.CustomerCtrl;
import MODEL.Customer;

public class OrderCustomerTableModel extends AbstractTableModel
{
	/**
	 * 
	 */

	private static final long serialVersionUID = -206669383626086174L;
	private List<Customer> customerList;
	private String[] columNames =
	{ "ID", "Name", "Phone", "Address", "Email", "Discount" };
	CustomerCtrl cCtrl = new CustomerCtrl();
	private String keyword = "";

	public OrderCustomerTableModel()
	{
		addTableModelListener(new TableModelListener()
		{

			@Override
			public void tableChanged(TableModelEvent e)
			{
				refreshCustomerList();
			}
		});
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount()
	{
		return columNames.length;
	}

	@Override
	public int getRowCount()
	{
		return customerList.size();
	}

	@Override
	public Object getValueAt(int row, int column)
	{
		Customer c = customerList.get(row);
		switch (column)
		{
			case 0:
				return c.getId();
			case 1:
				return c.getName();
			case 2:
				return c.getPhone();
			case 3:
				return c.getAddress();
			case 4:
				return c.getEmail();
			case 5:
				return c.getDiscount();
			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int column)
	{
		return columNames[column];
	}

	public void setSearchKeyword(String text)
	{
		keyword = text;
		fireTableDataChanged();
	}

	public void refreshCustomerList()
	{
		customerList = cCtrl.findAllCustomers();
		for (Iterator<Customer> iterator = customerList.iterator(); iterator.hasNext();)
		{

			Customer customer = iterator.next();
			if (!customer.getPhone().startsWith(keyword))
			{
				iterator.remove();
			}
		}
	}
}
