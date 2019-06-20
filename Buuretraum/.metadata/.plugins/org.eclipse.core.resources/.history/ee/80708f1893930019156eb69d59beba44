package frames;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import buuretraum.GLOBAL_VARIABLES;
import buuretraum.GameLoop;

public class WindowObject extends Canvas{
	


	public WindowObject(int width, int height, String title, GameLoop game) {
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setUndecorated(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
	
		
		game.start();
	}
	

	
	
}