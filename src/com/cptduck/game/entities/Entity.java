package com.cptduck.game.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {

	/* Integers */
	protected int x, y;
	protected int width, height;
	
	/* Booleans */
	protected boolean visible = true;
	
	public Entity(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.visible = true;
	}
	
	public Entity(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.width = 0;
		this.height = 0;
		this.visible = true;
	}
	
	public int getX() {
		
		return x;
	}
	
	public void setX(int x) {
		
		this.x = x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public void setY(int y) {
		
		this.y = y;
	}
	
	public void setPosition(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public boolean isVisible() {
		
		return visible;
	}
	
	public void setVisible(boolean visible) {
		
		this.visible = visible;
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, width, height);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {}
}
