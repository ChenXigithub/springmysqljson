package com.wt.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FindJsonDao {
	public String getJsonById(String id)
	{
		String json=null;
		Connection con;
		ResultSet res;
		Statement sta;
		if(id==null)
			return null;
		try {
			con=MysqlCollection.getDBCollection();
			sta=con.createStatement();
			res=sta.executeQuery("select json from jsontest where id="+id);
			if(res.next())
			{
				json=res.getString(1);
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
		}
		return json;
	}

}
