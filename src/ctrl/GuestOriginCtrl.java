package ctrl;

import db.GuestOriginDb;
import model.GuestOrigin;

public class GuestOriginCtrl
{
	private GuestOriginDb goDb;
	public GuestOriginCtrl(){
		goDb = new GuestOriginDb(); 
	}
	public GuestOrigin createGuestOrigin( String Country,String PostalCode, String City)
	{
		//Create a GuestOrigin Object and returns it 
		GuestOrigin go = new GuestOrigin( Country,PostalCode, City);
		//TODO might need a call to the database and add it here.
		return go;
	}
}
