package dev.teknikation.tilegame.entities;

import java.awt.Graphics;

public abstract class Entity {
	
	public static final int TILE_WIDTH = 50;
	public static final int TILE_HEIGHT = 50;
	
	
	protected float x, y;
	protected int height, width;
	
	public Entity (float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	public abstract void tick();
	
	public abstract void render(Graphics g);


	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
}
