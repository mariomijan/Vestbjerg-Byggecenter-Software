package ctrl;

import java.util.Objects;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.LoginDb;
import model.Login;

public class LoginCtrl {

	//TODO need something like login status 
	public String login(JTextField txtUserName, JTextField txtPassword) {
		String userName = txtUserName.getText();
		String password = txtPassword.getText();
		LoginDb lDb = new LoginDb();
		Login login = lDb.findLogin(userName);
		
		//TODO Split this into another method
		
		//Checks the login txtValues with the ones from the database
		if (login != null) {
			if (Objects.equals(login.getPassword(), password)) {
				login.setStatus(true);
				return "You are now logged in as " + login.getUserName();
			} else {
				return "Password was wrong please try again";
			}
		}
		else {
			if(userName.length() == 0 && password.length() == 0){
				return "Please input a UserName and a Password"; 
			}
			else {
				return "the username is wrong please try again";
			}
			
		}
	}

}
