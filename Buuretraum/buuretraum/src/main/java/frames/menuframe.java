package frames;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.lambdaworks.crypto.SCryptUtil;

import buuretraum.Information;
import buuretraum.game;
import buuretraum.password;
import database.insert;
import database.query;

public class menuframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JTextField passwordField;
	private query q;
	private password h;
	private insert i;
	private error r;
	private Information info;
	String loginq;

	/**
	 * Create the panel.
	 */
	public menuframe() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		setSize(450, 350);
		setLocationRelativeTo(null);

		info = new Information();

		q = new query();
		i = new insert();

		JLabel lblNewLabel = new JLabel("D' Buuretraum");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(111, 11, 213, 58);
		getContentPane().add(lblNewLabel);

		/**
		 * 
		 * REGISTER
		 * 
		 */

		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				registerframe f = new registerframe();

			}
		});

		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnNewButton.setBounds(111, 199, 202, 23);
		getContentPane().add(btnNewButton);

		/**
		 * 
		 * LOGIN
		 * 
		 */

		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				info.login(usernameField.getText(), passwordField.getText());
				setVisible(false);

			}
		});
		button.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		button.setBounds(111, 160, 202, 23);
		getContentPane().add(button);

		usernameField = new JTextField();
		usernameField.setBounds(169, 98, 144, 20);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(108, 101, 58, 14);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(111, 129, 73, 14);
		getContentPane().add(lblPassword);

		passwordField = new JTextField();
		passwordField.setBounds(169, 129, 144, 20);
		getContentPane().add(passwordField);

		setVisible(true);

	}

}