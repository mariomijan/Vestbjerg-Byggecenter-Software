package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ctrl.LoginCtrl;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUi extends JPanel{
	private JTextField txtPassword;
	private JTextField txtUserName;
	private LoginCtrl lCtrl;
	/**
	 * Create the panel.
	 */
	public LoginUi()
	{
		lCtrl = new LoginCtrl();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 61, 115, 48, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUsername = new JLabel("UserName:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 7;
		gbc_lblUsername.gridy = 2;
		add(lblUsername, gbc_lblUsername);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		GridBagConstraints gbc_txtUserName = new GridBagConstraints();
		gbc_txtUserName.insets = new Insets(0, 0, 5, 5);
		gbc_txtUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUserName.gridx = 8;
		gbc_txtUserName.gridy = 2;
		add(txtUserName, gbc_txtUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 7;
		gbc_lblPassword.gridy = 3;
		add(lblPassword, gbc_lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 8;
		gbc_txtPassword.gridy = 3;
		add(txtPassword, gbc_txtPassword);
		
		JButton btnLogin = new JButton("Login");
		//Btn Login Event
		btnLogin.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, lCtrl.login(txtUserName, txtPassword), "Login", JOptionPane.INFORMATION_MESSAGE);
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 8;
		gbc_btnLogin.gridy = 4;
		add(btnLogin, gbc_btnLogin);
		

	}
}
