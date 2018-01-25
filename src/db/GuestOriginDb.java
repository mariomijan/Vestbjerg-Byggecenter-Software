package db;

import java.sql.Connection;

import db.DbConnection;
import model.GuestOrigin;

public class GuestOriginDb
{
	private Connection con;

	public GuestOriginDb()
	{
		con = DbConnection.getInstance().getDBcon();
	}
	
	
	

}
