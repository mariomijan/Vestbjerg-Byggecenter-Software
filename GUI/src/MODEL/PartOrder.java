package MODEL;

/**
 * Class PartOrder contains information about that is currently being processed
 * in a purchase
 * 
 * @author (Gruppe 4)
 * @version (04-12-2015)
 */
public class PartOrder
{
	// instance variables
	private String itemName;
	private int quantity;
	private double partTotal;
	private double discount;

	/**
	 * Constructor for objects of class PartOrder
	 * 
	 * @param quantity
	 *            takes int to assign value to an instance variable
	 * @param parttotal
	 *            takes an double to assign value to an instance variable
	 */
	public PartOrder(int quantity, String itemName, double partTotal, double discount)
	{
		this.itemName = itemName;
		this.quantity = quantity;
		this.partTotal = partTotal;
		this.discount = discount;
	}

	/**
	 * @param quantity
	 *            takes an int to update the instance variable
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @param parttotal
	 *            takes an double to update the instance variable
	 */
	public void setParttotal(double partTotal)
	{
		this.partTotal = partTotal;
	}

	/**
	 * 
	 * @param discount
	 *            - updates the instance variable to the new value
	 */
	public void setDiscount(double discount)
	{
		this.discount = discount;
	}

	/**
	 * @return the instance variable quantity of the class
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * @return the instance variable parttotal of the class
	 */
	public double getPartTotal()
	{
		return partTotal;
	}

	/**
	 * @return the name of the item referenced by this PartOrder
	 */
	public String getItemName()
	{
		return itemName;
	}

	/**
	 * @return the discount this PartOrder
	 */
	public double getDiscount()
	{
		return discount;
	}

}
