package MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 * Class OrderContainer which holds the arraylist of orders
 * 
 * @author (Gruppe 4)
 * @version (04-12-2015)
 */
public class OrderContainer
{
	// instance variables
	private ArrayList<Order> orders;
	private static OrderContainer instance = null;

	/**
	 * Constructor for objects of class OrderContainer
	 */
	private OrderContainer()
	{
		// initialise instance variables
		orders = new ArrayList<Order>();
	}

	/**
	 * @return the singelton instance of OrderContainer
	 */
	public static OrderContainer getInstance()
	{
		// put your code here
		if (instance == null)
		{
			instance = new OrderContainer();
		}
		return instance;
	}

	/**
	 * @param order
	 *            adds the object to the arraylist of orders
	 */
	public void addOrder(Order order)
	{
		orders.add(order);
	}

	/**
	 * @param id
	 *            takes an int id
	 * @return the found order object
	 */
	public Order findOrder(int id)
	{
		for (Order o : orders)
		{
			if (o.getId() == id)
			{
				return o;
			}
		}
		return null;
	}

	public List<Order> findAllOrders()
	{
		return orders;
	}
}
