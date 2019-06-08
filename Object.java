package Objects;


import java.awt.image.BufferedImage;

public class Object {
	String name;
	int sizeX;
	int sizeY;
	int width;	
	int height;
     BufferedImage image;
	
	public Object(String name, BufferedImage image, int sizeX, int sizeY, int width, int height) {
		this.name = name;
		this.image = image;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.width = width;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	
}

