package dev.teknikation.tilegame.states;

import java.awt.Graphics;

import dev.teknikation.tilegame.Game;
import dev.teknikation.tilegame.entities.creatures.Player;
import dev.teknikation.tilegame.tiles.Tile;
import dev.teknikation.tilegame.worlds.World;

public class GameState extends State {

	private Player player;	
	private World world;
	
	public GameState (Game game) {
		super(game);
		player = new Player (game, 0, 0, 150 , 150);
		world = new World ("res/worlds/world1.txt");
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
