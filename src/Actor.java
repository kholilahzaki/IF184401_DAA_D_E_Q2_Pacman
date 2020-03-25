import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Actor {
	
	private int tileX = 1;
	private int tileY = 1;
	
	private Image pacman, pacman2;
	
	public int lastDir = 1;
	
	public Actor() {
		ImageIcon img = new ImageIcon("images/p-kanan.png");
		pacman = img.getImage();
		ImageIcon img2 = new ImageIcon("images/p-atas.png");
		pacman2 = img2.getImage();
	}
	
	public void move(int dx, int dy) {
		
		tileX += dx;
		tileY += dy;	
		
	}

	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}
	
	public void render(Graphics g) {
		
		if(lastDir == 1) {
			g.drawImage(pacman, tileX * 32, tileY * 32, 32, 32, null);
		}
		else if(lastDir == -1) {
			g.drawImage(pacman, tileX * 32 + 32, tileY * 32, -32, 32, null);
		}
		else if(lastDir == 2) {
			g.drawImage(pacman2, tileX * 32, tileY * 32, 32, 32, null);
		}
		else if(lastDir == -2) {
			g.drawImage(pacman2, tileX * 32, tileY * 32 + 32, 32, -32, null);
		}
	}
	
}
