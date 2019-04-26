package com.buuretraum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert {

	public String insertData(String q) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buuretraum?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();

			stmt.executeUpdate(q);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "Inserted Records into Table";

	}

}
