package buuretraum;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import database.LoadDataSQL;

import javax.imageio.ImageIO;
import database.QuerySQL;
import frames.WindowObject;

public class GameLoop extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;

	private String currentUser;
	private LoadDataSQL ld;
	private QuerySQL q;
	private MouseInput mouse;
	private MouseMotion mouseMotion;
	private ArrayList<String> plots;

	Image image;
	Image test;
	Image background;

	// todo: add something

	ArrayList<FarmClass> Farms;

	public GameLoop(String currentUser, String username) {
		this.currentUser = currentUser;
		new WindowObject(WIDTH, HEIGHT, "Buuretram  -  " + currentUser, this);
	}

	public synchronized void start() {

		image = Toolkit.getDefaultToolkit().getImage("Artwork/originalFarmHouse.jpg");
		test = Toolkit.getDefaultToolkit().getImage("Artwork/barley3.png");
		background = Toolkit.getDefaultToolkit().getImage("Artwork/backgroundfarm.png");
		Farms = new ArrayList<FarmClass>();
		 plots = new ArrayList<String>();

		loaddata(currentUser);
		GLOBAL_VARIABLES.getInstance().View = true;
		/**
		 * Save Current User to Singleton File
		 */
		GLOBAL_VARIABLES.getInstance().currentUser = currentUser;

		thread = new Thread(this);
		thread.start();
		GLOBAL_VARIABLES.getInstance().View = true;

		running = true;
		q = new QuerySQL();

		mouse = new MouseInput();
		mouseMotion = new MouseMotion();
		KeyInputs key = new KeyInputs();
		this.addMouseMotionListener(mouseMotion);
		this.addMouseListener(mouse);
		this.addKeyListener(key);
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			System.out.println("Stopped");
		} catch (Exception e) {
			e.printStackTrace();
		}
		;

	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				if (GLOBAL_VARIABLES.getInstance().View) {
					renderMenu();

				} else {
					renderFarm();
				}

			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);

				if (GLOBAL_VARIABLES.getInstance().View) {
					loaddata(currentUser);

				} else {
					loadfarms(GLOBAL_VARIABLES.getInstance().farm);
				}

				GLOBAL_VARIABLES.getInstance().mouseCounter = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {

		if (!GLOBAL_VARIABLES.getInstance().View) {
		}

	}

	private void renderMenu() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// Title
		Font orgFont = g.getFont();
		g.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		g.setColor(Color.red);
		g.drawString("Buuretraum", 20, 100);

		g.setFont(orgFont);

		// create sidebar

		g.setColor(Color.darkGray);
		g.fillRect(750, 0, 274, HEIGHT);

		g.setColor(Color.red);
		g.fillRect(800, 37, 200, 50);
		g.setColor(Color.black);
		g.drawString("New Farm", 800 + 25, 37 + 15);

		// top right exit

		// paint farms
		int counter = 0;
		int x = 20;
		int y = 200;
		Polygon p = new Polygon();
		for (FarmClass farm : Farms) {

			g.drawImage(image, x, y, null);

			g.setColor(Color.decode("#9ac68d"));

			g.setColor(Color.black);

			g.drawString(farm.getName(), x + 20, y + 20);

			x += 250;
			counter++;
			if (counter == 3) {
				x = 20;
				y += 250;
			}
		}

		g.dispose();
		bs.show();

	}

	private void renderFarm() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}

		
		
		Graphics g = bs.getDrawGraphics();
		
		
		
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(background, 0, 0, null);
		g.setColor(Color.RED);
		g.fillRect(30, 900, 40, 40);

		int counter = 0;
		int x = 260;
		int y = 20;
		
		for (String plot : plots) {

			System.out.println(plot);
			String[] info = plot.split(";");
			
			g.drawImage(test, x, y, null);

			g.setColor(Color.decode("#9ac68d"));

			g.setColor(Color.black);

			

			x += 125;
			counter++;
			if (counter == 4) {
				x = 260;
				y += 125;
				counter = 0;
			}
		}
		
		g.dispose();
		bs.show();

	}

	private void loaddata(String currentUser2) {
		// get all farms that belong to current user
		ld = new LoadDataSQL();

		Farms.clear();

		String holder = ld.load(currentUser2);

		if (holder.equals("")) {
			return;
		}

		String[] Farm = holder.split("#");

		for (String sx : Farm) {

			String[] insert = null;
			insert = sx.split(";");
			Farms.add(new FarmClass(Integer.parseInt(insert[0]), Integer.parseInt(insert[1]), insert[2]));
		}

	}

	private void loadfarms(String farm) {
		ld = new LoadDataSQL();
		/**
		 * DATA: (idPLantPLot,IDFARM, PLANTID)
		 */
		String data = ld.loadFarm(GLOBAL_VARIABLES.getInstance().farm);
		if (data.equals("")) {
			return;
		} else {
			// Split into Plots
			String[] stepone = data.split("#");

			//plots.clear();

			if (data.equals("")) {
				return;
			} else {
				// Create Arrays containing plot information and add it to array list
				/**
				 * 0:idPlantPlot 1:Farm_idFarm 2:Plant_idPlant
				 */
				for (String string : stepone) {
					String[] holder = string.split(";");

					String entryToAdd = "";
					for (String strings : holder) {
						entryToAdd += strings;
						entryToAdd += ";";

					}
					entryToAdd += getPlantInfo(holder[2]);

					plots.add(entryToAdd);
					System.out.println(entryToAdd);
				}

			}
		}

	}

	private String getPlantInfo(String plantID) {

		ld = new LoadDataSQL();
		String plantInfo = ld.loadPlant(plantID);

		return plantInfo;

	}
}