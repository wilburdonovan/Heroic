package dev.teknikation.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage goldCoin, silverCoin, bronzeCoin, player;
	
	public static void init () {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/KenneyAnimatedCoinsV2.png"));
		
		goldCoin = sheet.crop(85, 125, 20, 20);
		silverCoin = sheet.crop(85, 97, 20, 20);
		bronzeCoin = sheet.crop(85, 62, 20, 20);
		player = ImageLoader.loadImage("/textures/player.png");
	}
	
}
