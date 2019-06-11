package buuretraum;

import java.util.Arrays;

import javax.swing.JPasswordField;

import com.lambdaworks.crypto.SCryptUtil;

import database.insert;
import database.query;
import frames.error;

public class Information {
	

	
	private insert i;


	public Information() {
		// TODO Auto-generated constructor stub
		i = new insert();
	}


	
	public void  login(String text, String text2) {
		query.login(text, text2);
		
	}

	public void register(String s, String email, String username, JPasswordField password_1, JPasswordField password_2) {
		if (Arrays.equals(password_1.getPassword(), password_2.getPassword())) {

		} else {
			new error("Passwords do not match");
		}

		String u = username;
		String emailText = email;
		String p = new String(password_1.getPassword());
		System.out.println(p);
		try {
			 s = query.queryDB("select * from player WHERE username='" + u + "'");
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("no record");
		}
		
		if (s.equals("")) {
			// enter user

			String pn = SCryptUtil.scrypt(p, 16, 16, 16);
			String entry = "INSERT INTO player (username,password, email) VALUES ('" + u + "','" + pn
					+ "','" + emailText + " ');";
			System.out.println(entry);
			i.insertData(entry);
		} else {
			new error("Username already exists");
		}
		
		

	}
		
	}

