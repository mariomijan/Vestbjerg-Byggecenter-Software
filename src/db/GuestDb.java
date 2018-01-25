package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import db.DbConnection;
import model.Guest;
import model.GuestOrigin;

/**
 * Class GuestDb, which holds the information about the GuestDb
 * 
 * @author (Gruppe 2)
 * @version (05-12-2016)
 */

public class GuestDb
{
	private Connection con;

	/**
	 * Constructor for objects of class GuestDb
	 */
	public GuestDb()
	{
		con = DbConnection.getInstance().getDBcon();

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
	 */
	public Guest createGuest(String name, String lastName, String email, String phoneNo, GuestOrigin go)
	{
		Guest g = new Guest(name, lastName, email, phoneNo, go);
		return g;
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

		try
		{
			String addQ = addQuery(createGuest(name, lastName, email, phoneNo, go));
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(addQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	/**
	 * Method updateGuest, update the guest in the tabel
	 * 
	 * @param PhonoNo,
	 *            input phone of the guest
	 */
	public void updateGuest(String PhonoNo)
	{
		try
		{
			String updateQ = updateQuery(PhonoNo);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(updateQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}
	/**
	 * Method removeGuest, remove the guest from the tabel
	 * 
	 * @param phoneNo,
	 *            input phone of the guest
	 */
	public void removeGuest(String phoneNo)
	{

		try
		{
			String deleteQ = deleteQuery(phoneNo);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(deleteQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}

	}

	public Guest findGuest(String phoneNo)
	{
		//return singelWhere(phoneNo);
		return null;
	}

	public ArrayList<Guest> findAllGuest(boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}

	private ArrayList<Guest> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<Guest> list = new ArrayList<Guest>();
		String query = buildQuery(wClause);
		try
		{ // read the guest from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next())
			{
				Guest empObj;
				//empObj = buildGuest(results);
				//list.add(empObj);
			} // end while
			stmt.close();

		} // slut try
		catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return list;
	}
/*
	public Guest singelWhere(String phoneNo)
	{
		ResultSet results;

		String query = findQuery(phoneNo);
		try
		{ // read the guest from the database

			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			if (results.next())
			{
				Guest g = buildGuest(results);
				return g;

			}
			stmt.close();
		} // slut try
		catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return null;
	}
*/
	/*
	private Guest buildGuest(ResultSet results)
	{
		Guest empObj = null;
		try
		{ // the columns from the table guest are used
			empObj = new Guest(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
					results.getString(5));
		} catch (Exception e)
		{
			System.out.println("error in building the guest object");
		}
		return empObj;
	}
*/
	private String buildQuery(String wClause)
	{
		String query = "SELECT * FROM Guest";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		return query;
	}

	
	public String deleteQuery(String phoneNo)
	{
		return "DELETE FROM Guest WHERE PhoneNo = " + phoneNo + ";";
	}
	
	public String updateQuery(String phoneNo)
	{
		return "UPDATE Guest SET PhoneNo = " + phoneNo + "WHERE PhoneNo = " + phoneNo + ";";
		
	}

	public String addQuery(Guest g)
	{
		return "INSERT INTO Guest (Name,LastName,Email,PhoneNo) " + "VALUES ('" + g.getName() + "','" + g.getLastname()
				+ "','" + g.getEmail() + "','" + g.getPhoneNo() + "','" + g.getGuestOrigin() + "')";
	}
	
	public String findQuery(String phoneNo)
	{
		return "SELECT * FROM Guest where PhoneNo = '" + phoneNo + " ';";

	}
}
