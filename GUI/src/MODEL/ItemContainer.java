package MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 * Class itemContains holds an arraylist of items
 * 
 * @author (Gruppe 4)
 * @version (04-12-2015)
 */
public class ItemContainer
{
	// instance variables
	private static ItemContainer instance = null;
	private ArrayList<Item> items;

	/**
	 * Constructor for objects of class ItemContainer
	 */
	private ItemContainer()
	{
		// initialise instance variables
		items = new ArrayList<Item>();
	}

	/**
	 * @return the singelton instance of itemContainer
	 */
	public static ItemContainer getInstance()
	{
		if (instance == null)
		{
			instance = new ItemContainer();
		}
		return instance;
	}

	/**
	 * @param item
	 *            adds the object to the arraylist of items
	 */
	public void addItem(Item item)
	{
		items.add(item);
	}

	/**
	 * This method finds the item through the name
	 * 
	 * @param name
	 *            takes a item name of the type string
	 * @return the found item object
	 */
	public Item findItem(String name)
	{
		for (Item item : items)
		{
			if (item.getName().equalsIgnoreCase((name)))
			{
				return item;

			}

		}
		return null;
	}

	/**
	 * this method removes the item from the arrayList
	 * 
	 * @param i
	 *            take an object item
	 */
	public void removeItem(Item i)
	{
		items.remove(i);
	}

	public List<Item> findAllItems()
	{
		return items;
	}
}
