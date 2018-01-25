package ctrl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import db.BookingDb;
import model.Guest;
import model.GuestOrigin;
import model.Invoice;
import model.Room;
import model.RoomType;
import model.Booking;

public class BookingCtrl
{
	private BookingDb bDb;
	private GuestOriginCtrl goCtrl = new GuestOriginCtrl();
	private GuestCtrl gCtrl = new GuestCtrl();
	private RoomTypeCtrl rtCtrl = new RoomTypeCtrl();
	private InvoiceCtrl iCtrl = new InvoiceCtrl();

	public BookingCtrl()
	{
		bDb = new BookingDb();
	}

	public Booking createBooking()
	{
		Booking b = new Booking();
		return b;
	}

	public Invoice createInvoice()
	{
		return iCtrl.createInvoice();
	}

	public void createBooking(Date startDate, Date endDate, double discount, Invoice i, Guest g)
	{
		//Booking b = new Booking(startDate, endDate, 0, i, g);
	}

	public Guest createGuest(String name, String lastName, String email, String phoneNo, String city, String country,
			String postalCode)
	{
		GuestOrigin go = goCtrl.createGuestOrigin(city, country, postalCode);
		return gCtrl.createGuest(name, lastName, email, phoneNo, go);
	}

	public Room findRoom()
	{
		return null;
	}

	public ArrayList<RoomType> getAllRoomTypes()
	{
		return rtCtrl.findAllRoomTypes();
	}
	
	public boolean[] checkGuestValues(String name, String lastName, String email, String phoneNo,
			String city, String country,String postalCode){
		boolean[] bList = new boolean[6];
		Method[] mt = getClass().getMethods();
		for(int i = 0; i < mt.length; i++){
			System.out.print(mt[i].getName());
		}
		if(name.length() >= 2){
			bList[0] = true;
		}
		else {
			bList[0] = false;
		}
		if(lastName.length() >= 2){
			bList[1] = true;
		}
		else {
			bList[1] = true;
		}
		
		return bList;
		
	}

}
