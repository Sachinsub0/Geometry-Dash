package main;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Objects.*;
import Objects.Object;

public class GamePanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (int i = 0; i < Game.block.size(); i++) {
			Game.block.get(i).draw(g);
		}
		
		for (int i = 0; i < Game.spike.size(); i++) {
			Game.spike.get(i).draw(g);
		}
		Game.spr.draw(g);
		Game.portal.draw(g);
		if (winningCollision() || Game.portal.getSizeX() <= Game.spr.getSizeX()) {
			g.setColor(Color.RED);
			g.drawString("You have completed Geometry dash!", 300,300);
		}
		/*if (collision) {
			Game.block.get(0).setSizeX(0);
			Game.spike.get(0).setSizeX(500);
		}
		*/
		
	}	
	public void shiftBlockLeft() {
		for (int i = 0; i < Game.block.size(); i++) {
			Game.block.get(i).update();
		}
		for (int i = 0; i < Game.spike.size(); i++) {
			Game.spike.get(i).update();
		}
		Game.portal.update();
	}
	public boolean detectCollision() {
		for (int i = 0; i < Game.spike.size(); i++) {
		 if ( Game.spr.getSizeX() <  Game.spike.get(i).getSizeX() +  Game.spike.get(i).getWidth() &&
				 Game.spr.getSizeX() +  Game.spr.getWidth() >  Game.spike.get(i).getSizeX() &&
				 Game.spr.getSizeY() < Game.spike.get(i).getSizeY() + Game.spike.get(i).getHeight() &&
				 Game.spr.getHeight() + Game.spr.getSizeY() > Game.spike.get(i).getSizeY()) {
			 
			 			//System.out.println("collision detected");
			 			return true;
			 		
			 		}  
				
				}
			return false;
	}
	
	public boolean winningCollision() {
		 if ( Game.spr.getSizeX() <  Game.portal.getSizeX() +  Game.portal.getWidth() &&
				 Game.spr.getSizeX() +  Game.portal.getWidth() >  Game.portal.getSizeX() &&
				 Game.spr.getSizeY() < Game.portal.getSizeY() + Game.portal.getHeight() &&
				 Game.spr.getHeight() + Game.portal.getSizeY() > Game.portal.getSizeY()) {
			 
			 			//System.out.println("collision detected");
			 			return true;
			 		
			 		}  
				
				
			return false;
	}
	
		
}
