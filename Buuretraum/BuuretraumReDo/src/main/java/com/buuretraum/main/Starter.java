package com.buuretraum.main;

import com.buuretraum.frames.error;
import com.buuretraum.frames.menuFrame;

public class Starter {
	
	private error r;

	public Starter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			 menuFrame m = new menuFrame();
		} catch (Exception e) {
			new error(e.getMessage());
		}
		
	}

}
