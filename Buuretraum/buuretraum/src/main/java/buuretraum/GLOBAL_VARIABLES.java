package buuretraum;

public class GLOBAL_VARIABLES {

	private static GLOBAL_VARIABLES single_instance = null;
	
	public String currentUser;
	public int mouseCounter;
	public String farm;
	public boolean View ;

	private GLOBAL_VARIABLES() {

	}

	public static GLOBAL_VARIABLES getInstance() {

		if (single_instance == null) {
			single_instance = new GLOBAL_VARIABLES();
		}

		return single_instance;

	}

}
