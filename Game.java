package main;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Objects.*;
public class Game extends JFrame{
	static JFrame frame;
	public static GamePanel gamePanel;
	
	private static int width = 900;
	public static int height = 600;
	
	JLabel label;
	public static int y = 515;
	public static ArrayList<Spike> spike = new ArrayList<Spike>();
	public static Sprite spr = new Sprite("Bobby", Resources.loadImage("Sprite.png"),10,y,30,30, 0, 0,false);
	public static ArrayList<Block> block = new ArrayList<Block>();
	public static Portal portal = new Portal("Portal", Resources.loadImage("WavePortal.png"),3215,400,50,50);
	public static void main(String[] args) {
		frame = new JFrame("Geometry Dash");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel = new GamePanel();
		new GamePanelListener(gamePanel);
		frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
		frame.setResizable(false);
		gamePanel.setFocusable(true);
		gamePanel.requestFocusInWindow();
		frame.setSize(width, height);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		init();
		update();

		
	}
	public static void update() {
		while (true) {
		spr.update();
			try {
				Thread.sleep(6);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			frame.repaint();
		}
	}
	public static void init() {
			block.clear();
			spike.clear();
			Game.portal.setSizeX(3205);
			
			for (int i = 1250; i < 1500; i++) {
	new Block("Block", Resources.loadImage("Block.png"), i, y - 25,75,75);
			}
			for (int i = 2000; i < 2500; i++) {
			
					new Block("Block", Resources.loadImage("Block.png"), i, y - 25,75,75);
							
			}
			for (int i = 3000; i < 3150; i++) {
				new Block("Block", Resources.loadImage("Block.png"), i, y - 25,75,75);
			}
			
			for (int i = 2100; i < 2140; i += 20) {
				new Spike("Spike", Resources.loadImage("Spike1.png"), i, y - 40,20,20);
			}
			for (int i = 0; i < 100; i++) {
				
			 new Block("Block", Resources.loadImage("Block.png"), i * 32, y + 31, 75,75);
			}
			for (int i = 500; i < 1000; i += 150) {
				new Spike("Spike", Resources.loadImage("Spike1.png"), i, 530,20,20);
				
				
			}
					
		
	}
	
}
