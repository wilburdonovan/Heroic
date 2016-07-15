package dev.teknikation.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.teknikation.tilegame.Game;
import dev.teknikation.tilegame.gfx.Assets;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y, int width, int height) {
		super(x, y, width, height);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if (game.getKeyManager().up) {
			yMove = -speed;
		}
		if (game.getKeyManager().down) {
			yMove = speed;
		}
		if (game.getKeyManager().right) {
			xMove = speed;
		}
		if (game.getKeyManager().left) {
			xMove = -speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.playerImg, (int) x, (int) y, null);

	}

}
