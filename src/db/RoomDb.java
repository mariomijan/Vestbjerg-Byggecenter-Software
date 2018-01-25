package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Room;
import model.RoomType;

public class RoomDb
{
	private Connection con;

	/**
	 * Gets the singleton db connection
	 */
	public RoomDb()
	{
		con = DbConnection.getInstance().getDBcon();
	}

	public Room createRoom(boolean status, RoomType rt)
	{
		Room room = new Room(status, rt);
		return room;
	}

	public void addRoom(boolean status, RoomType rt)
	{
		Room room = createRoom(status, rt);
		try
		{
			String addQ = addQuery(room);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(addQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	public void removeRoom(Room room)
	{
		try
		{
			String deleteQ = deleteQuery(room);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(deleteQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	public void updateRoom(boolean status, Room room)
	{
		try
		{
			String updateQ = updateQuery(status, room);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(updateQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	private String addQuery(Room room)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String updateQuery(boolean status, Room room)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String deleteQuery(Room room)
	{
		// TODO Auto-generated method stub
		return null;
	}


}
