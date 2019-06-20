package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class ControlsMenu extends JFrame {
	/**
	 * Create the frame.
	 */
	public ControlsMenu() {
		getContentPane().setBackground(new Color(153, 204, 255));
		setTitle("Controls ");
		setForeground(new Color(153, 204, 204));
		setBounds(100, 100, 425, 518);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);

	}

}
