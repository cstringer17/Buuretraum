package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import buuretraum.Information;
import database.QuerySQL;

public class DropDownObject {
	
	public Information info;
	public JPopupMenu menu;
	public int farmNumber;

	public DropDownObject(final int farmNumber) {
		this.farmNumber = farmNumber;
		menu = new JPopupMenu();
		info = new Information();
		
		JMenuItem one = new JMenuItem("Delete");
	
		
		menu.add(one);
		
		one.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				QuerySQL q = new QuerySQL();
				q.removeFarm(farmNumber);
				
			}
		});

		
	}

}
