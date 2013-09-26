package com.cptduck.game.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {
	
	/* Key Settings */
	private static final int Forward = Input.KEY_D;
	private static final int Backwards = Input.KEY_A;
	private static final int Upwards = Input.KEY_W;
	private static final int Downwards = Input.KEY_S;
	private static final int Exit = Input.KEY_ESCAPE;
	
	/* Player Settings */
	private int MOVE_SPEED = 1;
	private int currentHealth;
	
	public Player(int x, int y) {
		
		super(x, y, 8, 20);
		
		this.currentHealth = 100;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.scale(2, 2);
		g.drawImage(new Image("resources\\player.png"), x, y);
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
		
		if(input.isKeyDown(Exit)) {
			
			sbg.enterState(0);
		}
		
		playerPos();
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
}

