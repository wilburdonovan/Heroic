package dev.teknikation.tilegame.tiles;

import dev.teknikation.tilegame.gfx.Assets;

public class AppleTreeTile extends Tile {

	public AppleTreeTile(int id) {
		super(Assets.treeApple, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
