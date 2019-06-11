package buuretraum;

import frames.error;
import frames.menuframe;

public class Starter {
	
	private error r;

	public Starter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			 menuframe m = new menuframe();
		} catch (Exception e) {
			new error(e.getMessage());
		}
		
	}}

