package com.cptduck.game.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class PlayerBullet extends Bullet {

	public PlayerBullet(int x, int y) {
		
		super(x, y);
		
		this.width = 32;
		this.height = 32;
		this.damage = 1;
		
		dx = 10;
		limit = 760;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		/* Import Image */
		Image bulletImage = new Image("resources/Entities/playerBullet.png");
		
		/* Setup Image Animation */
		Image[] bulletImages = {
				
			bulletImage.getSubImage(0, 0, 26, 32),
			bulletImage.getSubImage(42, 0, 40, 32),
			bulletImage.getSubImage(92, 0, 32, 32)
			
		};
		
		bulletAnimation = new Animation(bulletImages, 100, true);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		super.update(gc, sbg, delta);
		
		if (x < limit) {
			
			x += dx;
			
		} else {
			
			visible = false;
		}
	}
}
