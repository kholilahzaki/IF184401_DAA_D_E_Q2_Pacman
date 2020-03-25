import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	
	private Image ghost, ghost1, ghost2, ghost3;

	public Enemy() {
		ImageIcon img = new ImageIcon("images/enemy.png");
		ghost = img.getImage();
		ImageIcon img1 = new ImageIcon("images/enemy1.png");
		ghost1 = img1.getImage();
		ImageIcon img2 = new ImageIcon("images/enemy2.png");
		ghost2 = img2.getImage();
		ImageIcon img3 = new ImageIcon("images/enemy3.png");
		ghost3 = img3.getImage();
		
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(ghost, 7 * 32, 7 * 32, 32, 32, null);
		g.drawImage(ghost1, 10 * 32, 10 * 32, 32, 32, null);
		g.drawImage(ghost2, 14 * 32, 1 * 32, 32, 32, null);
		g.drawImage(ghost3, 3 * 32, 13 * 32, 32, 32, null);

	}
}
