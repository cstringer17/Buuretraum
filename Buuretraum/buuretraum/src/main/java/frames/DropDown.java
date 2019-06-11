package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import buuretraum.Information;

public class DropDown {
	
	public Information info;
	public JPopupMenu menu;

	public DropDown() {
		
		menu = new JPopupMenu();
		info = new Information();
		
		JMenuItem one = new JMenuItem("Delete");
	
		
		menu.add(one);
		
//		one.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				
//				info.removeFarm(String user, String farm);
//				
//			}
//		});
//
		
	}

}
