package main;

import java.awt.event.*;



import javax.swing.Timer;

import Objects.Block;
import Objects.Object;





public class GamePanelListener implements KeyListener, ActionListener{
	private GamePanel gamePanel;
	

	public GamePanelListener(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		gamePanel.addKeyListener(this);
		
		Timer timer = new Timer(30,this);
		timer.start();
		if (gamePanel.winningCollision()) {
			timer.stop();
			Game.block.clear();
			Game.spike.clear();
		}
		
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 int key = e.getKeyCode();    
		 if (key == KeyEvent.VK_UP ) {
			 
				Game.spr.attemptToJump();
			
		 }
		 
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	 	 int key = e.getKeyCode();
		 if (key == KeyEvent.VK_UP) {
			 
			 //System.out.println("Jump");
		 }
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gamePanel.shiftBlockLeft();
		if (gamePanel.detectCollision() ) {
			Game.init();
		}
		
		
		
		
		
		
		
	
	}


	
}
