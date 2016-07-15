package dev.teknikation.tilegame.states;

import java.awt.Graphics;

import dev.teknikation.tilegame.Game;
import dev.teknikation.tilegame.entities.creatures.Player;
import dev.teknikation.tilegame.tiles.Tile;

public class GameState extends State {

	private Player player;	
	
	public GameState (Game game) {
		super(game);
		player = new Player (game, 0, 0, 150 , 150);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
	
		Tile.tiles[0].render(g, 0, 0);
		Tile.tiles[5].render(g, 0, 64);
		Tile.tiles[2].render(g, 64, 0);
		Tile.tiles[0].render(g, 128, 0);
		
		player.render(g);
	}

}
