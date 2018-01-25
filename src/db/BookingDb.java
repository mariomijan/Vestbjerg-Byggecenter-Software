package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Booking;
import model.Guest;
import model.Invoice;
import model.Room;

public class BookingDb
{
	private Booking book;
	private Connection con;

	public BookingDb()
	{
		con = DbConnection.getInstance().getDBcon();
	}

	public Booking createBooking(Date startDate, Date endDate, int discount, Invoice i, Guest g, Room r)
	{
		Booking b = new Booking(startDate, endDate, discount, i, g, r);
		return b;
	}

	public void addBooking(Date startDate, Date endDate, int discount, Invoice i, Guest g, Room r)
	{
		Booking book = createBooking(startDate, endDate, discount, i, g, r);
		try
		{
			String addQ = addQuery(book);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(addQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	public void updateBooking(Booking book)
	{
		try
		{
			String updateQ = updateQuery(book);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(updateQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	public void deleteBooking(Booking book)
	{
		try
		{
			String updateQ = updateQuery(book);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(updateQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	public void findBooking(String bookingId)
	{
		try
		{
			String updateQ = findQuery(bookingId);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(updateQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	public Booking singelWhere(String bookingId)
	{
		ResultSet results;

		String query = findQuery(bookingId);
		try
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			if (results.next())
			{
				Booking book = buildBooking(results);
				return book;

			}
			stmt.close();
		} catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return null;
	}

	private ArrayList<Booking> miscWhere(String wClause)
	{
		ResultSet results;
		ArrayList<Booking> list = new ArrayList<Booking>();
		String query = buildQuery(wClause);
		try
		{
			PreparedStatement pre = con.prepareStatement(query);

			pre.setQueryTimeout(5);

			results = pre.executeQuery();

			while (results.next())
			{
				Booking bookObj;
				bookObj = buildBooking(results);
				list.add(bookObj);
			}

			pre.close();
			return list;

		} catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return list;
	}

	private Booking buildBooking(ResultSet results)
	{
		Booking bookObj = null;
		try
		{
			bookObj = new Booking(results.getInt(1), results.getDate(2), results.getDate(3), results.getInt(4), null,
					null, null);
		} catch (Exception e)
		{
			System.out.println("Error in building the Booking object");
		}
		return bookObj;
	}

	private String buildQuery(String wClause)
	{
		String query = "SELECT * FROM Booking";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		return query;
	}

	private String addQuery(Booking book2)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String updateQuery(Booking book2)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String deleteQuery(Booking book2)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String findQuery(String bookingId)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
