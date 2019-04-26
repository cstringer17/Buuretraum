package com.buuretraum.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

public class error extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public error(String error) {
		
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ERROR: ");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 35));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		textPane.setText(error);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
