package testing;

import database.query;

public class testing {

	public testing() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		query q = new query();
		
		String s = "SELECT * from farm where Player_idPlayer='" + 3 + "'";
		

		String reply = q.queryDB(s);
		
		
		System.out.println(reply);

	}

}
