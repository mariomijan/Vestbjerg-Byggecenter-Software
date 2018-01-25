package CTRL;

import java.util.ArrayList;
import java.util.List;

import MODEL.*;

/**
 * Class ItemCtrl the controller for Item
 * 
 * @author (Gruppe 4)
 * @version (07-12-2015)
 */
public class ItemCtrl
{
	private ItemContainer iCon = ItemContainer.getInstance();
	private static int id;

	/**
	 * @param name
	 *            the name of the item of the type string
	 * @return the object of the found item
	 */
	public Item findItem(String name)
	{
		return iCon.findItem(name);
	}

	/**
	 * @param name
	 *            takes an String name as arguement
	 * @param description
	 *            takes an String description as aruement
	 * @param price
	 *            takes an double precision floating point price as arguement
	 * @param quantity
	 *            takes an double precision foloating point quantity as
	 *            arguement
	 * @param minimum
	 *            takes an int minimum as argument
	 * @param maximum
	 *            takes an int maximum as argument
	 * @return an Item Object
	 */
	public Item createItem(String name, String description, double price, int quantity, int minimum, int maximum)
	{
		Item i = new Item(id, name, description, price, quantity, minimum, maximum);
		id++;
		return i;
	}

	/**
	 * add item to an item container
	 * 
	 * @param i
	 *            takes an Object item
	 * 
	 */
	public void addItem(Item i)
	{
		iCon.addItem(i);
	}

	/**
	 * removes and item from the item container
	 * 
	 * @param i
	 *            takes an object item
	 */
	public void removeItem(Item i)
	{
		iCon.removeItem(i);
	}

	public List<Item> findAllItems()
	{
		return new ArrayList<Item>(iCon.findAllItems());
	}

	/**
	 * @param i
	 *            takes an object item
	 * @param name
	 *            takes a String name
	 * @param description
	 *            takes a String description
	 * @param price
	 *            takes a double price
	 * @param quantity
	 *            takes a int quantity
	 * @param minimum
	 *            takes a int minimum
	 * @param maximum
	 *            takes a int maximum
	 */
	public void updateItem(Item i, String name, String description, double price, int quantity, int minimum, int maximum)
	{
		i.setName(name.isEmpty() ? i.getName() : name);
		i.setDescription(description.isEmpty() ? i.getDescription() : description);
		i.setPrice(price < 0 ? i.getPrice() : price);
		i.setQuantity(quantity < 0 ? i.getQuantity() : quantity);
		i.setMinimum(minimum < 0 ? i.getMinimum() : minimum);
		i.setMaximum(maximum < 0 ? i.getMaximum() : maximum);
	}
}