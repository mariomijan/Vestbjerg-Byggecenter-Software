/**
 * 
 */
package ctrl;

import java.util.ArrayList;

import db.RoomTypeDb;
import model.Room;
import model.RoomType;

/**
 * @author Kerim
 *
 */
public class RoomTypeCtrl
{
	private RoomTypeDb rtDB = new RoomTypeDb();
	
	//Might not need this  TODO
	private ArrayList<Room> roomList = new ArrayList<Room>();
/*
	public void createRoomType(boolean status, double roomPrice, String roomType, String description)
	{
		rtDB.createRoomType(status, roomPrice, roomType, description);
	}

	public void addRoomType(boolean status, double roomPrice, String roomType, String description)
	{
		rtDB.addRoomType(status, roomPrice, roomType, description);
	}
*/
	public void updateRoomType(/*boolean status, */double roomPrice, String roomType, String description)
	{
		rtDB.updateRoomType(/*status, */roomPrice, roomType, description);
	}

	public void removeRoomType(String roomTypeID)
	{
		rtDB.removeRoomType(roomTypeID);
	}

	public RoomType findRoomType(String roomTypeID)
	{
		return rtDB.singelWhere(roomTypeID);
	}

	public ArrayList<RoomType> findAllRoomTypes()
	{
		return rtDB.findAllRoomTypes();
	}
}
