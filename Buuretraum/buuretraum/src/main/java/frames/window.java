package frames;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import buuretraum.CurrentInformationSingle;
import buuretraum.game;

public class window extends Canvas{
	


	public window(int width, int height, String title, game game) {
		
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