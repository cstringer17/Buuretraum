package com.buuretraum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.TimeZone;

import com.buuretraum.frames.error;

public class query {

	ResultSet rs;
	String r;

	public String queryDB(String q) {
		r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://1337.ex0dus.ch:3306/buuretraum?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=" + TimeZone.getDefault().getID();
			Connection con = DriverManager.getConnection(url, "farmer", "password_400");
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(q);

			ResultSetMetaData rsmd = rs.getMetaData();
		
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						r+=";";
					String columnValue = rs.getString(i);
					r+=columnValue;
				}
				r+="#";
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
			error er = new error("Connection Failed");
		}

		return r;

	}

}
