package buuretraum;

public class CurrentInformationSingle {

	private static CurrentInformationSingle single_instance = null;
	
	public String currentUser;
	public int mouseCounter;
	public boolean View ;

	private CurrentInformationSingle() {

	}

	public static CurrentInformationSingle getInstance() {

		if (single_instance == null) {
			single_instance = new CurrentInformationSingle();
		}

		return single_instance;

	}

}
