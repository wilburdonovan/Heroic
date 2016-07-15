package dev.teknikation.tilegame.tiles;

import dev.teknikation.tilegame.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.rocks, id);

	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
