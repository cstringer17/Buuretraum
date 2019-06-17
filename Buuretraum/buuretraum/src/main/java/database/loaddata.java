package database;

public class loaddata {

	public loaddata() {

	}

	public String load(String currentUser) {

		String s = "SELECT * from farm where Player_idPlayer='" + currentUser + "'";

		String reply = query.queryDB(s);

		return reply;

	}

}
