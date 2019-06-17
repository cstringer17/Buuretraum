package buuretraum;

import frames.DisplayError;
import frames.MenuFrame;

public class Starter {
	
	private DisplayError r;

	public Starter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			 MenuFrame m = new MenuFrame();
		} catch (Exception e) {
			new DisplayError(e.getMessage());
		}
		
	}}

