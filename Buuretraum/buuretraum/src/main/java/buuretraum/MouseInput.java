package buuretraum;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import database.query;
import frames.DropDown;

public class MouseInput implements MouseListener {

	DropDown popup = new DropDown();
	query q = new query();

	public MouseInput() {
		// TODO Auto-generated constructor stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Pressed");
		int mx = e.getX();
		int my = e.getY();

		// check for farms

		if (SwingUtilities.isRightMouseButton(e)) {
			// right click menu
			if (mx > 20 && mx < 20 + 200 && my > 200 && my < 400 || mx > 270 && mx < 270 + 200 && my > 200 && my < 400
					|| mx > 530 && mx < 530 + 200 && my > 200 && my < 400
					|| mx > 20 && mx < 20 + 200 && my > 450 && my < 650
					|| mx > 270 && mx < 270 + 200 && my > 450 && my < 650
					|| mx > 530 && mx < 530 + 200 && my > 450 && my < 650

			) {
				System.out.println("RIGHT");
				popup.menu.show(e.getComponent(), e.getX(), e.getY());
				{
				}
			}

		}
		 /**
		  * FARMS
		  * 
		  * */
		if (mx > 20 && mx < 20 + 200 && my > 200 && my < 400) {
			System.out.println("FARM1");
		}
		if (mx > 270 && mx < 270 + 200 && my > 200 && my < 400) {
			System.out.println("FARM2");
		}
		if (mx > 530 && mx < 530 + 200 && my > 200 && my < 400) {
			System.out.println("FARM3");
		}
		if (mx > 20 && mx < 20 + 200 && my > 450 && my < 650) {
			System.out.println("FARM4");
		}
		if (mx > 270 && mx < 270 + 200 && my > 450 && my < 650) {
			System.out.println("FARM5");
		}
		if (mx > 530 && mx < 530 + 200 && my > 450 && my < 650) {
			System.out.println("FARM6");
		}

		// EXIT BUTTON
		if (mx > 1000 && my < 24) {
			System.exit(0);
		}

		// NEW FARM BUTTON g.fillRect(800, 37, 200, 50);
		if (mx > 800 && mx < 1000 && my > 37 && my < 37 + 50) {
			System.out.println("New Farm");
			q.addFarm(CurrentInformationSingle.getInstance().currentUser);
			
		}

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
