package buuretraum;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import database.loaddata;
import database.query;
import frames.DropDown;

public class MouseInput implements MouseListener {

	DropDown popup;
	query q = new query();
	loaddata ld = new loaddata();

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
		if (CurrentInformationSingle.getInstance().View) {
			mousedPressedMenuFrame(mx, my, e);
		}else {
			
		}
		

	}

	private void mousedPressedMenuFrame(int mx, int my, MouseEvent e) {

		CurrentInformationSingle.getInstance().mouseCounter += 1;

		/**
		 * FARMS
		 * 
		 */
		if (mx > 20 && mx < 20 + 200 && my > 200 && my < 400) {
			checkRightClickMenuFrame(e, mx, my, 1);
			doubleClickMenuFrame(1);

		}
		if (mx > 270 && mx < 270 + 200 && my > 200 && my < 400) {
			checkRightClickMenuFrame(e, mx, my, 2);
			doubleClickMenuFrame(2);
		}
		if (mx > 530 && mx < 530 + 200 && my > 200 && my < 400) {
			checkRightClickMenuFrame(e, mx, my, 3);
			doubleClickMenuFrame(3);
		}
		if (mx > 20 && mx < 20 + 200 && my > 450 && my < 650) {
			checkRightClickMenuFrame(e, mx, my, 4);
			doubleClickMenuFrame(4);
		}
		if (mx > 270 && mx < 270 + 200 && my > 450 && my < 650) {
			checkRightClickMenuFrame(e, mx, my, 5);
			doubleClickMenuFrame(5);
		}
		if (mx > 530 && mx < 530 + 200 && my > 450 && my < 650) {
			checkRightClickMenuFrame(e, mx, my, 6);
			doubleClickMenuFrame(6);
		}

		// EXIT BUTTON
		if (mx > 1000 && my < 24) {
			System.exit(0);
		}

		// NEW FARM BUTTON g.fillRect(800, 37, 200, 50);
		if (mx > 800 && mx < 1000 && my > 37 && my < 37 + 50) {
			q.addFarm(CurrentInformationSingle.getInstance().currentUser);
		}

	}

	private void doubleClickMenuFrame(int farm) {

		if (CurrentInformationSingle.getInstance().mouseCounter == 2) {
			CurrentInformationSingle.getInstance().mouseCounter = 0;
			openFarmMenuFrame(farm);
		}

	}

	private void openFarmMenuFrame(int farm) {
		System.out.println(farm);
		String holder = ld.load(CurrentInformationSingle.getInstance().currentUser);

		String[] Farm = holder.split("#");

		for (String sx : Farm) {

			String[] insert = null;
			insert = sx.split(";");
			System.out.println("Farms:   " + Farm.length);
			if (Farm.length >= farm) {
				CurrentInformationSingle.getInstance().View = false;
				System.out.println("Attempting to open farm: " + Farm[farm - 1]);
			}

		}

	}

	public boolean checkRightClickMenuFrame(MouseEvent e, int mx, int my, int farmnumber) {
		if (SwingUtilities.isRightMouseButton(e)) {
			// right click menu
			if (mx > 20 && mx < 20 + 200 && my > 200 && my < 400 || mx > 270 && mx < 270 + 200 && my > 200 && my < 400
					|| mx > 530 && mx < 530 + 200 && my > 200 && my < 400
					|| mx > 20 && mx < 20 + 200 && my > 450 && my < 650
					|| mx > 270 && mx < 270 + 200 && my > 450 && my < 650
					|| mx > 530 && mx < 530 + 200 && my > 450 && my < 650

			) {
				popup = new DropDown(farmnumber);
				popup.menu.show(e.getComponent(), e.getX(), e.getY());
				{
				}
			}

		}

		return false;

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
