package com.buuretraum.animations;

import java.awt.Color;

public class ColorFlow {

	private String start;
	private String end;

	private Color c;
	
	public ColorFlow(String start, String end) {
		this.start = start;
		this.end = end;
		this.c = Color.decode(start);
	}

	public Color getColor() {
		return c;
	}

	public void updateColor() {
		if(end.equals(toHexString(c))) {
			System.out.println("ENDDD");
			c = Color.decode(end);
		}else {
		//c = Color.decode(toHexString(c) + 000001); 
		int value = Integer.parseInt(toHexString(c), 16);
		value++;
		c = Color.decode(Integer.toHexString(value));
		}
		
	}

	public int getDecimal(String hex) {
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		int val = 0;
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	public String getHex(int decimal) {
		return  Integer.toHexString(decimal);
	}

	
	public final static String toHexString(Color colour) throws NullPointerException {
		  String hexColour = Integer.toHexString(colour.getRGB() & 0xffffff);
		  if (hexColour.length() < 6) {
		    hexColour = "000000".substring(0, 6 - hexColour.length()) + hexColour;
		  }
		  return "#" + hexColour;
		}
}
