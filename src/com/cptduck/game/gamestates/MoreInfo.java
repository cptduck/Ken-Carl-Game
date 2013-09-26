package com.cptduck.game.gamestates;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MoreInfo extends BasicGameState {

	/* Strings */
	public static String MouseDebug = "- No Input";
	public static String DebugSettings = "Debug Settings :";
	
	public MoreInfo(int State) {
		
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame sbg) throws SlickException {}

	@Override
	public void render(GameContainer arg0, StateBasedGame sbg, Graphics g) throws SlickException {
		
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		
		/* Main MoreInfo */
		g.drawString("Help Menu", 365, 8);
		g.drawString("Developers : ", 20, 120);
		g.drawString(". Carl ", 20, 150);
		g.drawString(". Ken", 20, 180);
		
		g.drawString("Built With :", 20, 420);
		g.drawString(". Slick2D", 20, 450);
		g.drawString(". Lwjgl", 20, 480);
		
	    /* Back Button */
		g.drawString("Back", 693, 545);
		g.drawRect(645, 535, 135, 44);
		
		/** Debug Settings */
		g.drawString(DebugSettings, 640, 10);
		
		/* Mouse Debug */
		g.drawString(MouseDebug, 520, 40);
		
		MouseDebug = "Mouse Position X : " + xPos + " Y : " + yPos;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		
		Input input = gc.getInput();
		
		if ((xPos > 645 && xPos < 779) && (yPos > 20 && yPos < 197)) {
			
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				
				sbg.enterState(0);
			}
		}
	}

	@Override
	public int getID() {
		
		return 3;
	}
}
