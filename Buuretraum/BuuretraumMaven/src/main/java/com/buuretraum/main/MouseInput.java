package com.buuretraum.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	public MouseInput() {
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Pressed");
		int mx = e.getX();
		int my = e.getY();
		
		//EXIT BUTTON
		if(mx > 1000 && my < 24) 
		{
			System.exit(0);
		}
		
		//NEW FARM BUTTON g.fillRect(800, 37, 200, 50);
		if(mx > 800 && mx < 1000 && my > 37 && my < 37 + 50) {
			System.out.println("New Farm");
		}
		
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
