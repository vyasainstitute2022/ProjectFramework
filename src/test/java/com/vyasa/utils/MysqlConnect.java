package com.vyasa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vyasa.tests.TestBase;

public class MysqlConnect {

	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	private  String dbUrl = TestBase.prop.getProperty("dbUrl");
	private  String username = TestBase.prop.getProperty("username");
	private  String password = TestBase.prop.getProperty("password");
	
	public ResultSet triggerquery(String query) throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,username,password);
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery(query);
		return rs;
	}
	
}

