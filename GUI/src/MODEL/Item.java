package MODEL;

/**
 * Class Item which holds the information about the item
 * 
 * @author (Gruppe 4)
 * @version (04-12-2015)
 */
public class Item
{
	private int id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	private int minimum;
	private int maximum;

	/**
	 * Constructor for objects of class Item
	 * 
	 * @param id
	 *            is the id of the item
	 * @param name
	 *            is the name of the item
	 * @param description
	 *            is the description of the item
	 * @param price
	 *            is the price of the item
	 * @param quantity
	 *            is the quantity of the item
	 * @param minimum
	 *            is the minimum of the item
	 * @param maximum
	 *            is the maximum of the item
	 */
	public Item(int id, String name, String description, double price, int quantity, int minimum, int maximum)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/**
	 * @param name
	 *            takes a string name to update the name attribute
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @param description
	 *            takes a string description to update the description attribute
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @param price
	 *            takes a of the item to update the price attribute
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/**
	 * @param quantity
	 *            takes an int of the item to update the quantity attribute
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @param minimum
	 *            takes an int minimum to update the item minimum attribute
	 */
	public void setMinimum(int minimum)
	{
		this.minimum = minimum;
	}

	/**
	 * @param maximum
	 *            takes an int of the item to update the maximum attribute
	 */
	public void setMaximum(int maximum)
	{
		this.maximum = maximum;
	}

	/**
	 * @return the id of the item
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the name of the item
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the description of the item
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return the price of the item
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * @return the quantity of the item
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * @return the minimum of the item
	 */
	public int getMinimum()
	{
		return minimum;
	}

	/**
	 * @return the minimum of the item
	 */
	public int getMaximum()
	{
		return maximum;
	}
}