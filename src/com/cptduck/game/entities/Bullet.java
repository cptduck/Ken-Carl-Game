package com.cptduck.game.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Bullet extends Entity {

	/* Integers */
	protected int dx;
	protected int damage;
	protected int limit;
	protected boolean inited = false;
	protected Animation bulletAnimation;
	
	public Bullet(int x, int y) {
		
		super(x, y);
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if (!inited) {
			
			this.init(gc, sbg);
			
			inited = true;
		}
	}
	
	public int getDamage() {
		
		return damage;
	}
	
	public Animation getForm() {
		
		return bulletAnimation;
	}
}
