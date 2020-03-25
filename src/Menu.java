import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JButton;

public class Menu {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH / 7 + 150, 170, 100, 50); 
	// public Rectangle settingButton = new Rectangle(Game.WIDTH / 7 + 150, 270, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 7 + 150, 370, 100, 50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font font0 = new Font("arial", Font.BOLD, 50);
		g.setFont(font0);
		g.setColor(Color.WHITE);
		g.drawString("PAC-MAN 4.0", Game.WIDTH / 5 , 120);
		
		Font font1 = new Font("arial", Font.BOLD, 25);
		g.setFont(font1);
		
		g.drawString("Start", playButton.x + 20, playButton.y + 32);
		g2d.draw(playButton);
		// g.drawString("Setting", settingButton.x + 10, settingButton.y + 32);
		// g2d.draw(settingButton);
		g.drawString("Quit", quitButton.x + 25, quitButton.y + 32);
		g2d.draw(quitButton);
	}
}
