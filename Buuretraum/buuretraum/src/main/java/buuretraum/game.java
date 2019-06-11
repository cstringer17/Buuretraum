package buuretraum;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import database.loaddata;

import javax.imageio.ImageIO;
import database.query;
import frames.window;

public class game extends Canvas implements Runnable {

	/**
	 * Variables and Settings
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;

	private String currentUser;
	private loaddata ld;

	private query q;
	private MouseInput mouse;
	private MouseMotion mouseMotion;
	/**
	 * Components
	 * 
	 */
	private BufferedImage crossIcon;

	// todo: add something

	ArrayList<Farm> Farms;

	public game(String currentUser, String username) {
		this.currentUser = currentUser;
		new window(WIDTH, HEIGHT, "Buuretram  -  " + currentUser, this);
	}

	public synchronized void start() {
		Farms = new ArrayList<Farm>();
		loaddata(currentUser);
		thread = new Thread(this);
		thread.start();

		/**
		 * Variables and Settings
		 */

		running = true;
		q = new query();

		/**
		 * Components
		 * 
		 */
		try {
			crossIcon = ImageIO.read(new File("media/images/iconCross.jpg"));
		} catch (IOException e) {
			System.out.println("FAILED TO LOAD crossIcon");

		}
		mouse = new MouseInput();
		mouseMotion = new MouseMotion();
		this.addMouseMotionListener(mouseMotion);
		this.addMouseListener(mouse);

	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
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
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				loaddata(currentUser);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(1);
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
		// g.drawImage(crossIcon, 1000, 0, this);

		// paint farms
		int counter = 0;
		int x = 20;
		int y = 200;
		Polygon p = new Polygon();
		for (Farm farm : Farms) {
			p.reset();
			p.addPoint(x, y);
			p.addPoint(x + 200, y);
			p.addPoint(x + 200, y + 200);
			p.addPoint(x, y + 200);

			g.setColor(Color.decode("#9ac68d"));
			g.fillPolygon(p);

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

	private void loaddata(String currentUser2) {
		// get all farms that belong to current user
		ld = new loaddata();

		Farms.clear();

		String[] Farm = ld.load(currentUser2).split("#");

		for (String sx : Farm) {
			String[] insert = null;
			insert = sx.split(";");
			Farms.add(new Farm(Integer.parseInt(insert[0]), Integer.parseInt(insert[1]), insert[2]));
		}

	}

}