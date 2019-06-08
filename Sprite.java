package Objects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import main.Game;
import main.GamePanelListener;

public class Sprite extends Object{

	private int offsetX;
	private int offsetY;
	private boolean isRotated;
	boolean jumping = false;
	public boolean falling = false;
	public boolean grounded = true;
	public boolean isAlive = true;
	int jump_cur = 0;
	int jump_max = 105;
	
	public Sprite(String name,BufferedImage image, int sizeX, int sizeY, int width, int height, int offsetX, int offsetY, boolean isRotated) {
		super(name, image, sizeX, sizeY,width, height);
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.isRotated = isRotated;
	}
	
	public void update() {
		
		if (this.sizeY < 200) {
			this.jumping = false;
			this.falling = true;
		}
		if (this.sizeY > Game.height -(this.height + 55)) {
			
			//System.out.println("OOFERS");
			this.falling = false;
			
		}
	
		this.jump();
		this.fall();
		if (this.isAlive) {
			this.detectCollisionWithBlock();
			} else {
			Game.init();
			this.isAlive = true;
			}
	
	}
	public void fall() {
		this.grounded = false;
		if (this.falling && !this.jumping) {
			this.sizeY += 1;
		}
	}
	public void jump() {
		this.grounded = false;
		if (this.jumping) {
			this.sizeY -= 1;
			if (this.jump_cur > this.jump_max) {
				this.jumping = false;
				this.falling = true;
				this.jump_cur = 0;
			} else {
				this.jump_cur++;
			}
		}
	}
	public void attemptToJump() {
		this.grounded = false;
		if (!this.jumping && !this.falling) {
			this.jumping = true;
			this.falling = false;
			this.jump_cur = 0;
		}
	}
	public void draw(Graphics g) { 
		g.drawImage(this.image, this.sizeX, this.sizeY, this.width, this.height,null);
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	public boolean isRotated() {
		return isRotated;
	}

	public void setRotated(boolean isRotated) {
		this.isRotated = isRotated;
	}

	public void detectCollisionWithBlock() {
		int bX = this.sizeX + this.width /2;
		int bY = this.sizeY + this.height;
		for (int i = 0; i < Game.block.size(); i++) {
			 if ( 	bX > Game.block.get(i).getSizeX() && bX <= Game.block.get(i).getSizeX() + Game.block.get(i).getWidth()) {
				if ( bY >= Game.block.get(i).getSizeY() && bY < Game.block.get(i).getSizeY() + this.sizeY)  {
					System.out.println("Collision");
					if (this.sizeY > Game.block.get(i).getSizeY()) {
						this.isAlive = false;
						//Game.init();
						break;
					} else {
					 this.sizeY = Game.block.get(i).getSizeY() - this.height;
					 this.jumping = false;
					 this.falling = false;
					 break;
					}
				 }
					
				 		} 
			 if (i == Game.block.size() - 1) {
				 this.falling = true;
			 }
			}
	}

	
}
