package frames;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import java.awt.Color;
import javax.swing.JScrollPane;

public class ControlsMenu extends JFrame {
	/**
	 * Create the frame.
	 */
	public ControlsMenu() {
		
		JEditorPane htmlmarkup = new JEditorPane();
		htmlmarkup.setEditable(false);
		
		HTMLEditorKit htmlkit = new HTMLEditorKit();
		htmlmarkup.setEditorKit(htmlkit);

		StyleSheet styleSheet = htmlkit.getStyleSheet();
		
	


		


		
		styleSheet.addRule("h2 { color: #111; font-family: 'Helvetica Neue', sans-serif; font-size: 30px; font-weight: bold; letter-spacing: -1px; line-height: 1; text-align: center; }h2 { color: #111; font-family: 'Open Sans', sans-serif; font-size: 30px; font-weight: 300; line-height: 32px; margin: 0 0 72px; text-align: center; }");
		styleSheet.addRule("p { color: #685206; font-family: 'Helvetica Neue', sans-serif; font-size: 14px; line-height: 24px; margin: 0 0 24px; text-align: justify; text-justify: inter-word; }");
		getContentPane().setBackground(new Color(153, 204, 255));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(htmlmarkup);
		scrollPane.setBounds(10, 11, 405, 496);
		
		
		Document doc = htmlkit.createDefaultDocument();
		htmlmarkup.setDocument(doc);
		htmlmarkup.setText("<h2>Welcome to the Control Window</h2>\r\n" + 
				"<br>\r\n" + 
				"<p>Press a number to select your plot (1-8)</p>\r\n" + 
				"<br>\r\n" + 
				"<p>Press 'C' to create a new Plot</p>\r\n" + 
				"<br>\r\n" + 
				"<p>Press 'Shift' + 'Plot Number' to delete a plot</p>");
		
		getContentPane().add(scrollPane);
		setTitle("Controls ");
		setForeground(new Color(153, 204, 204));
		setBounds(100, 100, 425, 518);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		
		
		

	}
}
