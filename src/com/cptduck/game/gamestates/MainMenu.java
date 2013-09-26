package com.cptduck.game.gamestates;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {
	
	/* Strings */
	public static String MouseDebug = "- No Input";
	public static String DebugSettings = "Debug Settings :";
	
	public MainMenu(int State) {
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException {
		
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		
		/** 
		 * 
		 *  Better Graphics needed. Maybe...
		 * 
		 */
		
		/* Image Drawing */
		/* g.drawImage(new Image("resources\\menu-background.png"), 0, 0); */ /** Size is too small */
		
		/** Buttons */
		
		/* Start */
		g.drawRect(323, 147, 135, 44);
		
		/* Help */
		g.drawRect(323, 246, 135, 44);
		
		/* Quit */
		g.drawRect(323, 345, 135, 44);
		
		/* More Info */
		g.drawRect(25, 548, 128, 44);
		
		
		/** Temporary Main Menu */
		g.drawString("Flowers of Glory", 320, 100);
		g.drawString("Start", 370, 160);
		g.drawString("Help", 370, 260);
		g.drawString("Quit", 370, 360);
		g.drawString("More Info", 48, 558);
		
		/** Debug Settings */
		g.drawString(DebugSettings, 640, 10);
		
		/* Mouse Debug */
		g.drawString(MouseDebug, 520, 40);
		
		MouseDebug = "Mouse Position X : " + xPos + " Y : " + yPos;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		Input input = gc.getInput();
	
		/* Play */
		if ((posX > 323 && posX < 456) && (posY > 411 && posY < 451)) {
			
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				
				sbg.enterState(1);
			}
		}
		
		/* Help */
		if ((posX > 323 && posX < 456) && (posY > 310 && posY < 352)) {
			
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				
				sbg.enterState(2);
			}
		}
		
		/* Quit */
		if ((posX > 323 && posX < 456) && (posY > 210 && posY < 256)) {
			
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				
				System.exit(0);
			}
		}
		
		/* More Info */
		if ((posX > 25 && posY < 52) && (posY > 8 && posY < 50)) {
			
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				
				sbg.enterState(3);
			}
		}
	}

	@Override
	public int getID() {
		
		return 0;
	}
}
