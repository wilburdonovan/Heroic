package dev.teknikation.tilegame.states;

import java.awt.Graphics;
import dev.teknikation.tilegame.Game;

public abstract class State {

	
	
	// Game State Manager
	private static State currentState = null;
	
	public static void setState (State state) {
		currentState = state;
	}
	
	public static State getState () {
		return currentState;
	}
	
	
	// Class
	protected Game game;
	
	public State (Game game) {
		this.game = game;
	}
	
	public abstract void tick ();
	
	public abstract void render (Graphics g);
}
