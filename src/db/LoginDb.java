package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Booking;
import model.Login;
import model.LoginRole;

public class LoginDb {

	private Connection con;
	public LoginDb(){
		con = DbConnection.getInstance().getDBcon();
	}

	//TODO take login object here?
	public Login findLogin(String userName)
	{
		ResultSet rs;
		try
		{
			String findQ = findQuery(userName);
			PreparedStatement stmt = con.prepareStatement(findQ);
			stmt.setQueryTimeout(5);
			rs = stmt.executeQuery();
			while(rs.next()){
				Login login = new Login(rs.getInt(1),rs.getString(2),rs.getString(3),
						new LoginRole(rs.getInt(4),rs.getString(5)));
				return login;
			}
			
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
		return null;
	}

	
	private String findQuery(String userName) {
		// TODO Auto-generated method stub
		
		return "select l.*, lr.LoginRole from [login] as l , LoginRole as lr where l.UserName  = '"
		 	+ userName +  "' and l.LoginRoleId = lr.LoginRoleId;";
	}
}
