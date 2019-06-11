package database;

public class loaddata {

	public loaddata() {

	}

	public String load(String currentUser) {

		query q = new query();

		String s = "SELECT * from farm where Player_idPlayer='" + 3 + "'";

		String reply = q.queryDB(s);

		return reply;

	}

}
