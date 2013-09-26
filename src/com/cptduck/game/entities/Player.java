package com.cptduck.game.entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {
	
	/** Key Settings */
	
	/* Movement */
	private static final int Forward = Input.KEY_D;
	private static final int Backwards = Input.KEY_A;
	private static final int Upwards = Input.KEY_W;
	private static final int Downwards = Input.KEY_S;
	
	/* Attacking */
	public static final int Attack = Input.KEY_N;
	
	/* Debug Exit */
	private static final int Exit = Input.KEY_ESCAPE;
	
	/** Player Settings */
	private int MOVE_SPEED = 1;
	private int currentHealth;
	
	/* Objects */
	private ArrayList<Bullet> bullets;
	
	public Player(int x, int y) {
		
		super(x, y, 8, 20);
		
		this.currentHealth = 100;
		this.x = x;
		this.y = y;
		bullets = new ArrayList<Bullet>();
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.scale(2, 2);
		g.drawImage(new Image("resources/Entities/player.png"), x, y);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		/**
		 * 
		 * Most of this could do with changing. Maybe we could have a Status bar at the top of screen?
		 * these would need to be altered if so.
		 *
		 */
		
		Input input = gc.getInput();
		
		/** Movement */
		if(input.isKeyDown(Forward)) {
			
			x += MOVE_SPEED;
			
			if(x > 380) {
				
				x -= 2;
			}
		}
		
		if(input.isKeyDown(Backwards)) {
			
			x -= MOVE_SPEED;
			
			if(x < 8) {
				
				x += 1;
			}
		}
		
		if (input.isKeyDown(Upwards)) {
			
			y -= MOVE_SPEED;
		
			if(y < 10) {
				
				y += 2;
			}
		}
		
		if (input.isKeyDown(Downwards)) {
			
			y += MOVE_SPEED;
		
			if(y > 276) {
				
				y -= 2;
			}
		}
		
		/** Attacking */
		if (input.isKeyDown(Attack)) {
			
			attack();
		}
		
		/** Debug Exit */
		if(input.isKeyDown(Exit)) {
			
			sbg.enterState(0);
		}
		
		playerPos();
		manageBullets(gc, sbg, delta);
	}
	
	public void playerPos() {
		
		System.out.println("Player X : " + x + "," + " Player Y : " + y);
	}
	
	public int currentHealth() {
		
		return currentHealth;
	}
	
	public void setcurrentHealth(int currentHealth) {
		
		this.currentHealth = currentHealth;
	}
	
	public void attack() {
		
		bullets.add(new PlayerBullet(x + width + 2, y));
	}
	
	public void manageBullets(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		for (int i = 0; i <bullets.size(); i ++) {
			
			bullets.get(i).update(gc, null, delta);
			
			if (!(bullets.get(i).isVisible())) {
				
				bullets.remove(i);
			}
		}
	}
	
	public ArrayList<Bullet> getBullets() {
		
		return bullets;
	}
}

