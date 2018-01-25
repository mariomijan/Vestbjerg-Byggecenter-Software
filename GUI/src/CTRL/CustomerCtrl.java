package CTRL;

import java.util.ArrayList;
import java.util.List;

import MODEL.*;

/**
 * Class CustomerCtrl the controller for Customer
 * 
 * @author (Gruppe4)
 * @version (07-12-2015)
 */
public class CustomerCtrl
{
	private CustomerContainer cCon = CustomerContainer.getInstance();
	private static int id;

	/**
	 * @param phone
	 *            the phone of the customer of the type string
	 * @return the object of the found customer
	 */
	public Customer findCustomer(String phone)
	{
		return cCon.findCustomer(phone);
	}

	/**
	 * Create a customer object and adds it to the CustomerContainer
	 * 
	 * @param name
	 *            takes a String name of the customer
	 * @param address
	 *            takes a String address of the customer
	 * @param phone
	 *            takes a String phone of the customer
	 * @param email
	 *            takes a String email of the customer
	 * @param discount
	 *            takes a String discount of the customer
	 * 
	 */
	public Customer createCustomer(String name, String address, String phone, String email, double discount)
	{
		Customer c = new Customer(id, name, address, phone, email, discount);
		id++;
		return c;
	}

	/**
	 * method adds the customer object to the customerContainer
	 * 
	 * @param c
	 *            takes an customer object
	 */
	public boolean addCustomer(Customer c)
	{
		if (findCustomer(c.getPhone()) == null)
		{
			cCon.addCustomer(c);
			return true;
		}
		return false;
	}

	/**
	 * @param c
	 *            takes a customer object and find the customer
	 * @param name
	 *            takes a String name
	 * @param address
	 *            takes a string address
	 * @param phone
	 *            takes a String phone
	 * @param email
	 *            takes a String email
	 * @param discount
	 *            takes a double discount
	 */
	public void updateCustomer(Customer c, String name, String address, String phone, String email, double discount)
	{
		c.setName(name.isEmpty() ? c.getName() : name);
		c.setAddress(address.isEmpty() ? c.getAddress() : address);
		c.setPhone(phone.isEmpty() ? c.getPhone() : phone);
		c.setEmail(email.isEmpty() ? c.getEmail() : email);
		c.setDiscount(discount < 0 ? c.getDiscount() : discount);
	}

	/**
	 * removes a customer from the CustomerContainer
	 * 
	 * @param takes
	 *            an customer object
	 */
	public void removeCustomer(Customer c)
	{
		cCon.removeCustomer(c);
	}

	/**
	 * find all customer object and return them as an arrayList
	 * 
	 * @return an arrayList of customer
	 */
	public List<Customer> findAllCustomers()
	{
		return new ArrayList<Customer>(cCon.findAllCustomers());
	}
}