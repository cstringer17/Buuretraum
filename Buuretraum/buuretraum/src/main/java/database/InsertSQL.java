package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.TimeZone;



public class InsertSQL {

	public String insertData(String q) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/buuretraum?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=" + TimeZone.getDefault().getID();
			Connection con = DriverManager.getConnection(url, "root", "");

			Statement stmt = con.createStatement();

			stmt.executeUpdate(q);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "Inserted Records into Table";

	}

	public void addFarm(String currentUser, String name) {
		String insertQuery = "INSERT INTO farm (Player_idPLayer, Name) VALUES ( '"+ currentUser + "','" + name + "');" ;
		insertData(insertQuery);
	}

	public void removeFarm(String farmtest) {
		String[] info = farmtest.split(";");
		String deleteQuery = "DELETE FROM farm WHERE idFarm=" + info[0] + ";";
		insertData(deleteQuery);
	}

}
