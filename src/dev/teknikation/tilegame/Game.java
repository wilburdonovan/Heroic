package dev.teknikation.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.teknikation.tilegame.display.Display;
import dev.teknikation.tilegame.gfx.Assets;
import dev.teknikation.tilegame.gfx.ImageLoader;
import dev.teknikation.tilegame.gfx.SpriteSheet;
import dev.teknikation.tilegame.states.GameState;
import dev.teknikation.tilegame.states.State;

public class Game implements Runnable {
	
	private Display display;
	public String title;
	public int width;
	public int height;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	private State gameState;
	

	public Game (String title, int width, int height) {
		this.title = title;
		this.height = height;
		this.width = width;
	}
	
	private void init () {
		display = new Display (title, width, height);
		Assets.init();
		
		gameState = new GameState ();
		State.setState(gameState);
	}
	
	private void tick() {
		if (State.getState() != null) {
			State.getState().tick();
		}
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
		if (State.getState() != null) {
			State.getState().render(g);
		}
		
		//End Drawing
		bs.show(); // does all the buffer magic before sending to canvas
		g.dispose(); // ends graphics objects job properly
	}
	
	public void run () {
		init ();
		
		int fps = 60; //Number of frames you waant per second
		double timePerTick = 1000000000 / fps; //Maximum amount of time in nanosecs to execute tick and render
		double delta = 0; //Amount of time we have before we have to call tick and render again 
		long now; //Current time of computer in nanoseconds
		long lastTime = System.nanoTime(); //The last time tick and render were called
		long timer = 0; //Counts the time until one second
		int ticks = 0; //Number of times the tick and render methods are called
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta --;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Frames per second: " + ticks);
				timer = 0;
				ticks = 0;
			}
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
