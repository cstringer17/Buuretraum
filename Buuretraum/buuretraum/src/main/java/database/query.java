package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.TimeZone;

import com.lambdaworks.crypto.SCryptUtil;

import buuretraum.game;
import frames.error;

public class query {

	static ResultSet rs;
	static String r;
	

	public static String queryDB(String q) {
		r = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://1337.ex0dus.ch:3306/buuretraum?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone="
					+ TimeZone.getDefault().getID();
			Connection con = DriverManager.getConnection(url, "farmer", "password_400");
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(q);

			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						r += ";";
					String columnValue = rs.getString(i);
					r += columnValue;
				}
				r += "#";
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
			error er = new error("Connection Failed");
		}

		return r;

	}

	public static String login(String usernameField, String passwordField) {

		String loginq = "select * from player WHERE username='" + usernameField + "'";
		query q = new query();
		String[] temp = q.queryDB(loginq).split(";");
		String passwordh = removeLastChar(temp[3]);

		try {
			if (SCryptUtil.check(passwordField, passwordh)) {
				System.out.println("login success");
				new game(temp[0], temp[1]);

			}

		} catch (IllegalArgumentException e2) {
			// invalid hash..
			new error(e2.getMessage());
		}

		return "";

	}

	private static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

	public void addFarm(String currentUser) {
		// check if 6 farms are already there

		insert i = new insert();

		String query = "select * from farm WHERE Player_idPLayer=" + currentUser + ";";
		String[] farmtest = queryDB(query).split("#");
		if (farmtest.length >= 6) {
			error r = new error("Max Farms Reached");
		} else {
			frames.AddFarm ei = new frames.AddFarm();
		}

	}

}