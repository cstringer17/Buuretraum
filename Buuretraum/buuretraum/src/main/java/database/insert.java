package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.TimeZone;



public class insert {

	public String insertData(String q) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://1337.ex0dus.ch:3306/buuretraum?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=" + TimeZone.getDefault().getID();
			Connection con = DriverManager.getConnection(url, "farmer", "password_400");

			Statement stmt = con.createStatement();

			stmt.executeUpdate(q);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "Inserted Records into Table";

	}

}
