package MODEL;

import java.util.ArrayList;

/**
 * Write a description of class Order here.
 * 
 * @author (Gruppe 4)
 * @version (04-12-2015)
 */
public class Order
{
	// instance variables
	private int id;
	private boolean status;
	private String customerPhone;
	private ArrayList<PartOrder> partorders;

	/**
	 * Constructor for objects of class Order
	 */
	public Order(int id, boolean status)
	{
		this.id = id;
		this.status = status;
		partorders = new ArrayList<PartOrder>();
	}

	/**
	 * @param updates
	 *            the instance variable status
	 */
	public void setStatus(boolean status)
	{
		this.status = status;
	}

	/**
	 * @return the instance variable int id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the instance variable boolean status
	 */
	public boolean getStatus()
	{
		return status;
	}

	/**
	 * @param po
	 *            takes a partOrder Object
	 */
	public void addPartOrder(PartOrder po)
	{
		partorders.add(po);
	}

	/**
	 * @param phone
	 *            takes a String customer phone
	 */
	public void setCustomerPhone(String phone)
	{
		customerPhone = phone;
	}

	/**
	 * @return a String customer phone
	 */
	public String getCustomerPhone()
	{
		return customerPhone;
	}

	/**
	 * @return the List object containing the PartOrders attached to this Order
	 */
	public ArrayList<PartOrder> getPartorders()
	{
		return partorders;
	}
}
