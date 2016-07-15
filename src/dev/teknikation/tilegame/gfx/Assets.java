package dev.teknikation.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int tileWidth = 64;
	
	public static BufferedImage goldCoin, silverCoin, bronzeCoin, playerImg;
	public static BufferedImage grassTrap, rocks, treeApple, treeOak;
	public static BufferedImage[] grass;
	
	public static void init () {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/KenneyAnimatedCoinsV2.png"));
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet ground = new SpriteSheet(ImageLoader.loadImage("/textures/ground_tiles.png"));
		
		// Coin textures
		goldCoin = sheet.crop(85, 125, 20, 20);
		silverCoin = sheet.crop(85, 97, 20, 20);
		bronzeCoin = sheet.crop(85, 62, 20, 20);
		
		// Player textures
		playerImg = player.crop(30, 40, 68, 53);
		
		// Ground textures
		grass = new BufferedImage[4];
		grass[0] = ground.crop(64, 0, tileWidth, tileWidth);
		grass[1] = ground.crop(128, 0, tileWidth, tileWidth);
		grass[2] = ground.crop(192, 0, tileWidth, tileWidth);
		grass[3] = ground.crop(256, 0, tileWidth, tileWidth);
		
		rocks = ground.crop(0, 64, tileWidth, tileWidth);
		treeApple = ground.crop(64, 64, tileWidth, tileWidth);
		treeOak = ground.crop(128, 64, tileWidth, tileWidth);
		grassTrap = ground.crop(320, 0, tileWidth, tileWidth);
	}
	
}
