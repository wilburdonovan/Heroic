package dev.teknikation.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.teknikation.tilegame.Game;
import dev.teknikation.tilegame.gfx.Assets;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		if (game.getKeyManager().up) {
			y -= 5;
		}
		if (game.getKeyManager().down) {
			y += 5;
		}
		if (game.getKeyManager().right) {
			x += 5;
		}
		if (game.getKeyManager().left) {
			x -= 5;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);

	}

}
