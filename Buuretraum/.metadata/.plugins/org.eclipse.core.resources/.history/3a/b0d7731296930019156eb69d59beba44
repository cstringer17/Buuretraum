package frames;

import javax.swing.JFrame;
import javax.swing.JTextField;

import buuretraum.GLOBAL_VARIABLES;
import database.InsertSQL;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddFarmFrame {

	private JFrame frame;
	private JTextField textField;
	private InsertSQL i;

	
	/**
	 * Create the application.
	 */
	public AddFarmFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		i = new InsertSQL();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 168);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(10, 39, 306, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText("Enter the new farm name");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 11, 306, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(10, 85, 306, 23);
		frame.getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				i.addFarm(GLOBAL_VARIABLES.getInstance().currentUser, textField.getText());
			}
		});
		
		frame.setVisible(true);
	}
}
