package CTRL;

import java.util.ArrayList;
import java.util.List;

import MODEL.*;

/**
 * Class OrderCtrl the controller for the order
 * 
 * @author (Gruppe 4)
 * @version (07-12-2015)
 */
public class OrderCtrl
{
	// instance variables
	private OrderContainer oCon = OrderContainer.getInstance();
	// private CustomerCtrl cCtrl = new CustomerCtrl();
	private ItemCtrl iCtrl = new ItemCtrl();
	private static int id;

	/**
	 * Create the order, calls the method addOrder
	 * 
	 * @param phone
	 * @param status
	 */
	public Order createOrder()
	{
		// id start on 0 and get incremented by one at the end.
		Order o = new Order(id, false);
		id++;
		return o;
	}

	/**
	 * @param takes
	 *            an order object o and adds it to the OrderContainer
	 */
	public boolean addOrder(Order o)
	{
		if (o != null)
		{
			oCon.addOrder(o);
			return true;
		}
		return false;
	}

	/**
	 * CreatePartOrder finds the item and uses it to create the new partOrder
	 * 
	 * 
	 * @param Takes
	 *            a String itemName
	 * @param Takes
	 *            an int quantity of an item
	 * @param discount
	 * 
	 * @return boolean true of false depending on the program evaluation
	 */
	public PartOrder createPartOrder(String itemName, int quantity, double discount)
	{
		Item i = iCtrl.findItem(itemName);
		if (i == null)
		{
			return null;
		}
		return new PartOrder(quantity, itemName, i.getPrice() * quantity, discount);
	}

	public void addPartOrder(Order order, PartOrder pOrder)
	{
		order.addPartOrder(pOrder);
	}

	/**
	 * finds the order and returns it if it exists
	 * 
	 * @param id
	 *            takes int id
	 */
	public Order findOrder(int id)
	{
		return oCon.findOrder(id);
	}

	/**
	 * find all orders and print a list
	 * 
	 * @return a list of orders
	 */
	public List<Order> findAllOrders()
	{
		return new ArrayList<Order>(oCon.findAllOrders());
	}

	public void addCustomer(String phone, Order order)
	{
		order.setCustomerPhone(phone);
	}

}