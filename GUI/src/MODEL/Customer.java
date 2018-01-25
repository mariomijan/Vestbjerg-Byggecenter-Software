package MODEL;

/**
 * Class Customer, which holds the information about the customer
 * 
 * @author (Gruppe 4)
 * @version (04-12-2015)
 */
public class Customer
{
	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private double discount;

	/**
	 * Constructor for objects of class Customer
	 * 
	 * @param name
	 *            the name of the customer
	 * @param address
	 *            the address of the customer
	 * @param phone
	 *            the phone of the customer
	 * @param email
	 *            the email of the customer
	 */
	public Customer(int id, String name, String address, String phone, String email, double discount)
	{
		// initialise instance variables
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.discount = discount;
	}

	/**
	 * Method setName which sets the name of the customer
	 * 
	 * @param name,
	 *            input to set the name of the customer
	 */
	public void setName(String name)
	{
		// put your code here
		this.name = name;
	}

	/**
	 * Method setAddress which sets the address of the customer
	 * 
	 * @param address,
	 *            input to set the address of the customer
	 */
	public void setAddress(String address)
	{
		// put your code here
		this.address = address;
	}

	/**
	 * Method setPhone which sets the phone of the customer
	 * 
	 * @param phone,
	 *            input to set the phone of the customer
	 */
	public void setPhone(String phone)
	{
		// put your code here
		this.phone = phone;
	}

	/**
	 * Method setEmail which sets the email of the customer
	 * 
	 * @param email,
	 *            input to set the email of the customer
	 */
	public void setEmail(String email)
	{
		// put your code here
		this.email = email;
	}

	/**
	 * 
	 * @param discount,
	 *            input to set the discount of the customer
	 */
	public void setDiscount(double discount)
	{
		this.discount = discount;
	}

	/**
	 * @return the name of the customer
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the address of the customer
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @return the phone of the customer
	 */
	public String getPhone()
	{
		return phone;
	}

	/**
	 * @return the email of the customer
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @return the unique id of the customer
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the customer's discount
	 */
	public double getDiscount()
	{
		return discount;
	}

	@Override
	public String toString()
	{
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", discount=" + discount + "]";
	}
}
