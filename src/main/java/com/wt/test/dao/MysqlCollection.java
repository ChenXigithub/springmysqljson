package com.wt.test.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;




public class MysqlCollection {
	public static Connection getDBCollection() throws IOException, ClassNotFoundException, SQLException{

		InputStream in = MysqlCollection.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties p = new Properties();
		p.load(in);
		String host = p.getProperty("host");
		String port = p.getProperty("port");
		String db_name = p.getProperty("db_name");
		String user = p.getProperty("user", null);
		String password = p.getProperty("password", null);
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db_name,user,password);
	}
}
