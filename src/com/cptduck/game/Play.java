package com.cptduck.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

	private static int playerX = 10;
	private static int playerY = 10;
	
	public Play(int State) {
		
		State = 1;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.scale(2, 2);
		g.drawImage(new Image("resources\\player.png"), playerX, playerY);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2) throws SlickException {
		
		int Forward = Input.KEY_D;	
		int Backwards = Input.KEY_A;
		int Upwards = Input.KEY_W;
		int Downwards = Input.KEY_S;
		
		Input input = gc.getInput();
		
		if(input.isKeyDown(Forward)) {
			
			playerX += 1;
			
			if(playerX == 302) {
				
				playerX -= 0.1;
			}
		}
		
		if(input.isKeyDown(Backwards)) {
			
			playerX -= 1;
			
			if(playerX == 8) {
				
				playerX += 1;
			}
		}
		
		if (input.isKeyDown(Upwards)) {
			
			playerY -= 1;
					
		}
		
		if (input.isKeyDown(Downwards)) {
			
			playerY += 1;
		
		}
		
		playerPos();
	}
	
	public void playerPos() {
		
		System.out.println("Player X : " + playerX);
		System.out.println("Player Y : " + playerY);
	}

	@Override
	public int getID() {
	
		return 1;
	}

}
