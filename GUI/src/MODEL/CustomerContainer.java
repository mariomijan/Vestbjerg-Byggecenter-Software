package MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 * Class CustomerContainer which holds the information about multiple customers,
 * including singleton
 * 
 * @author (Gruppe 4)
 * @version (04-12-2015)
 */
public class CustomerContainer
{
	// instance variables - replace the example below with your own
	private ArrayList<Customer> customers;
	private static CustomerContainer instance = null;

	/**
	 * Constructor for objects of class CustomerContainer
	 */
	private CustomerContainer()
	{
		// initialise instance variables
		customers = new ArrayList<Customer>();
	}

	/**
	 * @return the instance of the CustomerContainer
	 */
	public static CustomerContainer getInstance()
	{
		// put your code here
		if (instance == null)
		{
			instance = new CustomerContainer();
		}
		return instance;
	}

	/**
	 * Method addCustomer which adds the customer to the list
	 * 
	 * @param customer
	 *            takes a Customer object
	 */
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}

	/**
	 * This method finds the person through the phone number
	 * 
	 * @param phone
	 *            takes a customer phone number of type string
	 * @return the found customer object
	 */
	public Customer findCustomer(String phone)
	{
		for (Customer cust : customers)
		{
			if (cust.getPhone().equals(phone))
			{
				return cust;
			}
		}
		return null;
	}

	/**
	 * Removes the customer from the container.
	 * 
	 * @param customer
	 *            - the customer to be removed.
	 */
	public void removeCustomer(Customer customer)
	{
		customers.remove(customer);
	}

	public List<Customer> findAllCustomers()
	{
		return customers;
	}
}
