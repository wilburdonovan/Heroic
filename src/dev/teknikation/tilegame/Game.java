package dev.teknikation.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.teknikation.tilegame.display.Display;
import dev.teknikation.tilegame.gfx.ImageLoader;

public class Game implements Runnable {
	
	private Display display;
	public String title;
	public int width;
	public int height;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	public Game (String title, int width, int height) {
		this.title = title;
		this.height = height;
		this.width = width;
	}
	
	private void init () {
		display = new Display (title, width, height);
	}
	
	private void tick() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); // Graphics object draws stuff to the canvas
		//Clear screen
		g.clearRect(0, 0, width, height);
		
		//Draw Here

		
		//End Drawing
		bs.show(); // does all the buffer magic before sending to canvas
		g.dispose(); // ends graphics objects job properly
	}
	
	public void run () {
		init ();
		
		while (running) {
			tick();
			render();
		}
		
		stop();
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
