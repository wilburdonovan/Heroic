package dev.teknikation.tilegame.states;

import java.awt.Graphics;

import dev.teknikation.tilegame.gfx.Assets;

public class GameState extends State {

	public GameState () {
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.silverCoin, 0, 0, null);
	}

}
