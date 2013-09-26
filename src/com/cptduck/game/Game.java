package com.cptduck.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.cptduck.game.gamestates.HelpMenu;
import com.cptduck.game.gamestates.MainMenu;
import com.cptduck.game.gamestates.MoreInfo;
import com.cptduck.game.gamestates.Play;

public class Game extends StateBasedGame {
	
	/* Strings */
	public static String GAME_TITLE = "Flowers of Glory";

	
	/* Integers */
	public static int Main_Menu = 0;
	public static int Play_game = 1;
	public static int Help_Menu = 2;
	public static int More_Info = 3;
	
	public Game(String title) {
		
		super(title);
		
		/* Game States */
		this.addState(new MainMenu(Main_Menu));
		this.addState(new Play(Play_game));
		this.addState(new HelpMenu(Help_Menu));
		this.addState(new MoreInfo(More_Info));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		/* Gather States */
		this.getState(Main_Menu).init(gc, this);
		
		/* Enter State */
		this.enterState(Main_Menu);
	}
	
	public static void main(String[] args) {
		
		AppGameContainer appgc;
	
		try {
			
			appgc = new AppGameContainer(new Game(GAME_TITLE));
			
			appgc.setDisplayMode(800, 600, false);
			
			appgc.start();
			
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
	}
}
