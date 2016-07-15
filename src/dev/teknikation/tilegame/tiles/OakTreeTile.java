package dev.teknikation.tilegame.tiles;

import dev.teknikation.tilegame.gfx.Assets;

public class OakTreeTile extends Tile {

	public OakTreeTile(int id) {
		super(Assets.treeOak, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
