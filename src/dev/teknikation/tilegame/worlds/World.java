package dev.teknikation.tilegame.worlds;

import java.awt.Graphics;

import dev.teknikation.tilegame.tiles.Tile;
import dev.teknikation.tilegame.utils.Utils;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World (String path) {
		loadWorld(path);
	}
	
	public void loadWorld (String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int [width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public void tick () {
		
	}
	
	public Tile getTile (int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.grassTile1;
		}
		return t;
	}
	
	public void render (Graphics g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
	}
}
