package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Portal extends Object {

	public Portal(String name, BufferedImage image, int sizeX, int sizeY, int width, int height) {
		super(name, image, sizeX, sizeY, width, height);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		this.sizeX -= 2;
	}
	public void draw(Graphics g) {
		g.drawImage(this.image, this.sizeX,this.sizeY,this.width,this.height, null);
		
	}

	
}
