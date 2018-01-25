package GUI;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import CTRL.CustomerCtrl;
import MODEL.Customer;

/**
 * Creates an AbstractTableModel matching the Customer class.
 * 
 * @author Anders
 */
public class CustomerTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 7690585011725918600L;

	private String[] columnNames =
	{ "ID", "Name", "Address", "Phone", "Email", "Discount" };
	private List<Customer> customers;
	private CustomerCtrl cCtrl = new CustomerCtrl();
	private NumberFormat nf = new CommaFixNumberFormat();

	private String searchKeyword = "";

	public CustomerTableModel()
	{
		addTableModelListener(new TableModelListener()
		{
			@Override
			public void tableChanged(TableModelEvent e)
			{
				refreshCustomerList();
			}
		});
		fireTableDataChanged(); // notifies the TableModel that the table has
								// changed.
	}

	/**
	 * retrieves a fresh copy of the customer list from the Customer Controller.
	 */
	private void refreshCustomerList()
	{
		customers = cCtrl.findAllCustomers().stream().filter(c -> c.getPhone().contains(searchKeyword)).collect(Collectors.toList());
	}

	@Override
	public int getRowCount()
	{
		return customers.size();
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		Customer c = customers.get(rowIndex);
		String name = c.getName();
		String address = c.getAddress();
		String phone = c.getPhone();
		String email = c.getEmail();
		double discount = c.getDiscount();
		try
		{
			String input = (String) aValue;
			switch (columnIndex)
			{
				case 1:
					name = input;
					break;
				case 2:
					address = input;
					break;
				case 3:
					phone = input;
					break;
				case 4:
					email = input;
					break;
				case 5:
					discount = nf.parse(input).doubleValue();
					break;
				default:
					return;
			}
			cCtrl.updateCustomer(c, name, address, phone, email, discount);
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

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Customer c = customers.get(rowIndex);
		switch (columnIndex)
		{
			case 0:
				return c.getId();
			case 1:
				return c.getName();
			case 2:
				return c.getAddress();
			case 3:
				return c.getPhone();
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
		if (column < 0 || column >= columnNames.length)
		{
			return "{Error}";
		}
		return columnNames[column];
	}

	public String getCustomerPhoneFromRow(int row)
	{
		return (String) getValueAt(row, 3);
	}

	public void setSearchKeyword(String keyword)
	{
		searchKeyword = keyword;
		fireTableDataChanged();
	}
}
