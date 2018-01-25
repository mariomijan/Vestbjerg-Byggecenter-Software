package ctrl;

import java.util.ArrayList;
import db.GuestDb;
import model.Guest;
import model.GuestOrigin;

/**
 * Class GuestCtrl, which holds the information about the guest controller
 * 
 * @author (Gruppe 2)
 * @version (05-12-2016)
 */

public class GuestCtrl
{
	private GuestDb guestDb;

	/**
	 * Constructor for objects of class GuestCtrl
	 */
	public GuestCtrl()
	{
		guestDb = new GuestDb();

	}

	/**
	 * Method createGuest, create the guest
	 * 
	 * @param name,
	 *            the name of the guest
	 * @param lastname,
	 *            the lastname of the guest
	 * @param email,
	 *            the email of the guest
	 * @param phoneNo,
	 *            the phone number of the guest
	 * @param go,
	 *            the object of guest origin
	 * @return
	 */
	public Guest createGuest(String name, String lastName, String email, String phoneNo, GuestOrigin go)
	{

		Guest guest = new Guest(name, lastName, email, phoneNo, go);
		return guest;
	}

	/**
	 * Method addGuest, add the guest to tabel
	 * 
	 * @param name,
	 *            the name of the guest
	 * @param lastname,
	 *            the lastname of the guest
	 * @param email,
	 *            the email of the guest
	 * @param phoneNo,
	 *            the phone number of the guest
	 * @param go,
	 *            the object of guest origin
	 */

	public void addGuest(String name, String lastName, String email, String phoneNo, GuestOrigin go)
	{
		guestDb.addGuest(name, lastName, email, phoneNo, go);

	}

	/**
	 * Method updateGuest, to update the guest
	 * 
	 * @param phoneNo,
	 *            phone number of the guest
	 */
	public void updateGuest(String phoneNo)
	{

		guestDb.updateGuest(phoneNo);
	}

	/**
	 * Method remoeGuest, to remove the quest
	 * 
	 * @param phoneNo,
	 *            input phone from the guest
	 */
	public void removeGuest(String phoneNo)
	{
		guestDb.removeGuest(phoneNo);

	}

	/**
	 * Method findGuest, to find the guest
	 * 
	 * @param phoneNo,
	 *            input phone from the guest
	 * @return the found guest from phone number
	 */
	public Guest findGuest(String phoneNo)
	{
		return null;
		// return guestDb.singelWhere(phoneNo);

	}

	/**
	 * Method findAllGuest, to find all the guests
	 * 
	 * @return the found guests
	 */
	public ArrayList<Guest> findAllGuest()
	{
		return guestDb.findAllGuest(false);

	}
}
