package testing;

import buuretraum.GLOBAL_VARIABLES;
import database.QuerySQL;
import frames.ControlsMenu;

public class testing {

	public testing() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DisplayAllFarmDataTest object = new DisplayAllFarmDataTest();
		GLOBAL_VARIABLES.getInstance().farm = "18";
		object.loadfarms();
	}

}
