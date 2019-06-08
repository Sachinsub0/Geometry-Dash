package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Spike extends Object{

	public Spike(String name, BufferedImage image, int sizeX, int sizeY, int width, int height) {
		super(name, image, sizeX,sizeY, width, height);
		Game.spike.add(this);
	}
	public void update() {
		this.sizeX -= 2;
	}
	public boolean collisionDetected() {
		return true;
	}
	public void draw(Graphics g) {
		g.drawImage(this.image, this.sizeX, this.sizeY, this.width, this.height, null);
	}
}
