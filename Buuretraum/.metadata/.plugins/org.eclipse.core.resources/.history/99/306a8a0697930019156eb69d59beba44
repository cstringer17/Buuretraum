package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.TimeZone;

import com.lambdaworks.crypto.SCryptUtil;

import buuretraum.GLOBAL_VARIABLES;
import buuretraum.GameLoop;
import frames.DisplayError;

public class QuerySQL {

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
			DisplayError er = new DisplayError("Connection Failed");
		}

		return r;

	}

	public static String login(String usernameField, String passwordField) {

		String loginq = "select * from player WHERE username='" + usernameField + "'";
		QuerySQL q = new QuerySQL();
		String[] temp = q.queryDB(loginq).split(";");
		String passwordh = removeLastChar(temp[3]);

		try {
			if (SCryptUtil.check(passwordField, passwordh)) {
				System.out.println("login success");
				new GameLoop(temp[0], temp[1]);

			}

		} catch (IllegalArgumentException e2) {
			// invalid hash..
			new DisplayError(e2.getMessage());
		}

		return "";

	}

	private static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

	public void addFarm(String currentUser) {
		// check if 6 farms are already there

		InsertSQL i = new InsertSQL();

		String query = "select * from farm WHERE Player_idPLayer=" + currentUser + ";";
		String[] farmtest = queryDB(query).split("#");
		if (farmtest.length >= 6) {
			DisplayError r = new DisplayError("Max Farms Reached");
		} else {
			frames.AddFarmFrame ei = new frames.AddFarmFrame();
		}

	}

	public void removeFarm(int farmnumber) {
		String query = "select * from farm WHERE Player_idPLayer=" + GLOBAL_VARIABLES.getInstance().currentUser + ";";
		String[] farmtest = queryDB(query).split("#");
		InsertSQL i = new InsertSQL();
		i.removeFarm(farmtest[farmnumber-1]);
		
	}

}