package com.buuretraum.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.buuretraum.database.insert;
import com.buuretraum.database.query;
import com.lambdaworks.crypto.SCryptUtil;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField email;
	private JPasswordField password_1;
	private JPasswordField password_2;
	private JLabel lblNewLabel;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblRepeatPassword;
	private query q;
	private insert i;
	private String s;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		s="";
		i = new insert();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);

		JLabel lblRegisterForDbuuretraum = new JLabel("Register for D'Buuretraum");
		lblRegisterForDbuuretraum.setBounds(0, 5, 424, 34);
		lblRegisterForDbuuretraum.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 28));
		lblRegisterForDbuuretraum.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRegisterForDbuuretraum);

		username = new JTextField();
		username.setBounds(148, 50, 276, 26);
		contentPane.add(username);
		username.setColumns(10);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(148, 87, 276, 26);
		contentPane.add(email);

		password_1 = new JPasswordField();
		password_1.setEchoChar('∞');
		password_1.setColumns(10);
		password_1.setBounds(148, 124, 276, 26);
		contentPane.add(password_1);

		password_2 = new JPasswordField();
		password_2.setEchoChar('∞');
		password_2.setColumns(10);
		password_2.setBounds(198, 161, 226, 26);
		contentPane.add(password_2);

		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (Arrays.equals(password_1.getPassword(), password_2.getPassword())) {

				} else {
					new error("Passwords do not match");
				}

				String u = username.getText();
				String emailText = email.getText();
				String p = new String(password_1.getPassword());
				System.out.println(p);
				try {
					 s = q.queryDB("select * from player WHERE username='" + u + "'");
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
				
				setVisible(false);

			}
		});
		register.setBounds(56, 216, 316, 34);
		contentPane.add(register);

		lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblNewLabel.setBounds(21, 50, 117, 26);
		contentPane.add(lblNewLabel);

		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblEmail.setBounds(21, 87, 117, 26);
		contentPane.add(lblEmail);

		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblPassword.setBounds(21, 124, 117, 26);
		contentPane.add(lblPassword);

		lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepeatPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblRepeatPassword.setBounds(21, 161, 167, 26);
		contentPane.add(lblRepeatPassword);
	}
}
