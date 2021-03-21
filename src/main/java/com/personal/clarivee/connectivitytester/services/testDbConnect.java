package com.personal.clarivee.connectivitytester.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.personal.clarivee.connectivitytester.services.Constants.enumDatabaseTypes;

public class testDbConnect implements ItestDBConnect {

	private String connstring;
	private String username;
	private String password;
	
		
	public String getConnstring() {
		return connstring;
	}

	public void setConnstring(String connstring) {
		this.connstring = connstring;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String Run() throws Exception {
		// TODO Auto-generated method stub
		String result;
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(connstring, username, password);
            
            result = "DB Conn Test - Connected to the PostgreSQL server successfully. Connection - " + connstring;
            		System.out.println(result);
            
        } catch (SQLException e) {
        	result = "DB Conn Test -" + connstring + "error - " + e.getMessage() + "FAIL";
            System.out.println(e.getMessage());
        }
		
		return result;
	}
	
	// build constructor
	public testDbConnect(String connString, String userName, String Password) {
		super();
		this.connstring = connString;
		this.username = userName;
		this.password = Password;
	}

}
