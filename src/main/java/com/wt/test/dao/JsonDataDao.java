package com.wt.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

public class JsonDataDao {

	public String saveData(String json) {
		Connection con = null;
		Statement sta = null;
		String id = null;
		try {
			con = MysqlCollection.getDBCollection();
			JSONObject jsono = null;
			try {
				jsono = new JSONObject(json);
				try {
					sta= con.createStatement();
					sta.executeUpdate("insert into jsontest (json) values (\""
							+ jsono.toString().replace("\\", "\\\\").replace("\'", "\\\'").replace("\"", "\\\"") + "\")");
					ResultSet res = sta.executeQuery("select id from jsontest where json=\""
							+ jsono.toString().replace("\\", "\\\\").replace("\'", "\\\'").replace("\"", "\\\"")
							+ "\" order by id desc limit 1");
					if (res.next()) {
						return res.getString(1);
					}
					else
					{
						id="无对应id";
					}
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
					id= "存取数据失败";
				}finally{
					sta.close();
				}
			} catch (Exception e) {
				id = "json格式错误";
			}
		} catch (ClassNotFoundException | IOException | SQLException e1) {
			id = "连接数据库失败";
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			}
		}

		return id;
	}
}
