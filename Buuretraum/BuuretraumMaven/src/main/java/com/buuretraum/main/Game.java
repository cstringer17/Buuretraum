package com.buuretraum.main;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ImageCapabilities;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.buuretraum.animations.ColorFlow;
import com.buuretraum.database.query;
import com.buuretraum.sprites.Farm;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Game extends Canvas implements Runnable {

	/**
	 * Variables and Settings
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private String currentUser;
	private boolean initialize;
	private query q;
	
	private int frames;
	
	/**
	 *  Components
	 * 
	 */
	private BufferedImage crossIcon;
	
	private Button addFarm;

	// todo: add something

	ArrayList<Farm> Farms;

	public Game(String currentUser) {
		this.currentUser = currentUser;
		new Window(WIDTH, HEIGHT, "Buuretram  -  " + currentUser, this);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		
		
		/**
		 * Variables and Settings
		 */
		
		initialize = true;
		running = true;
		q = new query();
		Farms = new ArrayList<Farm>();
		
		
		/**
		 *  Components
		 * 
		 */
		try {
			crossIcon = ImageIO.read(new File("media/images/iconCross.jpg"));
		} catch (IOException e) {
			System.out.println("FAILED TO LOAD crossIcon");
			
		}
		
		

		loaddata(currentUser);

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
		/**
		 * Game Loop - NOT MY OWN CODE!
		 */
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		frames = 0;
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
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		//Draw FPS
		g.setColor(Color.yellow);
		g.drawString("" + frames, 10,10);
		System.out.println(frames);
		
		//create sidebar
		
		
		g.setColor(Color.darkGray);
		g.fillRect(750, 0, 274, HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(800, 37, 200, 50);
		g.setColor(Color.black);
		g.drawString("New Farm",800 + 25 , 37 + 15);
		
		//top right exit
		g.drawImage(crossIcon, 1000,0, this);
		
	
		
		
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
			if (counter==3) {
				x = 20;
				y += 250;
			}
		}

		g.dispose();
		bs.show();

	}

	private void loaddata(String currentUser2) {
		this.addMouseListener(new MouseInput());
		// get all farms that belong to current user
		System.out.println("loading...");

		String s = "SELECT * from farm where Player_idPlayer='" + currentUser2 + "'";
		;

		String reply = q.queryDB(s);

		String[] Farm = reply.split("#");

		for (String sx : Farm) {
			String[] insert = null;
			insert = sx.split(";");
			Farms.add(new Farm(Integer.parseInt(insert[0]), Integer.parseInt(insert[1]), insert[2]));
		}

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("testtest");
		}
	}

	public void keyRelease(KeyEvent e) {
		int key = e.getKeyCode();
	}

}
