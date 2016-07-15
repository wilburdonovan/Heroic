package dev.teknikation.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	// STATIC VARIABLES
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile0 = new GrassTile0(0);
	public static Tile grassTile1 = new GrassTile1(1);
	public static Tile grassTile2 = new GrassTile2(2);
	public static Tile grassTile3 = new GrassTile3(3);
	public static Tile rockTile = new RockTile(4); 
	public static Tile appleTreeTile = new AppleTreeTile(5);
	public static Tile oakTreeTile = new OakTreeTile(6);
	
	// CLASS
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}

	public void tick () {
		
	}
	
	public void render (Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	
}
