package com.cptduck.game.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.cptduck.game.entities.*;

public class Play extends BasicGameState {

	/** Integers */
	
	/* Player Object */
	private Player player;
	
	public Play(int State) {
		
		State = 1;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		player = new Player(8, 20);
		
		player.setcurrentHealth(100);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		player.render(gc, sbg, g);
		
		/** 
		 * 
		 * Scale Needs Fixing, Rendering Text and Image scaled together, being stupid. Needs Fixing
		 */
		g.drawString("Health :", 280, 8);
		g.drawString(Integer.toString(player.currentHealth()), 360, 8);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		player.update(gc, sbg);
	}

	@Override
	public int getID() {
	
		return 1;
	}
}
